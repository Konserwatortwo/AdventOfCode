package AoC2023.shared;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Direction {

    NORTH(true, x -> x, y -> y - 1),
    EAST(false, x -> x + 1, y -> y),
    SOUTH(true, x -> x, y -> y + 1),
    WEST(false, x -> x - 1, y -> y);

    @Getter
    boolean isVertical;
    Function<Integer, Integer> nextX;
    Function<Integer, Integer> nextY;

    public Position determineNextPosition(Position position) {
        return Position.of(nextX.apply(position.getX()), nextY.apply(position.getY()));
    }

    public int nextX(int x) {
        return nextX.apply(x);
    }

    public int nextY(int y) {
        return nextY.apply(y);
    }

    public Direction goRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Direction goLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }
}
