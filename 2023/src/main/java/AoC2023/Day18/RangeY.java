package AoC2023.Day18;

import AoC2023.shared.Position;

import java.util.function.Function;

import static AoC2023.Day18.RangeY.PointPosition.*;

class RangeY extends Range {

    enum PointPosition {
        BEGIN,
        END,
        INSIDE,
        OUTSIDE
    }

    private RangeY(
            Position currentPosition,
            Function<Position, Integer> mapConstant,
            Function<Position, Integer> mapVariable,
            int change
    ) {
        super(currentPosition, mapConstant, mapVariable, change);
    }

    public static RangeY of(Position currentPosition, int change) {
        return new RangeY(currentPosition, Position::getX, Position::getY, change);
    }

    public PointPosition pointPosition(int point) {
        if (point == from) {
            return BEGIN;
        }
        if (point == to) {
            return END;
        }
        return from < point && to > point ? INSIDE : OUTSIDE;
    }
}
