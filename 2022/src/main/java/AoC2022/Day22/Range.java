package AoC2022.Day22;

import java.util.Objects;

public class Range {
    private final int from;
    private final int to;

    public Range(String line) {
        String[] elements = line.split("\\.\\.");
        this.from = Integer.parseInt(elements[0]);
        this.to = Integer.parseInt(elements[1]) + 1;
    }

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public boolean isInRange(int value) {
        return value >= from && value <= to;
    }

    public int value() {
        return to - from;
    }

    public boolean isCorrect() {
        return from <= to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return from == range.from && to == range.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
