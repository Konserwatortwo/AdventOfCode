package AoC2022.Day23.enums;

public enum Type {

    AMBER('A', 1, 3),
    BRONZE('B', 10, 5),
    COPPER('C', 100, 7),
    DESERT('D', 1000, 9);

    private final char symbol;
    private final int cost;
    private final int positionInHallway;

    Type(char symbol, int cost, int positionInHallway) {
        this.symbol = symbol;
        this.cost = cost;
        this.positionInHallway = positionInHallway;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getCost() {
        return cost;
    }

    public int getPositionInHallway() {
        return positionInHallway;
    }
}
