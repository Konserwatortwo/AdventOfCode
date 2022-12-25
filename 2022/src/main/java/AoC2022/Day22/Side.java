package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.DirectionUtils;
import AoC2022.common.Position;

import java.util.*;

public class Side {
    private final Position position;
    private final Map<Direction, Side> adjacentSides;
    private final Map<Direction, List<ExtendedPosition>> pointsOnBorder;

    public Side(Position position, Map<Direction, List<ExtendedPosition>> pointsOnBorder) {
        this.position = position;
        this.pointsOnBorder = pointsOnBorder;
        this.adjacentSides = new HashMap<>();
    }

    public Position getPosition() {
        return position;
    }

    public Set<Direction> getAdjacentDirections() {
        return adjacentSides.keySet();
    }

    public boolean containsAllAdjacent() {
        return DirectionUtils.retrieveSimpleDirections().stream().allMatch(adjacentSides::containsKey);
    }

    public Side getAdjacentSide(Direction direction) {
        return adjacentSides.get(direction);
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
                .orElse(null);
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
