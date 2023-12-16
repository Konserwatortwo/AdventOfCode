package AoC2023.Day14;

import AoC2023.shared.Direction;
import AoC2023.shared.Grid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Platform {

    Grid startingGrid;

    public static Platform of(List<String> inputValue) {
        return new Platform(Grid.of(inputValue));
    }

    public long tiltNorthAndCountBalance() {
        return countBalance(tilt(startingGrid, Direction.NORTH));
    }

    private static long countBalance(Grid grid) {
        return grid.sumGrid(
                (x, y) -> grid.valueAt(x, y) == 'O',
                (x, y) -> (long) (grid.getMaxY() - y)
        );
    }

    public long findCyclesAndCountBalanceFor(long numberOfCycles) {
        return countBalance(countCyclesInsideCycles(numberOfCycles));
    }

    private Grid countCyclesInsideCycles(long numberOfCycles) {
        List<Grid> differentGrids = new ArrayList<>();
        Grid currentGrid = startingGrid;
        while (!differentGrids.contains(currentGrid)) {
            differentGrids.add(currentGrid);
            currentGrid = cycle(currentGrid);
        }
        if (numberOfCycles < differentGrids.size()) {
            return differentGrids.get((int) numberOfCycles);
        }
        int firstElementOfCycle = differentGrids.indexOf(currentGrid);
        int elementsInCycle = differentGrids.size() - firstElementOfCycle;
        long numberOfSearchingElement = (numberOfCycles - firstElementOfCycle) % elementsInCycle;
        return differentGrids.get((int) numberOfSearchingElement + firstElementOfCycle);
    }

    private static Grid cycle(Grid previousGrid) {
        Grid newGrid = tilt(previousGrid, Direction.NORTH);
        newGrid = tilt(newGrid, Direction.WEST);
        newGrid = tilt(newGrid, Direction.SOUTH);
        newGrid = tilt(newGrid, Direction.EAST);
        return newGrid;
    }

    private static Grid tilt(Grid previousGrid, Direction direction) {
        Grid grid = previousGrid.copy();
        if (EnumSet.of(Direction.SOUTH, Direction.EAST).contains(direction)) {
            grid.reverseIterateOverGrid(
                    (x, y) -> grid.valueAt(x, y) == 'O',
                    (x, y) -> tilt(x, y, grid, direction)
            );
        } else {
            grid.iterateOverGrid(
                    (x, y) -> grid.valueAt(x, y) == 'O',
                    (x, y) -> tilt(x, y, grid, direction)
            );
        }
        return grid;
    }

    private static void tilt(int x, int y, Grid grid, Direction direction) {
        int previousX = x;
        int previousY = y;
        x = direction.nextX(x);
        y = direction.nextY(y);
        while (grid.isInGrid(x, y) && grid.valueAt(x, y) == '.') {
            grid.setValueAt(previousX, previousY, '.');
            grid.setValueAt(x, y, 'O');
            previousX = x;
            previousY = y;
            x = direction.nextX(x);
            y = direction.nextY(y);
        }
    }
}
