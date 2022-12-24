package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.Position;

import java.util.HashMap;
import java.util.Map;

public class ExtendedPosition extends Position {
    private final Map<Direction, ExtendedPosition> adjacentPositions;

    private Side side;

    public ExtendedPosition(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        this.adjacentPositions = new HashMap<>();
    }

    public static ExtendedPosition of(int coordinateX, int coordinateY) {
        return new ExtendedPosition(coordinateX, coordinateY);
    }

    public static ExtendedPosition of(Position position) {
        return new ExtendedPosition(position.getX(), position.getY());
    }

    public void addAdjacentPositions(Direction direction, ExtendedPosition position) {
        adjacentPositions.put(direction, position);
    }

    public boolean canMoveInDirection(Direction direction) {
        return adjacentPositions.containsKey(direction);
    }

    public ExtendedPosition moveInDirection(Direction direction) {
        return adjacentPositions.get(direction);
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}
