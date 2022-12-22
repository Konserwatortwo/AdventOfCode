package AoC2022.Day22;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    private final int coordinateX;
    private final int coordinateY;
    private final Map<Direction, Position> adjacentPositions;

    private Side side;

    public Position(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.adjacentPositions = new HashMap<>();
    }

    public static Position of(int coordinateX, int coordinateY) {
        return new Position(coordinateX, coordinateY);
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }

    public void addAdjacentPositions(Direction direction, Position position) {
        adjacentPositions.put(direction, position);
    }

    public boolean canMoveInDirection(Direction direction) {
        return adjacentPositions.containsKey(direction);
    }

    public Position moveInDirection(Direction direction) {
        return adjacentPositions.get(direction);
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return coordinateX == position.coordinateX && coordinateY == position.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }

    @Override
    public String toString() {
        return coordinateX + " : " + coordinateY;
    }
}
