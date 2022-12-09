package AoC2022.Day9;

public class Position {

    private int x = 0;
    private int y = 0;

    private final Position previousPosition;

    public Position() {
        this.previousPosition = null;
    }

    public Position(Position previousPosition) {
        this.previousPosition = previousPosition;
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
        assert previousPosition != null;
        return Math.abs(x - previousPosition.x) <= 1 && Math.abs(y - previousPosition.y) <= 1;
    }

    public void adjustToPreviousPosition() {
        assert previousPosition != null;
        x = determineMove(x, previousPosition.x);
        assert previousPosition != null;
        y = determineMove(y, previousPosition.y);
    }

    private int determineMove(int actual, int expected) {
        int current = actual;
        if(actual < expected) {
            current++;
        } else if(actual > expected) {
            current--;
        }
        return current;
    }


    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
