package AoC2022.Day5;

public class Instruction {

    private final Integer from;
    private final Integer to;
    private final Integer  times;

    public Instruction(String line) {
        String[] elements = line.split(" ");
        this.times = Integer.parseInt(elements[1]);
        this.from = Integer.parseInt(elements[3]);
        this.to = Integer.parseInt(elements[5]);
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getTimes() {
        return times;
    }
}
