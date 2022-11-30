package AoC2022.Day23;

import AoC2022.Day23.enums.Type;

public class Amphipoda {

    private final Type type;
    private int steps;
    private int position;

    public Amphipoda(Type type) {
        this.type = type;
        this.steps = 0;
    }

    public Amphipoda(Amphipoda otherAmphipoda) {
        this.type = otherAmphipoda.type;
        this.steps = otherAmphipoda.steps;
        this.position = otherAmphipoda.position;
    }

    public Type getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int cost) {
        this.steps += cost;
    }

    public int getCost() {
        return steps * type.getCost();
    }
}
