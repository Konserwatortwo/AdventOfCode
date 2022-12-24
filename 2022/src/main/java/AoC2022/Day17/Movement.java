package AoC2022.Day17;

import java.util.function.Predicate;

public enum Movement {
    DOWN(0, -1, point -> point.getY() >= 0),
    LEFT(-1, 0, point -> point.getX() >= 0),
    RIGHT(1, 0, point -> point.getX() < 7);

    private final int changeX;
    private final int changeY;
    private final Predicate<Point> checkForBorders;

    Movement(int changeX, int changeY, Predicate<Point> checkForBorders) {
        this.changeX = changeX;
        this.changeY = changeY;
        this.checkForBorders = checkForBorders;
    }

    public Point movePoint(Point point) {
        return Point.of(changeX, changeY).merge(point);
    }

    public Predicate<Point> getCheckForBorders() {
        return checkForBorders;
    }
}
