package AoC2022.Day24;

import AoC2022.common.DirectionUtils;
import AoC2022.common.Position;

import java.util.ArrayList;
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
        DirectionUtils.retrieveSimpleDirections().stream()
                .map(direction -> direction.getNextPosition(position))
                .forEach(result::add);
        return result;
    }
}
