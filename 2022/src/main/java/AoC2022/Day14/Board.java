package AoC2022.Day14;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Board {

    private int lowestY = 0;

    private final Point sourceOfSand;

    private final Set<Point> blockedPoints;

    private int unitOfSand;

    public Board(List<String> lines) {
        blockedPoints = new HashSet<>();
        lines.forEach(this::createPointsFromLine);
        sourceOfSand = new Point(500, 0);
        unitOfSand = 0;
    }

    private void createPointsFromLine(String line) {
        String[] elements = line.split(" -> ");
        Point currentPoint = new Point(elements[0]);
        checkForLowestYValue(currentPoint);
        for (int i = 1; i < elements.length; i++) {
            Point startingPoint = currentPoint;
            currentPoint = new Point(elements[i]);
            checkForLowestYValue(currentPoint);
            if (startingPoint.isXCoordinateSame(currentPoint)) {
                generateBlockedPoints(startingPoint, currentPoint, Point::getY, y -> new Point(startingPoint.getX(), y));
            }
            if (startingPoint.isYCoordinateSame(currentPoint)) {
                generateBlockedPoints(startingPoint, currentPoint, Point::getX, x -> new Point(x, startingPoint.getY()));
            }
        }
    }

    private void generateBlockedPoints(Point start, Point end, Function<Point, Integer> getValue, Function<Integer, Point> createPoint) {
        generateValues(getValue.apply(start), getValue.apply(end))
                .mapToObj(createPoint::apply)
                .forEach(blockedPoints::add);
    }

    private IntStream generateValues(int start, int end) {
        return start < end ? IntStream.rangeClosed(start, end) : IntStream.rangeClosed(end, start);
    }

    private void checkForLowestYValue(Point point) {
        if (point.getY() >= lowestY) {
            lowestY = point.getY() + 1;
        }
    }

    public void runSandEndlessly() {
        Sand sand = new Sand(sourceOfSand);
        while (runUnitOfSand(sand)) {
            unitOfSand++;
            blockedPoints.add(sand.getCurrentPosition());
            sand = new Sand(sourceOfSand);
        }
    }

    public void runSandWithFloor(int levelOfFloor) {
        lowestY += levelOfFloor - 1;
        Sand sand;
        do {
            sand = new Sand(sourceOfSand);
            if (runUnitOfSand(sand)) {
                unitOfSand++;
            }
            blockedPoints.add(sand.getCurrentPosition());
        } while (!sand.getCurrentPosition().equals(sourceOfSand));
    }

    public boolean runUnitOfSand(Sand sand) {
        boolean canStillRun = true;
        while (canStillRun) {
            Point newPosition = null;
            Queue<Point> fallingPoints = sand.getFallingPoints();
            while (newPosition == null && !fallingPoints.isEmpty()) {
                Point fallingPoint = fallingPoints.remove();
                if (fallingPoint.getY() > lowestY) {
                    return false;
                }
                if (!blockedPoints.contains(fallingPoint)) {
                    newPosition = fallingPoint;
                }
            }
            if (null == newPosition) {
                canStillRun = false;
            } else {
                sand.setCurrentPosition(newPosition);
            }
        }
        return true;
    }

    public long countSand() {
        return unitOfSand;
    }
}
