package AoC2022.Day22;

import AoC2022.common.DirectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Cube extends Board {
    private final int sideSize;
    private final List<Side> sides;

    public Cube(List<String> input, int sideSize) {
        super(input);
        this.sideSize = sideSize;
        sides = createSides(grid, positions);
        foldCube();
        assignBorderPoints();
    }

    private List<Side> createSides(TileType[][] grid, List<ExtendedPosition> positions) {
        List<Side> sides = new ArrayList<>();
        int numberOfCubesHorizontal = sizeX / sideSize;
        int numberOfCubesVertical = sizeY / sideSize;

        for (int vertical = 0; vertical < numberOfCubesVertical; vertical++) {
            for (int horizontal = 0; horizontal < numberOfCubesHorizontal; horizontal++) {
                int startingX = horizontal * sideSize;
                int startingY = vertical * sideSize;
                if (grid[startingX][startingY] != TileType.EMPTY) {
                    sides.add(new Side(createSideGrid(grid, positions, startingX, startingY)));
                }
            }
        }
        return sides;
    }

    private ExtendedPosition[][] createSideGrid(TileType[][] grid, List<ExtendedPosition> positions, int startingX, int startingY) {
        ExtendedPosition[][] sideGrid = new ExtendedPosition[sideSize][sideSize];
        for (int y = 0; y < sideSize; y++) {
            for (int x = 0; x < sideSize; x++) {
                int otherX = startingX + x;
                int otherY = startingY + y;
                if (grid[otherX][otherY] == TileType.FREE) {
                    sideGrid[x][y] = positions.get(positions.indexOf(ExtendedPosition.of(otherX, otherY)));
                }
            }
        }
        return sideGrid;
    }

    private void foldCube() {
        sides.get(0).addAllAdjacentSides(sides.get(1), sides.get(5), sides.get(3), sides.get(2));
        sides.get(1).addAllAdjacentSides(sides.get(0), sides.get(2), sides.get(4), sides.get(5));
        sides.get(2).addAllAdjacentSides(sides.get(0), sides.get(3), sides.get(4), sides.get(1));
        sides.get(3).addAllAdjacentSides(sides.get(0), sides.get(5), sides.get(4), sides.get(2));
        sides.get(4).addAllAdjacentSides(sides.get(3), sides.get(5), sides.get(1), sides.get(2));
        sides.get(5).addAllAdjacentSides(sides.get(3), sides.get(0), sides.get(1), sides.get(4));


//        sides.get(0).addAllAdjacentSides(sides.get(5), sides.get(1), sides.get(2), sides.get(3));
//        sides.get(1).addAllAdjacentSides(sides.get(5), sides.get(4), sides.get(2), sides.get(0));
//        sides.get(2).addAllAdjacentSides(sides.get(0), sides.get(1), sides.get(4), sides.get(3));
//        sides.get(3).addAllAdjacentSides(sides.get(2), sides.get(4), sides.get(5), sides.get(0));
//        sides.get(4).addAllAdjacentSides(sides.get(2), sides.get(1), sides.get(5), sides.get(3));
//        sides.get(5).addAllAdjacentSides(sides.get(3), sides.get(4), sides.get(1), sides.get(0));

        // TODO Fold
    }

    public void assignBorderPoints() {
        for (Side side : sides) {
            DirectionUtils.retrieveSimpleDirections().forEach(side::assignPointsForDirection);
        }
    }
}
