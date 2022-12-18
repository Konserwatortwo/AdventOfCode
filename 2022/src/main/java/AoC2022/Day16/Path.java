package AoC2022.Day16;

public class Path {
    private final Room to;
    private final int cost;

    public Path(Room to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public Room getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
