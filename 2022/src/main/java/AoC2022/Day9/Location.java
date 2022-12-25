package AoC2022.Day9;

public class Location {

    private int x = 0;
    private int y = 0;

    private final Location previousLocation;

    public Location() {
        this.previousLocation = null;
    }

    public Location(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    public void moveByDirection(String direction) {
        switch (direction) {
            case "R" -> x++;
            case "L" -> x--;
            case "U" -> y++;
            case "D" -> y--;
        }
    }

    public boolean isAdjacentToPreviousPosition() {
        assert previousLocation != null;
        return Math.abs(x - previousLocation.x) <= 1 && Math.abs(y - previousLocation.y) <= 1;
    }

    public void adjustToPreviousPosition() {
        assert previousLocation != null;
        x = determineMove(x, previousLocation.x);
        assert previousLocation != null;
        y = determineMove(y, previousLocation.y);
    }

    private int determineMove(int actual, int expected) {
        int current = actual;
        if (actual < expected) {
            current++;
        } else if (actual > expected) {
            current--;
        }
        return current;
    }

    @Override
    public String toString() {
        return x + "-" + y;
    }
}
