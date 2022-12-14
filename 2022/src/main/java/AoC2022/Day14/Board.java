package AoC2022.Day14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    private int minX = 500;
    private int maxX;
    private int maxY;

    private Content[][] grid;

    private final Point sourceOfSand;

    private int unitOfSand;

    public Board(List<String> lines) {
        List<Point> points = lines.stream()
                .map(this::createPointsFromLine)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        createGrid(points);
        sourceOfSand = new Point(500, 0);
        markPointAs(sourceOfSand, Content.SOURCE_OF_SAND);
    }

    private List<Point> createPointsFromLine(String line) {
        List<Point> result = new ArrayList<>();
        String[] elements = line.split(" -> ");
        Point currentPoint = new Point(elements[0]);
        checkIfPointExtendsBorders(currentPoint);
        for (int i = 1; i < elements.length; i++) {
            Point startingPoint = currentPoint;
            currentPoint = new Point(elements[i]);
            checkIfPointExtendsBorders(currentPoint);

            if (startingPoint.isXCoordinateSame(currentPoint)) {
                result.addAll(generatePoints(startingPoint, currentPoint, Point::getY, y -> new Point(startingPoint.getX(), y)));
            }
            if (startingPoint.isYCoordinateSame(currentPoint)) {
                result.addAll(generatePoints(startingPoint, currentPoint, Point::getX, x -> new Point(x, startingPoint.getY())));
            }
        }
        return result;
    }

    private List<Point> generatePoints(Point start, Point end, Function<Point, Integer> getValue, Function<Integer, Point> createPoint) {
        return generateValues(getValue.apply(start), getValue.apply(end))
                .mapToObj(createPoint::apply)
                .collect(Collectors.toList());
    }

    private IntStream generateValues(int start, int end) {
        return start < end ? IntStream.rangeClosed(start, end) : IntStream.rangeClosed(end, start);
    }

    private void checkIfPointExtendsBorders(Point point) {
        if (point.getX() < minX) {
            minX = point.getX() - 1;
        }
        if (point.getX() > maxX) {
            maxX = point.getX() + 1;
        }
        if (point.getY() > maxY) {
            maxY = point.getY() + 1;
        }
    }

    private void createGrid(List<Point> points) {
        grid = new Content[maxX][maxY];
        for (int y = 0; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                grid[x][y] = Content.AIR;
            }
        }
        for (Point point : points) {
            markPointAs(point, Content.ROCK);
        }
    }

    private void markPointAs(Point point, Content value) {
        grid[point.getX()][point.getY()] = value;
    }


    public void runSandEndlessly() {
        Sand sand = new Sand(sourceOfSand);
        while (runUnitOfSand(sand)) {
            markPointAs(sand.getCurrentPosition(), Content.SAND);
            unitOfSand++;
            sand = new Sand(sourceOfSand);
        }
        sand.getVisitedPoints().forEach(point -> markPointAs(point, Content.TRACE_OF_SAND));
    }

    public boolean runUnitOfSand(Sand sand) {
        boolean canStillRun = true;
        while (canStillRun) {
            Point newPosition = null;
            Queue<Point> fallingPoints = sand.getFallingPoints();
            while (newPosition == null && !fallingPoints.isEmpty()) {
                Point fallingPoint = fallingPoints.remove();
                if (isPointOutOfBoard(fallingPoint)) {
                    return false;
                }
                if (isPointNotBlocked(fallingPoint)) {
                    newPosition = fallingPoint;
                }
            }
            if (null == newPosition) {
                canStillRun = false;
            } else {
                sand.fall(newPosition);
            }
        }
        return true;
    }

    public void runSandWithFloor(int levelOfFloor) {
        adoptGrid(levelOfFloor);
        Sand sand;
        do {
            sand = new Sand(sourceOfSand);
            while (!runUnitOfSand(sand)) {
                expandGrid();
            }
            markPointAs(sand.getCurrentPosition(), Content.SAND);
            unitOfSand++;
        } while (!sand.getCurrentPosition().equals(sourceOfSand));
    }

    private void adoptGrid(int levelOfFloor) {
        int newMaxY = maxY + levelOfFloor;
        Content[][] newGrid = new Content[maxX][newMaxY];
        for (int y = 0; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                newGrid[x][y] = grid[x][y];
            }
        }
        for (int y = maxY; y < newMaxY - 1; y++) {
            for (int x = minX; x < maxX; x++) {
                newGrid[x][y] = Content.AIR;
            }
        }
        for (int x = minX; x < maxX; x++) {
            newGrid[x][newMaxY - 1] = Content.ROCK;
        }
        maxY = newMaxY;
        grid = newGrid;
    }

    private void expandGrid() {
        int newMaxX = maxX + 1;
        int newMinX = minX - 1;
        Content[][] newGrid = new Content[newMaxX][maxY];
        for (int y = 0; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                newGrid[x][y] = grid[x][y];
            }
        }
        for (int y = 0; y < maxY - 1; y++) {
            newGrid[newMinX][y] = Content.AIR;
            newGrid[maxX][y] = Content.AIR;
        }
        newGrid[newMinX][maxY - 1] = Content.ROCK;
        newGrid[maxX][maxY - 1] = Content.ROCK;
        minX = newMinX;
        maxX = newMaxX;
        grid = newGrid;
    }

    private boolean isPointOutOfBoard(Point point) {
        return point.getX() <= minX || point.getX() >= maxX || point.getY() >= maxY;
    }

    private boolean isPointNotBlocked(Point point) {
        return grid[point.getX()][point.getY()] == Content.AIR;
    }

    public int countSand() {
        return unitOfSand;
    }

    public void printBoard() {
        for (int y = 0; y < maxY; y++) {
            StringJoiner joiner = new StringJoiner("");
            for (int x = minX; x < maxX; x++) {
                joiner.add(grid[x][y].getSign());
            }
            System.out.println(joiner);
        }
    }
}
