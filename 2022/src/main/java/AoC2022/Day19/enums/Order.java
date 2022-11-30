package AoC2022.Day19.enums;

import java.util.HashMap;
import java.util.Map;

public enum Order {
    XYZ(Coordinate.X, Coordinate.Y, Coordinate.Z),
    XZY(Coordinate.X, Coordinate.Z, Coordinate.Y),
    YXZ(Coordinate.Y, Coordinate.X, Coordinate.Z),
    YZX(Coordinate.Y, Coordinate.Z, Coordinate.X),
    ZXY(Coordinate.Z, Coordinate.X, Coordinate.Y),
    ZYX(Coordinate.Z, Coordinate.Y, Coordinate.X);

    final Map<Coordinate, Coordinate> coordinates;

    Order(Coordinate first, Coordinate second, Coordinate third) {
        coordinates = new HashMap<>();
        coordinates.put(first, Coordinate.X);
        coordinates.put(second, Coordinate.Y);
        coordinates.put(third, Coordinate.Z);
    }

    public Coordinate getMappedCoordinate(Coordinate searched) {
        return coordinates.get(searched);
    }
}
