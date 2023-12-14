package AoC2023.Day10;

import AoC2023.shared.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Area extends Grid {

    private Area(char[][] grid) {
        super(grid);
    }

    public static Area of(List<String> inputList) {
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
        return new Area(createdGrid);
    }

    public char valueAt(Position position) {
        return valueAt(position.getX(), position.getY());
    }

    public void setValueAt(Position position, char value) {
        setValueAt(position.getX(), position.getY(), value);
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
            if (!isInGrid(currentPosition.getX(), currentPosition.getY())) {
                return List.of();
            }
            currentDirection = currentDirection.determineNextDirection(valueAt(currentPosition));
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
                if ('S' == valueAt(x, y)) {
                    return Position.of(x, y);
                }
            }
        }
        throw new IllegalStateException("Starting Position not found");
    }

    public Area extendArea() {
        Area extendedArea = generateExtendedAreaFromCurrent();
        extendedArea.extendTunnels();
        return extendedArea;
    }

    private Area generateExtendedAreaFromCurrent() {
        char[][] extendedArea = new char[maxY * 2 - 1][maxX * 2 - 1];
        for (int y = 1; y < maxY; y++) {
            Arrays.fill(extendedArea[y * 2 - 1], 'x');
            Arrays.fill(extendedArea[y * 2], 'x');
            extendedArea[y * 2 - 1][0] = '0';
            extendedArea[y * 2 - 1][extendedArea[0].length - 1] = '0';
            for (int x = 0; x < maxX; x++) {
                extendedArea[y * 2][x * 2] = valueAt(x, y);
            }
        }
        Arrays.fill(extendedArea[0], '0');
        Arrays.fill(extendedArea[extendedArea.length - 1], '0');
        return new Area(extendedArea);
    }

    private void extendTunnels() {
        for (int y = 2; y < maxY - 1; y += 2) {
            for (int x = 3; x < maxX - 3; x += 2) {
                if (List.of('-', 'F', 'L', 'S').contains(valueAt(x - 1, y))
                        && List.of('-', '7', 'J', 'S').contains(valueAt(x + 1, y))) {
                    setValueAt(x, y, '-');
                }
            }
        }
        for (int y = 3; y < maxY - 3; y += 2) {
            for (int x = 2; x < maxX - 1; x += 2) {
                if (List.of('|', 'F', '7', 'S').contains(valueAt(x, y - 1))
                        && List.of('|', 'L', 'J', 'S').contains(valueAt(x, y + 1))) {
                    setValueAt(x, y, '|');
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
                    if (!loop.contains(nearbyPosition) && valueAt(nearbyPosition) != '0') {
                        setValueAt(nearbyPosition, '0');
                        nextCurrentPositions.add(nearbyPosition);
                    }
                }
            }
            currentPositions = nextCurrentPositions;
        }
    }

    private int calculateEmptySpaces() {
        int emptyPlaces = 0;
        for (int y = 2; y < maxY - 1; y += 2) {
            for (int x = 2; x < maxX - 1; x += 2) {
                if (valueAt(x, y) != '0') {
                    emptyPlaces++;
                }
            }
        }
        return emptyPlaces;
    }
}
