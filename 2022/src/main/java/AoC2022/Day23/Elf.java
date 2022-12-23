package AoC2022.Day23;

import java.util.List;
import java.util.Queue;

public class Elf {
    private Position currentPosition;
    private Position consideredPosition;

    public Elf(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Position getConsideredPosition() {
        return consideredPosition;
    }

    public boolean shouldMoveInThisRound(List<Position> otherPositions) {
        return !arePositionsFree(Direction.retrieveAllNearbyPositions(currentPosition), otherPositions);
    }

    private boolean arePositionsFree(List<Position> checkingPositions, List<Position> occupiedPositions) {
        return checkingPositions.stream().noneMatch(occupiedPositions::contains);
    }

    public boolean considerNextPosition(List<Position> otherPositions, Queue<Direction> directionsOrder) {
        consideredPosition = null;
        while (!directionsOrder.isEmpty() && consideredPosition == null) {
            Direction nextDirection = directionsOrder.remove();
            if (arePositionsFree(nextDirection.getAdjacentPositions(currentPosition), otherPositions)) {
                consideredPosition = nextDirection.getNextPosition(currentPosition);
            }
        }
        return consideredPosition != null;
    }

    public void moveToConsideredPosition() {
        currentPosition = consideredPosition;
    }
}
