package AdventOfCode.Day3;

import AdventOfCode.AdventTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Task3B extends AdventTask {
    @Override
    protected List<String> perform(List<String> input) {
        List<Vector> firstCable = createCableVectors(input.get(0));
        List<Vector> secondCable = createCableVectors(input.get(1));
        List<Point> intersectionPoints = retrieveIntersectionPoints(firstCable, secondCable);
        List<Integer> distance = intersectionPoints.stream()
                .map(point -> point.steps)
                .sorted()
                .collect(Collectors.toList());
        return Collections.singletonList(distance.get(1) + "");
    }

    private List<Vector> createCableVectors(String s) {
        List<Vector> vectors = new ArrayList<>();
        Point point = new Point(0, 0, 0);
        String[] lines = s.split(",");
        for (String line : lines) {
            vectors.add(createVector(line, point));
        }
        return vectors;
    }

    private Vector createVector(String line, Point point) {
        Vector vector;
        Integer newValue;
        int value = Integer.parseInt(line.substring(1));
        switch (line.charAt(0)) {
            case 'U':
                newValue = point.y + value;
                vector = new Vector(Axis.Y, point.x, point.y, newValue, point.steps);
                point.y = newValue;
                point.steps += value;
                break;
            case 'D':
                newValue = point.y - value;
                vector = new Vector(Axis.Y, point.x, point.y, newValue, point.steps);
                point.y = newValue;
                point.steps += value;
                break;
            case 'R':
                newValue = point.x + value;
                vector = new Vector(Axis.X, point.y, point.x, newValue, point.steps);
                point.x = newValue;
                point.steps += value;
                break;
            case 'L':
                newValue = point.x - value;
                vector = new Vector(Axis.X, point.y, point.x, newValue, point.steps);
                point.x = newValue;
                point.steps += value;
                break;
            default:
                throw new IllegalStateException();
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
            if (checkIsBetween(firstVector.start, secondVector.constant, firstVector.end)
                    && checkIsBetween(secondVector.start, firstVector.constant, secondVector.end)) {
                int steps = firstVector.steps + secondVector.steps + abs(firstVector.constant - secondVector.start) + abs(secondVector.constant - firstVector.start);
                points.add(createPoint(firstVector.orientation, firstVector.constant, secondVector.constant, steps));
            }
        }
        return points;
    }

    private List<Point> getSection(Vector firstVector, Vector secondVector) {
        List<Point> points = new ArrayList<>();
        for (int firstPoint = firstVector.start; firstPoint <= firstVector.end; firstPoint += firstVector.start < firstVector.end ? 1 : -1) {
            if (checkIsBetween(secondVector.start, firstPoint, secondVector.end)) {
                points.add(createPoint(firstVector.orientation, firstVector.constant, firstPoint, firstVector.steps + secondVector.steps));
            }
        }
        return points;
    }

    private boolean checkIsBetween(int start, int constant, int end) {
        if (start < end) {
            return start <= constant && constant <= end;
        } else {
            return end <= constant && constant <= start;
        }
    }

    private Point createPoint(Axis orientation, int constant, int firstPoint, int steps) {
        if (orientation == Axis.X) {
            return new Point(firstPoint, constant, steps);
        } else {
            return new Point(constant, firstPoint, steps);
        }
    }

    private static class Vector {
        Axis orientation;
        int constant;
        int start;
        int end;
        int steps;

        Vector(Axis orientation, int constant, int start, int end, int steps) {
            this.orientation = orientation;
            this.constant = constant;
            this.start = start;
            this.end = end;
            this.steps = steps;
        }
    }

    private enum Axis {
        X, Y;
    }

    private static class Point {
        int x;
        int y;
        int steps;

        Point(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
}
