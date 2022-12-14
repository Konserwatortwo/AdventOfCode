package AoC2022.Day14;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String coordinates) {
        this.x = Integer.parseInt(coordinates.split(",")[0]);
        this.y = Integer.parseInt(coordinates.split(",")[1]);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isXCoordinateSame(Point other) {
        return x == other.x;
    }

    public boolean isYCoordinateSame(Point other) {
        return y == other.y;
    }

    @Override
    public String toString() {
        return x + "-" + y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
}
