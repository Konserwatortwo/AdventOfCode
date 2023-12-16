package AoC2023.shared;

import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Value(staticConstructor = "of")
public class Position {
    int x;
    int y;

    public List<Position> nearbyPositions() {
        return Arrays.stream(Direction.values())
                .map(x -> x.determineNextPosition(this))
                .collect(Collectors.toList());
    }

    public List<Position> nearbyPositionsExtended() {
        List<Position> result = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                result.add(Position.of(x + i, y + j));
            }
        }
        result.remove(this);
        return result;
    }
}
