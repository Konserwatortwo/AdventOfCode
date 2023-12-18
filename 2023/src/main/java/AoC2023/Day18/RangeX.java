package AoC2023.Day18;

import AoC2023.shared.Position;

import java.util.function.Function;

class RangeX extends Range {

    private RangeX(
            Position currentPosition,
            Function<Position, Integer> mapConstant,
            Function<Position, Integer> mapVariable,
            int change
    ) {
        super(currentPosition, mapConstant, mapVariable, change);
    }

    public static RangeX of(Position currentPosition, int change) {
        return new RangeX(currentPosition, Position::getY, Position::getX, change);
    }
}
