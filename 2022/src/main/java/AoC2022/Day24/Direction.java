package AoC2022.Day24;

public enum Direction {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int changeX;
    private final int changeY;

    Direction(int changeX, int changeY) {
        this.changeX = changeX;
        this.changeY = changeY;
    }

    public Position moveInDirection(Position position) {
        return Position.of(position.getX() + changeX, position.getY() + changeY);
    }
}
