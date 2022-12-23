package AoC2022.Day16;

public class Cost {
    private final Room to;
    private final int cost;

    public Cost(Room to, int cost) {
        this.to = to;
        this.cost = cost + 1;
    }

    public Room getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
