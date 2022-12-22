package AoC2022.Day22;

import java.util.ArrayList;
import java.util.List;

public class Cube {
    private final int sizeX;
    private final int sizeY;
    private final int sideSize;
    private final Position firstPosition;

    public Cube(List<String> input, int sideSize) {
        this.sizeX = input.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        this.sizeY = input.size();
        this.sideSize = sideSize;

        TileType[][] grid = createGrid(input);
        List<Position> positions = createPositions(grid);
        this.firstPosition = positions.get(0);
        linkPositions(positions);
        List<Side> sides = cutToCubes(grid, positions);

        foldCube(sides);

        sides.forEach(Side::assignBorderPoints);
        int alfa = 0;
    }

    private void foldCube(List<Side> sides) {
//        sides.get(0).addAllAdjacentSides(sides.get(1), sides.get(5), sides.get(3), sides.get(2));
//        sides.get(1).addAllAdjacentSides(sides.get(0), sides.get(2), sides.get(4), sides.get(5));
//        sides.get(2).addAllAdjacentSides(sides.get(0), sides.get(3), sides.get(4), sides.get(1));
//        sides.get(3).addAllAdjacentSides(sides.get(0), sides.get(5), sides.get(4), sides.get(2));
//        sides.get(4).addAllAdjacentSides(sides.get(3), sides.get(5), sides.get(1), sides.get(2));
//        sides.get(5).addAllAdjacentSides(sides.get(3), sides.get(0), sides.get(1), sides.get(4));


        sides.get(0).addAllAdjacentSides(sides.get(5), sides.get(1), sides.get(2), sides.get(3));
        sides.get(1).addAllAdjacentSides(sides.get(5), sides.get(4), sides.get(2), sides.get(0));
        sides.get(2).addAllAdjacentSides(sides.get(0), sides.get(1), sides.get(4), sides.get(3));
        sides.get(3).addAllAdjacentSides(sides.get(2), sides.get(4), sides.get(5), sides.get(0));
        sides.get(4).addAllAdjacentSides(sides.get(2), sides.get(1), sides.get(5), sides.get(3));
        sides.get(5).addAllAdjacentSides(sides.get(3), sides.get(4), sides.get(1), sides.get(0));



        return;

        // TODO

//        int numberOfCubesHorizontal = sizeX / sideSize;
//        int numberOfCubesVertical = sizeY / sideSize;
//
//        Side[][] alternativeGrid = new Side[numberOfCubesHorizontal][numberOfCubesVertical];
//
//        for (int vertical = 0; vertical < numberOfCubesVertical; vertical++) {
//            for (int horizontal = 0; horizontal < numberOfCubesHorizontal; horizontal++) {
//
//            }
//        }
    }

    private List<Side> cutToCubes(TileType[][] grid, List<Position> positions) {
        List<Side> sides = new ArrayList<>();
        int numberOfCubesHorizontal = sizeX / sideSize;
        int numberOfCubesVertical = sizeY / sideSize;

        for (int vertical = 0; vertical < numberOfCubesVertical; vertical++) {
            for (int horizontal = 0; horizontal < numberOfCubesHorizontal; horizontal++) {
                int startingX = horizontal * sideSize;
                int startingY = vertical * sideSize;
                if (grid[startingX][startingY] != TileType.EMPTY) {


                    sides.add(new Side(Position.of(horizontal, vertical), createSideGrid(grid, positions, startingX, startingY)));
                }
            }
        }
        return sides;
    }

    private Position[][] createSideGrid(TileType[][] grid, List<Position> positions, int startingX, int startingY) {
        Position[][] sideGrid = new Position[sideSize][sideSize];

        for (int y = 0; y < sideSize; y++) {
            for (int x = 0; x < sideSize; x++) {
                int otherX = startingX + x;
                int otherY = startingY + y;
                if (grid[otherX][otherY] == TileType.FREE) {
                    sideGrid[x][y] = positions.get(positions.indexOf(Position.of(otherX, otherY)));
                }
            }
        }
        return sideGrid;
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

    public void printSide(TileType[][] grid) {
        for (int y = 0; y < sideSize; y++) {
            StringBuilder builder = new StringBuilder();
            for (int x = 0; x < sideSize; x++) {
                builder.append(grid[x][y].getSign());
            }
            System.out.println(builder);
        }
    }

}
