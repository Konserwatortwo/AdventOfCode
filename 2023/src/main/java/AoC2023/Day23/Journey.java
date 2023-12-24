package AoC2023.Day23;

import AoC2023.shared.Direction;
import AoC2023.shared.Position;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Journey {

    static Map<Character, Direction> allowedMoves = Map.of(
            '^', Direction.NORTH,
            'v', Direction.SOUTH,
            '<', Direction.WEST,
            '>', Direction.EAST
    );

    Position currentPosition;
    Set<Position> visitedPositions;

    public static Journey of() {
        return new Journey(Position.of(1, 0), new HashSet<>());
    }

    public List<Journey> retrieveNextJourneys(char valueAtPosition) {
        List<Direction> directionsToMove = valueAtPosition != '.'
                ? List.of(allowedMoves.get(valueAtPosition))
                : Arrays.stream(Direction.values()).toList();
        visitedPositions.add(currentPosition);
        return Arrays.stream(Direction.values())
                .map(direction -> direction.determineNextPosition(currentPosition))
                .filter(nextPosition -> !visitedPositions.contains(nextPosition))
                .map(nextPosition -> new Journey(nextPosition, new HashSet<>(visitedPositions)))
                .collect(Collectors.toList());
    }

}
