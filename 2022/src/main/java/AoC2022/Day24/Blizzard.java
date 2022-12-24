package AoC2022.Day24;


import AoC2022.common.Direction;
import AoC2022.common.Position;

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
        return direction.getNextPosition(position);
    }
}
