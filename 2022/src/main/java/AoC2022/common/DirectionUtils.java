package AoC2022.common;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DirectionUtils {

    public static Set<Direction> retrieveSimpleDirections() {
        return Set.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    }

    public static Direction retrieveClockwise(Direction direction) {
        return switch (direction) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }

    public static Direction retrieveCounterClockwise(Direction direction) {
        return switch (direction) {
            case NORTH -> Direction.WEST;
            case EAST -> Direction.NORTH;
            case SOUTH -> Direction.EAST;
            case WEST -> Direction.SOUTH;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }

    public static Direction retrieveOpposite(Direction direction) {
        return switch (direction) {
            case NORTH -> Direction.SOUTH;
            case EAST -> Direction.WEST;
            case SOUTH -> Direction.NORTH;
            case WEST -> Direction.EAST;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }

    public static List<Position> retrieveAllNearbyPositions(Position position) {
        return getPositionsFromDirections(position, Direction.values());
    }

    private static List<Position> getPositionsFromDirections(Position position, Direction... directions) {
        return Arrays.stream(directions)
                .map(direction -> direction.getNextPosition(position))
                .collect(Collectors.toList());
    }

    public static List<Position> retrieveAdjacentPositions(Position position, Direction direction) {
        return getPositionsFromDirections(position, getAdjacentDirections(direction));
    }

    private static Direction[] getAdjacentDirections(Direction direction) {
        return switch (direction) {
            case NORTH -> new Direction[]{Direction.NORTH_WEST, Direction.NORTH, Direction.NORTH_EAST};
            case EAST -> new Direction[]{Direction.NORTH_EAST, Direction.EAST, Direction.SOUTH_EAST};
            case SOUTH -> new Direction[]{Direction.SOUTH_EAST, Direction.SOUTH, Direction.SOUTH_WEST};
            case WEST -> new Direction[]{Direction.NORTH_WEST, Direction.WEST, Direction.SOUTH_WEST};
            default -> throw new IllegalStateException();
        };
    }
}
