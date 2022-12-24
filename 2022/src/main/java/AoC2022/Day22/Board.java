package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.DirectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int sizeX;
    private final int sizeY;
    private final ExtendedPosition firstPosition;

    public Board(List<String> input) {
        this.sizeX = input.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        this.sizeY = input.size();
        TileType[][] grid = createGrid(input);


        List<ExtendedPosition> positions = createPositions(grid);
        this.firstPosition = positions.get(0);
        linkPositions(positions);
        createPortalVertical(grid, positions);
        createPortalHorizontal(grid, positions);
    }

    public ExtendedPosition getFirstPosition() {
        return firstPosition;
    }

    private TileType[][] createGrid(List<String> input) {
        TileType[][] grid = new TileType[sizeX][sizeY];
        int currentY = 0;
        for (String line : input) {
            int firstSign = line.length() - line.trim().length();
            char[] charArray = line.toCharArray();
            for (int x = 0; x < sizeX; x++) {
                if (x >= firstSign && x < charArray.length) {
                    grid[x][currentY] = TileType.determineType(charArray[x]);
                } else {
                    grid[x][currentY] = TileType.EMPTY;
                }
            }
            currentY++;
        }
        return grid;
    }

    private List<ExtendedPosition> createPositions(TileType[][] grid) {
        List<ExtendedPosition> listPositions = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (grid[x][y] == TileType.FREE) {
                    listPositions.add(ExtendedPosition.of(x, y));
                }
            }
        }
        return listPositions;
    }

    private void linkPositions(List<ExtendedPosition> positions) {
        for (ExtendedPosition position : positions) {
            for (Direction direction : DirectionUtils.retrieveSimpleDirections()) {
                ExtendedPosition positionInDirection = ExtendedPosition.of(direction.getNextPosition(position));
                if (positions.contains(positionInDirection)) {
                    int index = positions.indexOf(positionInDirection);
                    position.addAdjacentPositions(direction, positions.get(index));
                }
            }
        }
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
            ;
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

    public void printBoard(TileType[][] grid) {
        for (int y = 0; y < sizeY; y++) {
            StringBuilder builder = new StringBuilder();
            for (int x = 0; x < sizeX; x++) {
                builder.append(grid[x][y].getSign());
            }
            System.out.println(builder);
        }
    }
}
