package AoC2022.Day22;

import AoC2022.common.Direction;

import java.util.List;

public class Plain extends Board {

    public Plain(List<String> input) {
        super(input);
        createPortalVertical(grid, positions);
        createPortalHorizontal(grid, positions);
    }

    private void createPortalVertical(TileType[][] grid, List<ExtendedPosition> positions) {
        for (int y = 0; y < sizeY; y++) {

            int firstIndex = 0;
            while (grid[firstIndex][y] == TileType.EMPTY && firstIndex < sizeX) {
                firstIndex++;
            }

            int lastIndex = sizeX - 1;
            while (grid[lastIndex][y] == TileType.EMPTY && lastIndex > 0) {
                lastIndex--;
            }

            ExtendedPosition first = ExtendedPosition.of(firstIndex, y);
            ExtendedPosition last = ExtendedPosition.of(lastIndex, y);

            if (positions.contains(first) && positions.contains(last)) {
                ExtendedPosition realFirst = positions.get(positions.indexOf(first));
                ExtendedPosition realLast = positions.get(positions.indexOf(last));

                realFirst.addAdjacentPositions(Direction.WEST, realLast);
                realLast.addAdjacentPositions(Direction.EAST, realFirst);
            }
        }
    }

    private void createPortalHorizontal(TileType[][] grid, List<ExtendedPosition> positions) {
        for (int x = 0; x < sizeX; x++) {

            int firstIndex = 0;
            while (grid[x][firstIndex] == TileType.EMPTY && firstIndex < sizeY) {
                firstIndex++;
            }

            int lastIndex = sizeY - 1;
            while (grid[x][lastIndex] == TileType.EMPTY && lastIndex > 0) {
                lastIndex--;
            }

            ExtendedPosition first = ExtendedPosition.of(x, firstIndex);
            ExtendedPosition last = ExtendedPosition.of(x, lastIndex);

            if (positions.contains(first) && positions.contains(last)) {
                ExtendedPosition realFirst = positions.get(positions.indexOf(first));
                ExtendedPosition realLast = positions.get(positions.indexOf(last));

                realFirst.addAdjacentPositions(Direction.NORTH, realLast);
                realLast.addAdjacentPositions(Direction.SOUTH, realFirst);
            }
        }
    }
}
