package AoC2022.Day12;

public class Tile {

    private final int positionX;
    private final int positionY;
    private final int value;

    private boolean isVisited;

    public Tile(int positionX, int positionY, char value) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.value = value;
        this.isVisited = false;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getValue() {
        return value;
    }

    public void visitTile() {
        isVisited = true;
    }

    public boolean canMoveTileUp(Tile other) {
        return !isVisited && other.getValue() + 1 >= value;
    }

    public boolean canMoveTileDown(Tile other) {
        return !isVisited && other.getValue() <= value + 1;
    }

    @Override
    public String toString() {
        return isVisited ? "#" : ((char) value) + "";
    }
}
