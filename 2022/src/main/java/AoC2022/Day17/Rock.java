package AoC2022.Day17;

import java.util.List;
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

    public boolean canMoveInDirection(Direction direction, Set<Point> existingPoints) {
        Set<Point> speculativePoints = points.stream()
                .map(direction::movePoint)
                .collect(Collectors.toSet());
        return speculativePoints.stream().allMatch(direction.getCheckForBorders()) && speculativePoints.stream().noneMatch(existingPoints::contains);
    }

    public void moveInDirection(Direction direction) {
        points = points.stream()
                .map(direction::movePoint)
                .collect(Collectors.toSet());
    }
}

