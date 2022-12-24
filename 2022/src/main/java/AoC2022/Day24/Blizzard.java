package AoC2022.Day24;


public class Blizzard {
    private final Direction direction;
    private Position position;

    public Blizzard(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getNextPosition() {
        return direction.moveInDirection(position);
    }
}
