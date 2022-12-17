package AoC2022.Day17;

import java.util.*;
import java.util.stream.Collectors;

public class Board {

    // TODO CLEAN CODE

    private static final List<RockType> ORDER_OF_ROCKS = List.of(RockType.LINE, RockType.CROSS, RockType.LETTER, RockType.POLE, RockType.SQUARE);

    private int indexOfRocksType = -1;
    private final String jetPattern;
    private int indexOfJetPattern = -1;
    private long highestPeak;
    private final Map<Long, List<Point>> mapOfFormation;

    private final List<String> consideredPositions;

    private final Map<Integer, Long> highestPeakForKey;

    public Board(List<String> input) {
        jetPattern = input.get(0);
        highestPeak = 0;
        mapOfFormation = new HashMap<>();
        consideredPositions = new ArrayList<>();
        highestPeakForKey = new HashMap<>();
    }

    public long getHighestPeak() {
        return highestPeak;
    }

    public void fallRocks(long numberOfRocks) {
        long result = 0;
        long rockNumber = 0;
        int iterator = -1;
        List<String> duplicatedInstruction = new ArrayList<>();

        while (result == 0 && rockNumber < numberOfRocks) {
            rockNumber++;
            RockType type = getNextRockType();
            performFall(type);
            highestPeakForKey.put((int) rockNumber, highestPeak);

            String key = type + " : " + indexOfJetPattern;

            if (consideredPositions.contains(key)) {
                duplicatedInstruction.add(key);
                if (iterator == -1) {
                    iterator = consideredPositions.indexOf(key);
                } else {
                    iterator++;
                }

                if (!consideredPositions.get(iterator).equals(key)) {
                    consideredPositions.addAll(duplicatedInstruction);
                    duplicatedInstruction.clear();
                    iterator = -1;
                }

                if (consideredPositions.size() - 1 == iterator) {
                    result = calculateResult(duplicatedInstruction.size(), numberOfRocks - rockNumber + 1);
                }

            } else {
                if (!duplicatedInstruction.isEmpty()) {
                    consideredPositions.addAll(duplicatedInstruction);
                    duplicatedInstruction.clear();
                    iterator = -1;
                }
                consideredPositions.add(key);

            }
        }

        highestPeak = Math.max(highestPeak, result);
    }


    private long calculateResult(int rocksInCycle, long rocksLeft) {
        int indexOfKey = consideredPositions.size() - rocksInCycle;
        long cycles = rocksLeft / rocksInCycle;

        long previousValue = highestPeakForKey.get(indexOfKey);
        long change = (highestPeak - previousValue) / 2;

        long additionalRocks = rocksLeft % rocksInCycle;
        long additionalValue = highestPeakForKey.get((int) additionalRocks + indexOfKey - 1) - previousValue;

        return highestPeak + (cycles * change) + additionalValue;
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
}
