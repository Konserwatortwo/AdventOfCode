package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.DirectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cube extends Board {
    private final int sideSize;
    private final List<Side> sides;

    public Cube(List<String> input, int sideSize) {
        super(input);
        this.sideSize = sideSize;
        sides = createSides();
        foldCube();
        assignBorderPoints();
    }

    private List<Side> createSides() {
        List<Side> sides = new ArrayList<>();
        int numberOfCubesHorizontal = sizeX / sideSize;
        int numberOfCubesVertical = sizeY / sideSize;

        for (int vertical = 0; vertical < numberOfCubesVertical; vertical++) {
            for (int horizontal = 0; horizontal < numberOfCubesHorizontal; horizontal++) {
                int startingX = horizontal * sideSize;
                int startingY = vertical * sideSize;
                if (grid[startingX][startingY] != TileType.EMPTY) {
                    ExtendedPosition[][] sideGrid = createSideGrid(startingX, startingY);
                    sides.add(new Side(createMapOfBorderPoints(sideGrid)));
                }
            }
        }
        return sides;
    }

    private ExtendedPosition[][] createSideGrid(int startingX, int startingY) {
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

    public Map<Direction, List<ExtendedPosition>> createMapOfBorderPoints(ExtendedPosition[][] sideGrid) {
        return DirectionUtils.retrieveSimpleDirections().stream()
                .collect(Collectors.toMap(Function.identity(), direction -> getPointsOnBorder(direction, sideGrid)));
    }

    public List<ExtendedPosition> getPointsOnBorder(Direction direction, ExtendedPosition[][] sideGrid) {
        Function<Integer, ExtendedPosition> mappingFunction = switch (direction) {
            case NORTH -> x -> sideGrid[x][0];
            case SOUTH -> x -> sideGrid[x][sideSize - 1];
            case EAST -> y -> sideGrid[sideSize - 1][y];
            case WEST -> y -> sideGrid[0][y];
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
        return IntStream.range(0, sideSize).mapToObj(mappingFunction::apply).collect(Collectors.toList());
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
