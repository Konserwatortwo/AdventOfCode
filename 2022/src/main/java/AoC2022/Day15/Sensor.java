package AoC2022.Day15;

import AoC2022.common.Position;

public class Sensor {

    private final Position position;
    private final Position nearestBeacon;
    private final int distance;

    public Sensor(String line) {
        String[] elements = line.replace("Sensor at ", "")
                .replace(" closest beacon is at ", "")
                .split(":");

        this.position = createPosition(elements[0]);
        this.nearestBeacon = createPosition(elements[1]);
        this.distance = calculateManhattanDistanceToBeacon();
    }

    private Position createPosition(String coordinates) {
        String[] elements = coordinates.replace("x=", "")
                .replace("y=", "")
                .split(", ");
        return Position.of(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
    }

    private int calculateManhattanDistanceToBeacon() {
        return Math.abs(position.getX() - nearestBeacon.getX()) + Math.abs(position.getY() - nearestBeacon.getY());
    }

    public Position getNearestBeacon() {
        return nearestBeacon;
    }

    public Range generateRangeForLevel(int level) {
        if (position.getY() - distance > level || position.getY() + distance < level) {
            return null;
        }
        int r = distance - Math.abs(level - position.getY()) + 1;
        int minX = position.getX() + (1 - r);
        int maxX = position.getX() + (r - 1);
        if (level == nearestBeacon.getY()) {
            if (nearestBeacon.getX() == maxX && nearestBeacon.getX() == minX) {
                return null;
            }
            if (nearestBeacon.getX() == maxX) {
                maxX--;
            }
            if (nearestBeacon.getX() == minX) {
                minX++;
            }
        }
        return new Range(minX, maxX);
    }

    public Range generateRangeForLevelWithLimit(int level, int limit) {
        Range range = generateRangeForLevel(level);
        if (null == range || range.isRangeOutOfLimit(limit)) {
            return null;
        }
        range.cutToLimit(limit);
        return range;
    }
}
