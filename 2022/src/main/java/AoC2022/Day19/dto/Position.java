package AoC2022.Day19.dto;

import AoC2022.Day19.enums.Coordinate;

import java.util.Map;
import java.util.StringJoiner;

public class Position {
    private int x;
    private int y;
    private int z;

    public Position() {
    }

    public Position(String input) {
        String[] elements = input.split(",");
        this.x = Integer.parseInt(elements[0]);
        this.y = Integer.parseInt(elements[1]);
        this.z = Integer.parseInt(elements[2]);
    }

    public void setPosition(Map<Coordinate, Integer> bestPossibleCoordinates) {
        this.x = bestPossibleCoordinates.get(Coordinate.X);
        this.y = bestPossibleCoordinates.get(Coordinate.Y);
        this.z = bestPossibleCoordinates.get(Coordinate.Z);
    }

    public int getCoordinate(Coordinate coordinate) {
        return switch (coordinate) {
            case X -> x;
            case Y -> y;
            case Z -> z;
        };
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(getCoordinate(Coordinate.X) + "");
        joiner.add(getCoordinate(Coordinate.Y) + "");
        joiner.add(getCoordinate(Coordinate.Z) + "");
        return "[" + joiner + "]";
    }
}
