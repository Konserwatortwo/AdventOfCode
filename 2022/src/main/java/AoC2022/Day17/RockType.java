package AoC2022.Day17;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum RockType {
    LINE(List.of(Point.of(0, 0), Point.of(1, 0), Point.of(2, 0), Point.of(3, 0))),
    CROSS(List.of(Point.of(1, 0), Point.of(0, 1), Point.of(1, 1), Point.of(2, 1), Point.of(1, 2))),
    LETTER(List.of(Point.of(0, 0), Point.of(1, 0), Point.of(2, 0), Point.of(2, 1), Point.of(2, 2))),
    POLE(List.of(Point.of(0, 0), Point.of(0, 1), Point.of(0, 2), Point.of(0, 3))),
    SQUARE(List.of(Point.of(0, 0), Point.of(1, 0), Point.of(0, 1), Point.of(1, 1)));

    private final List<Point> shape;

    RockType(List<Point> shape) {
        this.shape = shape;
    }

    public Set<Point> createPointsFromShape(Point startingPoint) {
        return shape.stream()
                .map(point -> point.merge(startingPoint))
                .collect(Collectors.toSet());
    }
}
