package AoC2022.Day17;

import java.util.*;
import java.util.stream.Collectors;

public class Board {

    private static final int SIZE_OF_X = 7;
    private static final List<RockType> ORDER_OF_ROCKS = List.of(RockType.LINE, RockType.CROSS, RockType.LETTER, RockType.POLE, RockType.SQUARE);

    private int indexOfRocksType = 0;
    private final String jetPattern;
    private int indexOfJetPattern = 0;
    private long[] peaks;
    private long highestPeak;
    private long lowestPeak;
    private final Map<Long, List<Point>> mapOfFormation;
    private Map<RockType, Cycle> memorisedCycles;

    public Board(List<String> input) {
        jetPattern = input.get(0);
        peaks = new long[SIZE_OF_X];
        highestPeak = 0;
        lowestPeak = 0;
        mapOfFormation = new HashMap<>();
        memorisedCycles = new HashMap<>();
    }

    public long getHighestPeak() {
        return highestPeak;
    }

    public void fallRocks(long numberOfRocks) {
        for (long rockNumber = 1; rockNumber <= numberOfRocks; rockNumber++) {
            Rock currentRock = new Rock(getNextRockType(), Point.of(2, highestPeak + 3));
            Set<Point> pointsInFormation = mapOfFormation.values().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toSet());
            boolean isMoving = true;
            while (isMoving) {
                Direction pushDirection = getNextPush() == '<' ? Direction.LEFT : Direction.RIGHT;
                if (currentRock.canMoveInDirection(pushDirection, pointsInFormation)) {
                    currentRock.moveInDirection(pushDirection);
                }
                if (currentRock.canMoveInDirection(Direction.DOWN, pointsInFormation)) {
                    currentRock.moveInDirection(Direction.DOWN);
                } else {
                    isMoving = false;
                }
            }

//            printBoard();
        }
    }

    private RockType getNextRockType() {
        if (indexOfRocksType == ORDER_OF_ROCKS.size()) {
            indexOfRocksType = 0;
        }
        return ORDER_OF_ROCKS.get(indexOfRocksType++);
    }

    private Character getNextPush() {
        if (indexOfJetPattern == jetPattern.length()) {
            indexOfJetPattern = 0;
        }
        return jetPattern.charAt(indexOfJetPattern++);
    }


    private void addRockToBoard(Rock rock) {
        Set<Point> rockPoints = rock.getPoints();
        for (Point point : rockPoints) {
            mapOfFormation.computeIfAbsent(point.getY(), key -> new ArrayList<>()).add(point);
        }
        rockPoints.forEach(point -> peaks[point.getX()] = Math.max(peaks[point.getX()], point.getY() + 1));
        calculateBestPeaks();
    }

    private void calculateBestPeaks() {
        long newLowestPeak = Long.MAX_VALUE;
        for (long peak : peaks) {
            highestPeak = Math.max(highestPeak, peak);
            newLowestPeak = Math.min(newLowestPeak, peak - 1);
        }
        if (newLowestPeak != lowestPeak) {
            for (long peak = lowestPeak; peak < newLowestPeak; peak++) {
                mapOfFormation.remove(peak);
            }
            lowestPeak = newLowestPeak;
        }
    }
}
