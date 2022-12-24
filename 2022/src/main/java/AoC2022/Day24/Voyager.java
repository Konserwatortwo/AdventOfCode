package AoC2022.Day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voyager {
    private final Position position;

    public Voyager(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public List<Position> retrieveNextPossiblePositions() {
        List<Position> result = new ArrayList<>();
        result.add(position);
        Arrays.stream(Direction.values())
                .map(direction -> direction.moveInDirection(position))
                .forEach(result::add);
        return result;
    }
}
