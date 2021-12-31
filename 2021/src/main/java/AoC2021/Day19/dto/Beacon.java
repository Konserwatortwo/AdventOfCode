package AoC2021.Day19.dto;

public class Beacon extends Position {

    private static int counter = 1;

    private final String name;

    public Beacon(String input) {
        super(input);
        this.name = "Beacon no: " + counter++;
    }

    @Override
    public String toString() {
        return name + " " + super.toString();
    }

    public String getPosition() {
        return super.toString();
    }
}
