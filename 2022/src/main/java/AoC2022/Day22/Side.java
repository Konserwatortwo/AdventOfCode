package AoC2022.Day22;

import AoC2022.common.Direction;

import java.util.*;

public class Side {
    private final Map<Direction, Side> adjacentSides;
    private final Map<Direction, List<ExtendedPosition>> pointsOnBorder;

    public Side(Map<Direction, List<ExtendedPosition>> pointsOnBorder) {
        this.pointsOnBorder = pointsOnBorder;
        this.adjacentSides = new HashMap<>();
    }

    public void addAdjacentSides(Direction direction, Side side) {
        adjacentSides.put(direction, side);
    }

    public void addAllAdjacentSides(Side north, Side east, Side south, Side west) {
        adjacentSides.put(Direction.NORTH, north);
        adjacentSides.put(Direction.EAST, east);
        adjacentSides.put(Direction.SOUTH, south);
        adjacentSides.put(Direction.WEST, west);
    }

    public Direction getOtherSideDirection(Side side) {
        return adjacentSides.entrySet().stream()
                .filter(e -> e.getValue() == side)
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    public void assignPointsForDirection(Direction direction) {
        Side otherSide = adjacentSides.get(direction);
        Direction otherDirection = otherSide.getOtherSideDirection(this);
        List<ExtendedPosition> borderPositions = pointsOnBorder.get(direction);
        List<ExtendedPosition> otherBorderPositions = new ArrayList<>(otherSide.pointsOnBorder.get(otherDirection));

        if (shouldReverseOrder(direction, otherDirection)) {
            Collections.reverse(otherBorderPositions);
        }

        for (int i = 0; i < borderPositions.size(); i++) {
            ExtendedPosition borderPosition = borderPositions.get(i);
            ExtendedPosition otherBorderPosition = otherBorderPositions.get(i);
            if (null != borderPosition && null != otherBorderPosition) {
                borderPosition.addAdjacentPositions(direction, otherBorderPosition);
                borderPosition.setSide(this);
            }
        }
    }

    private boolean shouldReverseOrder(Direction direction, Direction otherDirection) {
        Set<Direction> rightOrderDirections = Set.of(Direction.NORTH, Direction.EAST);
        return rightOrderDirections.contains(direction) == rightOrderDirections.contains(otherDirection);
    }
}
