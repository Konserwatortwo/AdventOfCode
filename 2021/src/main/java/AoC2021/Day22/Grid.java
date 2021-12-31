package AoC2021.Day22;

import AoC2021.Day22.enums.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    boolean[][][] cubes;

    private final Map<Coordinate, Range> gridRanges;

    public Grid() {
        gridRanges = new HashMap<>();
        gridRanges.put(Coordinate.X, new Range(-50, 50));
        gridRanges.put(Coordinate.Y, new Range(-50, 50));
        gridRanges.put(Coordinate.Z, new Range(-50, 50));

        cubes = new boolean[getSize(Coordinate.X)][getSize(Coordinate.Y)][getSize(Coordinate.Z)];
    }

    private boolean getCubeOnPosition(int x, int y, int z) {
        return cubes[x - getMin(Coordinate.X)][y - getMin(Coordinate.Y)][z - getMin(Coordinate.Z)];
    }

    private void setCubeOnPosition(boolean value, int x, int y, int z) {
        cubes[x - getMin(Coordinate.X)][y - getMin(Coordinate.Y)][z - getMin(Coordinate.Z)] = value;
    }

    public void setCubesInRange(Cuboid cuboid) {
        if (!isRangeOutSideGrid(cuboid)) {
            for (int x = cuboid.getFrom(Coordinate.X); x <= cuboid.getTo(Coordinate.X); x++) {
                for (int y = cuboid.getFrom(Coordinate.Y); y <= cuboid.getTo(Coordinate.Y); y++) {
                    for (int z = cuboid.getFrom(Coordinate.Z); z <= cuboid.getTo(Coordinate.Z); z++) {
                        if (positionInGrid(x, y, z) && getCubeOnPosition(x, y, z) != cuboid.isOn()) {
                            setCubeOnPosition(cuboid.isOn(), x, y, z);
                        }
                    }
                }
            }
        }
    }

    private boolean positionInGrid(int x, int y, int z) {
        return gridRanges.get(Coordinate.X).isInRange(x)
                && gridRanges.get(Coordinate.Y).isInRange(y)
                && gridRanges.get(Coordinate.Z).isInRange(z);
    }

    private boolean isRangeOutSideGrid(Cuboid cuboid) {
        return !positionInGrid(cuboid.getFrom(Coordinate.X), cuboid.getFrom(Coordinate.Y), cuboid.getFrom(Coordinate.Z))
                && !positionInGrid(cuboid.getTo(Coordinate.X), cuboid.getTo(Coordinate.Y), cuboid.getTo(Coordinate.Z));
    }

    public long countCubesOn() {
        long result = 0;
        for (int x = getMin(Coordinate.X); x <= getMax(Coordinate.X); x++) {
            for (int y = getMin(Coordinate.Y); y <= getMax(Coordinate.Y); y++) {
                for (int z = getMin(Coordinate.Z); z <= getMax(Coordinate.Z); z++) {
                    if (getCubeOnPosition(x, y, z)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private int getMin(Coordinate coordinate) {
        return gridRanges.get(coordinate).getFrom();
    }

    private int getMax(Coordinate coordinate) {
        return gridRanges.get(coordinate).getTo();
    }

    private int getSize(Coordinate coordinate) {
        return Math.abs(getMax(coordinate) - getMin(coordinate)) + 1;
    }
}
