package AoC2023.Day10;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
class Grid {

    char[][] grid;
    int maxX;
    int maxY;

    private Grid(char[][] grid) {
        this.grid = grid;
        this.maxX = grid[0].length;
        this.maxY = grid.length;
    }

    public static Grid of(List<String> inputList) {
        assert inputList.size() > 1;
        char[][] createdGrid = new char[inputList.size() + 2][inputList.get(0).length() + 2];
        Arrays.fill(createdGrid[0], '0');
        Arrays.fill(createdGrid[inputList.size() + 1], '0');
        for (int y = 0; y < inputList.size(); y++) {
            char[] lineArray = inputList.get(y).toCharArray();
            createdGrid[y + 1][0] = '0';
            createdGrid[y + 1][lineArray.length + 1] = '0';
            System.arraycopy(lineArray, 0, createdGrid[y + 1], 1, lineArray.length);
        }
        return new Grid(createdGrid);
    }

    public List<Position> calculateLoop() {
        return Arrays.stream(Direction.values())
                .map(this::calculateLoopForDirection)
                .filter(x -> x.size() > 0)
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }

    private List<Position> calculateLoopForDirection(Direction startingDirection) {
        Position startingPosition = findStartingPosition();
        Position currentPosition = startingPosition;
        Direction currentDirection = startingDirection;
        List<Position> loop = new ArrayList<>();
        do {
            currentPosition = currentDirection.determineNextPosition(currentPosition);
            if (!currentPosition.isInRange(maxX, maxY)) {
                return List.of();
            }
            currentDirection = currentDirection.determineNextDirection(grid[currentPosition.getY()][currentPosition.getX()]);
            if (null == currentDirection) {
                return List.of();
            }
            loop.add(currentPosition);
        } while (!startingPosition.equals(currentPosition));
        return loop;
    }

    private Position findStartingPosition() {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if ('S' == grid[y][x]) {
                    return Position.of(x, y);
                }
            }
        }
        throw new IllegalStateException("Starting Position not found");
    }

    public Grid extendGrid() {
        Grid extendedGrid = generateExtendedGridFromCurrent();
        extendedGrid.extendTunnels();
        return extendedGrid;
    }

    private Grid generateExtendedGridFromCurrent() {
        char[][] extendedGrid = new char[maxY * 2 - 1][grid[0].length * 2 - 1];
        for (int y = 1; y < maxY; y++) {
            Arrays.fill(extendedGrid[y * 2 - 1], 'x');
            Arrays.fill(extendedGrid[y * 2], 'x');
            extendedGrid[y * 2 - 1][0] = '0';
            extendedGrid[y * 2 - 1][extendedGrid[0].length - 1] = '0';
            for (int x = 0; x < maxX; x++) {
                extendedGrid[y * 2][x * 2] = grid[y][x];
            }
        }
        Arrays.fill(extendedGrid[0], '0');
        Arrays.fill(extendedGrid[extendedGrid.length - 1], '0');
        return new Grid(extendedGrid);
    }

    private void extendTunnels() {
        for (int y = 2; y < maxY - 1; y += 2) {
            for (int x = 3; x < maxX - 3; x += 2) {
                if (List.of('-', 'F', 'L', 'S').contains(grid[y][x - 1])
                        && List.of('-', '7', 'J', 'S').contains(grid[y][x + 1])) {
                    grid[y][x] = '-';
                }
            }
        }
        for (int y = 3; y < maxY - 3; y += 2) {
            for (int x = 2; x < maxX - 1; x += 2) {
                if (List.of('|', 'F', '7', 'S').contains(grid[y - 1][x])
                        && List.of('|', 'L', 'J', 'S').contains(grid[y + 1][x])) {
                    grid[y][x] = '|';
                }
            }
        }
    }

    public int retrieveNumberOfEmptySpacesInsideLoop() {
        List<Position> loop = calculateLoop();
        determineSpacesInsideLoop(loop);
        return calculateEmptySpaces() - loop.size() / 2;
    }

    private void determineSpacesInsideLoop(List<Position> loop) {
        List<Position> currentPositions = new ArrayList<>();
        currentPositions.add(Position.of(1, 1));
        while (!currentPositions.isEmpty()) {
            List<Position> nextCurrentPositions = new ArrayList<>();
            for (Position currentPosition : currentPositions) {
                for (Position nearbyPosition : currentPosition.nearbyPositions()) {
                    if (!loop.contains(nearbyPosition)
                            && grid[nearbyPosition.getY()][nearbyPosition.getX()] != '0') {
                        grid[nearbyPosition.getY()][nearbyPosition.getX()] = '0';
                        nextCurrentPositions.add(nearbyPosition);
                    }
                }
            }
            currentPositions = nextCurrentPositions;
        }
    }

    private int calculateEmptySpaces() {
        int emptyPlaces = 0;
        for (int y = 2; y < grid.length - 1; y += 2) {
            for (int x = 2; x < grid[0].length - 1; x += 2) {
                if (grid[y][x] != '0') {
                    emptyPlaces++;
                }
            }
        }
        return emptyPlaces;
    }
}
