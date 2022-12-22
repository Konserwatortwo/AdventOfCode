package AoC2022.Day22;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int sizeX;
    private final int sizeY;
    private final Position firstPosition;

    public Board(List<String> input) {
        this.sizeX = input.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        this.sizeY = input.size();
        TileType[][] grid = createGrid(input);



        List<Position> positions = createPositions(grid);
        this.firstPosition = positions.get(0);
        linkPositions(positions);
        createPortalVertical(grid, positions);
        createPortalHorizontal(grid, positions);
    }

    public Position getFirstPosition() {
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

    private List<Position> createPositions(TileType[][] grid) {
        List<Position> listPositions = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (grid[x][y] == TileType.FREE) {
                    listPositions.add(Position.of(x, y));
                }
            }
        }
        return listPositions;
    }

    private void linkPositions(List<Position> positions) {
        for (Position position : positions) {
            for (Direction direction : Direction.values()) {
                Position positionInDirection = direction.moveInDirection(position);
                if (positions.contains(positionInDirection)) {
                    int index = positions.indexOf(positionInDirection);
                    position.addAdjacentPositions(direction, positions.get(index));
                }
            }
        }
    }

    private void createPortalVertical(TileType[][] grid, List<Position> positions) {
        for (int y = 0; y < sizeY; y++) {

            int firstIndex = 0;
            while (grid[firstIndex][y] == TileType.EMPTY && firstIndex < sizeX) {
                firstIndex++;
            }

            int lastIndex = sizeX - 1;
            while (grid[lastIndex][y] == TileType.EMPTY && lastIndex > 0) {
                lastIndex--;
            }

            Position first = Position.of(firstIndex, y);
            Position last = Position.of(lastIndex, y);
            ;
            if (positions.contains(first) && positions.contains(last)) {
                Position realFirst = positions.get(positions.indexOf(first));
                Position realLast = positions.get(positions.indexOf(last));

                realFirst.addAdjacentPositions(Direction.WEST, realLast);
                realLast.addAdjacentPositions(Direction.EAST, realFirst);
            }
        }
    }

    private void createPortalHorizontal(TileType[][] grid, List<Position> positions) {
        for (int x = 0; x < sizeX; x++) {

            int firstIndex = 0;
            while (grid[x][firstIndex] == TileType.EMPTY && firstIndex < sizeY) {
                firstIndex++;
            }

            int lastIndex = sizeY - 1;
            while (grid[x][lastIndex] == TileType.EMPTY && lastIndex > 0) {
                lastIndex--;
            }

            Position first = Position.of(x, firstIndex);
            Position last = Position.of(x, lastIndex);
            if (positions.contains(first) && positions.contains(last)) {
                Position realFirst = positions.get(positions.indexOf(first));
                Position realLast = positions.get(positions.indexOf(last));

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
