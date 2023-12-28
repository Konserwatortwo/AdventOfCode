package AoC2023.Day3;

import AoC2023.AdventTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task3A extends AdventTask {

    public Task3A() {
        super("Day3", "Task3A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Vector> firstCable = createCableVectors(input.get(0));
        List<Vector> secondCable = createCableVectors(input.get(1));
        List<Point> intersectionPoints = retrieveIntersectionPoints(firstCable, secondCable);
        List<Integer> distance = intersectionPoints.stream()
                .map(point -> Math.abs(point.x) + Math.abs(point.y))
                .sorted()
                .collect(Collectors.toList());
        return Collections.singletonList(distance.get(1) + "");
    }

    private List<Vector> createCableVectors(String s) {
        List<Vector> vectors = new ArrayList<>();
        Point point = new Point(0, 0);
        String[] lines = s.split(",");
        for (String line : lines) {
            vectors.add(createVector(line, point));
        }
        return vectors;
    }

    private Vector createVector(String line, Point point) {
        Vector vector;
        int newValue;
        int value = Integer.parseInt(line.substring(1));
        switch (line.charAt(0)) {
            case 'U' -> {
                newValue = point.y + value;
                vector = new Vector(Axis.Y, point.x, point.y, newValue);
                point.y = newValue;
            }
            case 'D' -> {
                newValue = point.y - value;
                vector = new Vector(Axis.Y, point.x, point.y, newValue);
                point.y = newValue;
            }
            case 'R' -> {
                newValue = point.x + value;
                vector = new Vector(Axis.X, point.y, point.x, newValue);
                point.x = newValue;
            }
            case 'L' -> {
                newValue = point.x - value;
                vector = new Vector(Axis.X, point.y, point.x, newValue);
                point.x = newValue;
            }
            default -> throw new IllegalStateException();
        }
        return vector;
    }

    private List<Point> retrieveIntersectionPoints(List<Vector> firstCable, List<Vector> secondCable) {
        List<Point> intersectionPoints = new ArrayList<>();
        for (Vector firstVector : firstCable) {
            for (Vector secondVector : secondCable) {
                intersectionPoints.addAll(retrieveIntersectionPoint(firstVector, secondVector));
            }
        }
        return intersectionPoints;
    }

    private List<Point> retrieveIntersectionPoint(Vector firstVector, Vector secondVector) {
        List<Point> points = new ArrayList<>();
        if (firstVector.orientation == secondVector.orientation) {
            if (firstVector.constant == secondVector.constant) {
                points = getSection(firstVector, secondVector);
            }
        } else {
            if (checkIsBetween(firstVector.min, secondVector.constant, firstVector.max)
                    && checkIsBetween(secondVector.min, firstVector.constant, secondVector.max)) {
                points.add(createPoint(firstVector.orientation, firstVector.constant, secondVector.constant));
            }
        }
        return points;
    }

    private List<Point> getSection(Vector firstVector, Vector secondVector) {
        List<Point> points = new ArrayList<>();
        for (int firstPoint = firstVector.min; firstPoint <= firstVector.max; firstPoint++) {
            if (checkIsBetween(secondVector.min, firstPoint, secondVector.max)) {
                points.add(createPoint(firstVector.orientation, firstVector.constant, firstPoint));
            }
        }
        return points;
    }

    private boolean checkIsBetween(int min, int constant, int max) {
        return min <= constant && constant <= max;
    }

    private Point createPoint(Axis orientation, int constant, int firstPoint) {
        if (orientation == Axis.X) {
            return new Point(firstPoint, constant);
        } else {
            return new Point(constant, firstPoint);
        }
    }

    private static class Vector {
        Axis orientation;
        int constant;
        int min;
        int max;

        Vector(Axis orientation, int constant, int min, int max) {
            this.orientation = orientation;
            this.constant = constant;
            if (min > max) {
                this.min = max;
                this.max = min;
            } else {
                this.min = min;
                this.max = max;
            }
        }
    }

    private enum Axis {
        X, Y
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
