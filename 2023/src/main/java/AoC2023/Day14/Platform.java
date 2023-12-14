package AoC2023.Day14;

import AoC2023.shared.Grid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Platform {

    Grid startingGrid;

    public static Platform of(List<String> inputValue) {
        return new Platform(Grid.of(inputValue));
    }

    public long tiltNorthAndCountBalance() {
        return countBalance(Direction.NORTH.tilt(startingGrid));
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
        Grid newGrid = Direction.NORTH.tilt(previousGrid);
        newGrid = Direction.WEST.tilt(newGrid);
        newGrid = Direction.SOUTH.tilt(newGrid);
        newGrid = Direction.EAST.tilt(newGrid);
        return newGrid;
    }
}
