package AoC2023.Day16;


import AoC2023.shared.Direction;
import AoC2023.shared.Position;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class Beam {

    @Getter
    Position position;
    Direction direction;

    public static Beam of(Position position, Direction direction) {
        return new Beam(position, direction);
    }

    public List<Beam> moveToNextPosition(char sign) {
        List<Beam> beams = new ArrayList<>();
        Tuple2<Direction, Optional<Direction>> nextDirections = determineNextDirection(direction, sign);
        beams.add(Beam.of(nextDirections._1.determineNextPosition(position), nextDirections._1));
        nextDirections._2.ifPresent(d -> beams.add(Beam.of(d.determineNextPosition(position), d)));
        return beams;
    }

    private Tuple2<Direction, Optional<Direction>> determineNextDirection(Direction direction, char sign) {
        Direction currentDirection = direction;
        Optional<Direction> otherDirection = Optional.empty();
        if (sign == '/') {
            currentDirection = currentDirection.isVertical() ? direction.goRight() : direction.goLeft();
        } else if (sign == '\\') {
            currentDirection = currentDirection.isVertical() ? direction.goLeft() : direction.goRight();
        } else if (sign == '-' && direction.isVertical()) {
            currentDirection = direction.goRight();
            otherDirection = Optional.of(direction.goLeft());
        } else if (sign == '|' && !direction.isVertical()) {
            currentDirection = direction.goRight();
            otherDirection = Optional.of(direction.goLeft());
        }
        return Tuple.of(currentDirection, otherDirection);
    }
}
