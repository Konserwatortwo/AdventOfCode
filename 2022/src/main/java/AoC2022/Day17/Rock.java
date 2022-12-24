package AoC2022.Day17;

import java.util.Set;
import java.util.stream.Collectors;

public class Rock {

    private Set<Point> points;

    public Rock(RockType type, Point startingPoint) {
        this.points = type.createPointsFromShape(startingPoint);
    }

    public Set<Point> getPoints() {
        return points;
    }

    public boolean canMoveInDirection(Movement movement, Set<Point> existingPoints) {
        Set<Point> speculativePoints = points.stream()
                .map(movement::movePoint)
                .collect(Collectors.toSet());
        return speculativePoints.stream().allMatch(movement.getCheckForBorders()) && speculativePoints.stream().noneMatch(existingPoints::contains);
    }

    public void moveInDirection(Movement movement) {
        points = points.stream()
                .map(movement::movePoint)
                .collect(Collectors.toSet());
    }
}

