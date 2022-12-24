package AoC2022.Day14;

import AoC2022.common.Position;

public class Point extends Position {
    public Point(int x, int y) {
        super(x, y);
    }

    public Point(String coordinates) {
        super(Integer.parseInt(coordinates.split(",")[0]), Integer.parseInt(coordinates.split(",")[1]));
    }

    public boolean isXCoordinateSame(Point other) {
        return getX() == other.getX();
    }

    public boolean isYCoordinateSame(Point other) {
        return getY() == other.getY();
    }
}
