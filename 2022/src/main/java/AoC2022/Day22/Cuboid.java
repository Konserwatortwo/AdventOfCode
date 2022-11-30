package AoC2022.Day22;

import AoC2022.Day22.enums.Coordinate;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cuboid {

    private final Map<Coordinate, Range> ranges;
    private boolean isOn;

    public Cuboid(String line) {
        String[] parts = line.split(" ");
        this.isOn = Objects.equals(parts[0], "on");
        ranges = new HashMap<>();
        String[] elements = parts[1].split(",");
        ranges.put(Coordinate.X, new Range(elements[0].replace("x=", "")));
        ranges.put(Coordinate.Y, new Range(elements[1].replace("y=", "")));
        ranges.put(Coordinate.Z, new Range(elements[2].replace("z=", "")));
    }

    public Cuboid(Map<Coordinate, Range> ranges, boolean isOn) {
        this.ranges = ranges;
        this.isOn = isOn;
    }

    public Range getRange(Coordinate coordinate) {
        return ranges.get(coordinate);
    }

    public int getFrom(Coordinate coordinate) {
        return ranges.get(coordinate).getFrom();
    }

    public int getTo(Coordinate coordinate) {
        return ranges.get(coordinate).getTo();
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean isCorrect() {
        return Arrays.stream(Coordinate.values())
                .allMatch(coordinate -> getRange(coordinate).isCorrect());
    }

    public BigInteger getSpace() {
        BigInteger space = BigInteger.ONE;
        for (Coordinate coordinate : Coordinate.values()) {
            space = space.multiply(BigInteger.valueOf(ranges.get(coordinate).value()));
        }
        return isOn ? space : space.multiply(BigInteger.valueOf(-1));
    }

    @Override
    public String toString() {
        return "(" + getFrom(Coordinate.X) + "," + getFrom(Coordinate.Y) + "," + getFrom(Coordinate.Z) + ")" +
                "(" + getTo(Coordinate.X) + "," + getTo(Coordinate.Y) + "," + getTo(Coordinate.Z) + ')' +
                " : " + getSpace();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuboid cuboid = (Cuboid) o;
        return Objects.equals(ranges, cuboid.ranges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranges);
    }
}
