package AoC2022.common;

import java.util.List;
import java.util.Set;

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


}
