package AoC2023.Day14;

import AoC2023.shared.Grid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
enum Direction {

    NORTH(false, x -> x, y -> y - 1),
    SOUTH(true, x -> x, y -> y + 1),
    WEST(false, x -> x - 1, y -> y),
    EAST(true, x -> x + 1, y -> y);

    boolean isReverse;
    Function<Integer, Integer> nextX;
    Function<Integer, Integer> nextY;

    public Grid tilt(Grid previousGrid) {
        Grid grid = previousGrid.copy();
        if (isReverse) {
            grid.reverseIterateOverGrid(
                    (x, y) -> grid.valueAt(x, y) == 'O',
                    (x, y) -> tilt(grid, x, y)
            );
        } else {
            grid.iterateOverGrid(
                    (x, y) -> grid.valueAt(x, y) == 'O',
                    (x, y) -> tilt(grid, x, y)
            );
        }
        return grid;
    }

    private void tilt(Grid grid, int x, int y) {
        int previousX = x;
        int previousY = y;
        x = nextX.apply(x);
        y = nextY.apply(y);
        while (grid.isInGrid(x, y) && grid.valueAt(x, y) == '.') {
            grid.setValueAt(previousX, previousY, '.');
            grid.setValueAt(x, y, 'O');
            previousX = x;
            previousY = y;
            x = nextX.apply(x);
            y = nextY.apply(y);
        }
    }
}
