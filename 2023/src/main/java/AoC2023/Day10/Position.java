package AoC2023.Day10;

import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Value(staticConstructor = "of")
class Position {
    int x;
    int y;

    public boolean isInRange(int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    public List<Position> nearbyPositions() {
        return Arrays.stream(Direction.values())
                .map(x -> x.determineNextPosition(this))
                .collect(Collectors.toList());
    }
}
