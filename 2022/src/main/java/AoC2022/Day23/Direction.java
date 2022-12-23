package AoC2022.Day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Direction {
    NORTH(0, -1),
    NORTH_EAST(1, -1),
    EAST(1, 0),
    SOUTH_EAST(1, 1),
    SOUTH(0, 1),
    SOUTH_WEST(-1, 1),
    WEST(-1, 0),
    NORTH_WEST(-1, -1);

    private final int changeX;
    private final int changeY;

    Direction(int changeX, int changeY) {
        this.changeX = changeX;
        this.changeY = changeY;
    }

    public Position getNextPosition(Position position) {
        return Position.of(position.getX() + changeX, position.getY() + changeY);
    }

    public List<Position> getAdjacentPositions(Position position) {
        return getPositionsFromDirections(position, getAdjacentDirections(this));
    }

    public static List<Position> retrieveAllNearbyPositions(Position position) {
        return getPositionsFromDirections(position, values());
    }

    private Direction[] getAdjacentDirections(Direction direction) {
        return switch (direction) {
            case NORTH -> new Direction[]{NORTH_WEST, NORTH, NORTH_EAST};
            case EAST -> new Direction[]{NORTH_EAST, EAST, SOUTH_EAST};
            case SOUTH -> new Direction[]{SOUTH_EAST, SOUTH, SOUTH_WEST};
            case WEST -> new Direction[]{NORTH_WEST, WEST, SOUTH_WEST};
            default -> throw new IllegalStateException();
        };
    }

    private static List<Position> getPositionsFromDirections(Position position, Direction... directions) {
        return Arrays.stream(directions)
                .map(direction -> direction.getNextPosition(position))
                .collect(Collectors.toList());
    }
}
