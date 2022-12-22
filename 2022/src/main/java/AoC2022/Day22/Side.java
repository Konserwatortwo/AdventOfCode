package AoC2022.Day22;

import java.util.*;

public class Side {

    private Position position;

    private Map<Direction, Side> adjacentSides;

    private Position[][] grid;

    public Side(Position position, Position[][] grid) {
        this.grid = grid;
        this.position = position;
        this.adjacentSides = new HashMap<>();
    }

    public Position[][] getGrid() {
        return grid;
    }

    public Position getPosition() {
        return position;
    }

    public Map<Direction, Side> getAdjacentSides() {
        return adjacentSides;
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

    public List<Position> getPointsOnBorder(Direction direction) {
        List<Position> result = new ArrayList<>();
        switch (direction) {
            case NORTH -> {
                for (int x = 0; x < grid.length; x++) {
                    result.add(grid[x][0]);
                }
            }
            case SOUTH -> {
                for (int x = 0; x < grid.length; x++) {
                    result.add(grid[x][grid.length - 1]);
                }
            }
            case EAST -> {
                for (int y = 0; y < grid.length; y++) {
                    result.add(grid[grid.length - 1][y]);
                }
            }
            case WEST -> {
                for (int y = 0; y < grid.length; y++) {
                    result.add(grid[0][y]);
                }
            }
        }
        return result;
    }

    public Direction getOtherSideDirection(Side side) {
        return adjacentSides.entrySet().stream()
                .filter(e -> e.getValue() == side)
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    public void assignBorderPoints() {
        asssignPointsForDirection(Direction.NORTH);
        asssignPointsForDirection(Direction.SOUTH);
        asssignPointsForDirection(Direction.EAST);
        asssignPointsForDirection(Direction.WEST);
    }


    public void asssignPointsForDirection(Direction direction) {
        Direction otherDirection = adjacentSides.get(direction).getOtherSideDirection(this);
        boolean isRightSide = direction == Direction.NORTH || direction == Direction.EAST;
        boolean isRightOtherSide = otherDirection == Direction.NORTH || otherDirection == Direction.EAST;
        boolean shouldReversOrder = isRightSide == isRightOtherSide;

        List<Position> borderPositions = getPointsOnBorder(direction);
        List<Position> otherBorderPositions = adjacentSides.get(direction).getPointsOnBorder(otherDirection);

        if (shouldReversOrder) {
            Collections.reverse(otherBorderPositions);
        }

        for (int i = 0; i < borderPositions.size(); i++) {
            Position borderPosition = borderPositions.get(i);
            Position otherBorderPosition = otherBorderPositions.get(i);
            if (null != borderPosition && null != otherBorderPosition) {
                borderPosition.addAdjacentPositions(direction, otherBorderPosition);
                borderPosition.setSide(this);
            }
        }
    }
}
