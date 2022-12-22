package AoC2022.Day22;

public enum Direction {

    NORTH(0, -1, 3),

    EAST(1, 0, 0),

    SOUTH(0, 1, 1),

    WEST(-1, 0, 2);

    private final int changeX;
    private final int changeY;
    private final int valueForPassword;

    Direction(int changeX, int changeY, int valueForPassword) {
        this.changeX = changeX;
        this.changeY = changeY;
        this.valueForPassword = valueForPassword;
    }

    public int getValueForPassword() {
        return valueForPassword;
    }

    public Position moveInDirection(Position position) {
        return Position.of(position.getX() + changeX, position.getY() + changeY);
    }

    public Direction rotationClockwise() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Direction rotationCounterClockwise() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }
}
