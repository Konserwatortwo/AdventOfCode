package AoC2022.Day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;
    private final int z;

    private Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Coordinate of(int x, int y, int z) {
        return new Coordinate(x, y, z);
    }

    public static Coordinate of(String line) {
        String[] elements = line.split(",");
        assert elements.length == 3;
        return new Coordinate(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
    }

    public Coordinate from(int x, int y, int z) {
        return new Coordinate(this.x + x, this.y + y, this.z + z);
    }

    public List<Coordinate> retrieveNearby() {
        List<Coordinate> result = new ArrayList<>();
        result.add(from(1, 0, 0));
        result.add(from(-1, 0, 0));
        result.add(from(0, 1, 0));
        result.add(from(0, -1, 0));
        result.add(from(0, 0, 1));
        result.add(from(0, 0, -1));
        return result;
    }

    public List<Coordinate> retrieveNearbyAndItself() {
        List<Coordinate> result = retrieveNearby();
        result.add(this);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
