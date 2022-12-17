package AoC2022.Day17;

import java.util.Objects;

public class Point {

    private final int x;
    private final long y;

    private Point(int x, long y) {
        this.x = x;
        this.y = y;
    }

    public Point merge(Point other) {
        return new Point(x + other.x, y + other.y);
    }

    public static Point of(int x, long y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }
}
