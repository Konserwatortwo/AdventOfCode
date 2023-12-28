package AoC2023.shared;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class Coordinates {

    long x;
    long y;
    long z;

    public static Coordinates of(List<Long> values) {
        return new Coordinates(values.get(0), values.get(1), values.get(2));
    }
}
