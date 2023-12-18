package AoC2023.Day18;

import AoC2023.shared.Position;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

import static AoC2023.Day18.Range.PointPosition.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Range implements Comparable<Range> {

    enum PointPosition {
        BEGIN,
        END,
        INSIDE,
        OUTSIDE
    }

    int constant;
    int from;
    int to;

    private Range(
            Position currentPosition,
            Function<Position, Integer> mapConstant,
            Function<Position, Integer> mapVariable,
            int change
    ) {
        this.constant = mapConstant.apply(currentPosition);
        if (change > 0) {
            this.from = mapVariable.apply(currentPosition);
            this.to = mapVariable.apply(currentPosition) + change;
        } else {
            this.from = mapVariable.apply(currentPosition) + change;
            this.to = mapVariable.apply(currentPosition);
        }
    }

    public static Range ofX(Position currentPosition, int change) {
        return new Range(currentPosition, Position::getY, Position::getX, change);
    }

    public static Range ofY(Position currentPosition, int change) {
        return new Range(currentPosition, Position::getX, Position::getY, change);
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

    @Override
    public int compareTo(Range other) {
        if (constant == other.constant) {
            return Integer.compare(from, other.from);
        }
        return Integer.compare(constant, other.constant);
    }
}
