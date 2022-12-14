package AoC2022.Day14;

import java.util.LinkedList;
import java.util.Queue;

public class Sand {

    private Point currentPosition;

    public Sand(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Queue<Point> getFallingPoints() {
        Queue<Point> result = new LinkedList<>();
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        result.add(new Point(currentX, currentY + 1));
        result.add(new Point(currentX - 1, currentY + 1));
        result.add(new Point(currentX + 1, currentY + 1));
        return result;
    }
}
