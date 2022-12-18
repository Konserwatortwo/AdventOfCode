package AoC2022.Day17;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private static final List<RockType> ORDER_OF_ROCKS = List.of(RockType.LINE, RockType.CROSS, RockType.LETTER, RockType.POLE, RockType.SQUARE);

    private int indexOfRocksType = -1;
    private final String jetPattern;
    private int indexOfJetPattern = -1;
    private long highestPeak;
    private final Map<Long, List<Point>> mapOfFormation;
    private final Map<Integer, Long> highestPeakForKey;

    public Board(List<String> input) {
        jetPattern = input.get(0);
        highestPeak = 0;
        mapOfFormation = new HashMap<>();
        highestPeakForKey = new HashMap<>();
    }

    public long fallRocksAndMeasureHeight(long numberOfRocks) {
        long rockNumber = 0;
        int iterator = -1;
        List<String> duplicatedInstruction = new ArrayList<>();
        List<String> consideredPositions = new ArrayList<>();
        boolean cycleDetected = false;

        while (!cycleDetected && rockNumber < numberOfRocks) {
            rockNumber++;
            RockType type = getNextRockType();

            String key = type + " : " + indexOfJetPattern;
            duplicatedInstruction.add(key);

            if (iterator == -1) {
                iterator = consideredPositions.indexOf(key);
            } else {
                iterator++;
                if (!consideredPositions.get(iterator).equals(key)) {
                    iterator = -1;
                }
            }

            if (iterator == -1) {
                consideredPositions.addAll(duplicatedInstruction);
                duplicatedInstruction.clear();
            } else {
                if (consideredPositions.size() - 1 == iterator) {
                    cycleDetected = true;
                }
            }

            performFall(type);
            highestPeakForKey.put((int) rockNumber, highestPeak);
        }

        return cycleDetected ? calculateCycles(duplicatedInstruction.size(), consideredPositions.size(), numberOfRocks - rockNumber + 1) : highestPeak;
    }

    private void performFall(RockType type) {
        Rock currentRock = new Rock(type, Point.of(2, highestPeak + 3));
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
        addRockToBoard(currentRock);
    }

    private RockType getNextRockType() {
        if (indexOfRocksType == ORDER_OF_ROCKS.size() - 1) {
            indexOfRocksType = 0;
        } else {
            indexOfRocksType++;
        }
        return ORDER_OF_ROCKS.get(indexOfRocksType);
    }

    private Character getNextPush() {
        if (indexOfJetPattern == jetPattern.length() - 1) {
            indexOfJetPattern = 0;
        } else {
            indexOfJetPattern++;
        }
        return jetPattern.charAt(indexOfJetPattern);
    }

    private void addRockToBoard(Rock rock) {
        Set<Point> rockPoints = rock.getPoints();
        for (Point point : rockPoints) {
            mapOfFormation.computeIfAbsent(point.getY(), key -> new ArrayList<>()).add(point);
        }
        rockPoints.forEach(point -> highestPeak = Math.max(highestPeak, point.getY() + 1));
    }

    private long calculateCycles(int rocksInCycle, int allPositions, long rocksLeft) {
        int indexOfKey = allPositions - rocksInCycle;
        long cycles = rocksLeft / rocksInCycle;

        long previousValue = highestPeakForKey.get(indexOfKey);
        long change = (highestPeak - previousValue) / 2;

        long additionalRocks = rocksLeft % rocksInCycle;
        long additionalValue = highestPeakForKey.get((int) additionalRocks + indexOfKey - 1) - previousValue;

        return highestPeak + (cycles * change) + additionalValue;
    }
}
