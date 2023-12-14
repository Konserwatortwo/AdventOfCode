package AoC2023.Day10;

import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Value(staticConstructor = "of")
class Position {
    int x;
    int y;

    public List<Position> nearbyPositions() {
        return Arrays.stream(Direction.values())
                .map(x -> x.determineNextPosition(this))
                .collect(Collectors.toList());
    }
}
