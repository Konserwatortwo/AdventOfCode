package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.DirectionUtils;
import AoC2022.common.Position;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FoldingMechanism {

    private static final List<List<Direction>> CONNECTED_DIRECTIONS = List.of(
            List.of(Direction.NORTH, Direction.EAST),
            List.of(Direction.EAST, Direction.SOUTH),
            List.of(Direction.SOUTH, Direction.WEST),
            List.of(Direction.WEST, Direction.NORTH));

    public static void fold(List<Side> sides) {
        foldObvious(sides);
        while (!sides.stream().allMatch(Side::containsAllAdjacent)) {
            foldDoubles(sides);
        }
    }

    private static void foldObvious(List<Side> sides) {
        Map<Position, Side> positionSide = sides.stream().collect(Collectors.toMap(Side::getPosition, Function.identity()));
        for (Side side : sides) {
            for (Direction direction : DirectionUtils.retrieveSimpleDirections()) {
                Position directionPosition = direction.getNextPosition(side.getPosition());
                if (positionSide.containsKey(directionPosition)) {
                    side.addAdjacentSides(direction, positionSide.get(directionPosition));
                }
            }
        }
    }

    private static void foldDoubles(List<Side> sides) {
        for (Side side : sides) {
            Set<Direction> containsDirection = side.getAdjacentDirections();
            CONNECTED_DIRECTIONS.stream()
                    .filter(containsDirection::containsAll)
                    .forEach(directions -> connectWithSameAdjacent(side, directions));
        }
    }

    private static void connectWithSameAdjacent(Side adjacent, List<Direction> directions) {
        Side firstSide = adjacent.getAdjacentSide(directions.get(0));
        Side secondSide = adjacent.getAdjacentSide(directions.get(1));
        if (null == firstSide.getOtherSideDirection(secondSide)) {
            Direction firstDirection = DirectionUtils.retrieveCounterClockwise(firstSide.getOtherSideDirection(adjacent));
            Direction secondDirection = DirectionUtils.retrieveClockwise(secondSide.getOtherSideDirection(adjacent));
            firstSide.addAdjacentSides(firstDirection, secondSide);
            secondSide.addAdjacentSides(secondDirection, firstSide);
        }
    }
}
