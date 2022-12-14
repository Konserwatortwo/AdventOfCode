package AoC2022.Day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sand {

    private Point currentPosition;

    private final List<Point> visitedPoints;

    public Sand(Point currentPosition) {
        this.currentPosition = currentPosition;
        this.visitedPoints = new ArrayList<>();
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

    public void fall(Point newPosition) {
        visitedPoints.add(currentPosition);
        currentPosition = newPosition;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public List<Point> getVisitedPoints() {
        visitedPoints.add(currentPosition);
        return visitedPoints;
    }
}
