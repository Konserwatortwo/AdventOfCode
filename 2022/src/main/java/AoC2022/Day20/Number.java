package AoC2022.Day20;

public class Number {

    private final long value;

    public Number(String value) {
        this.value = Long.parseLong(value);
    }

    public Number(String value, int multiply) {
        this.value = Long.parseLong(value) * multiply;
    }

    public long getValue() {
        return value;
    }
}
