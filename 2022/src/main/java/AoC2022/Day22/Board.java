package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.DirectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {
    protected final int sizeX;
    protected final int sizeY;
    protected final TileType[][] grid;
    protected final List<ExtendedPosition> positions;
    protected final ExtendedPosition firstPosition;

    public Board(List<String> input) {
        this.sizeX = input.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        this.sizeY = input.size();
        this.grid = createGrid(input);
        this.positions = createPositions();
        linkPositions();
        this.firstPosition = positions.get(0);
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

    private List<ExtendedPosition> createPositions() {
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

    private void linkPositions() {
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
}
