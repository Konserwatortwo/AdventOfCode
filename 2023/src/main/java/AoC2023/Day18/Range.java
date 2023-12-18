package AoC2023.Day18;

import AoC2023.shared.Position;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
abstract class Range implements Comparable<Range> {

    int constant;
    int from;
    int to;

    protected Range(
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

    @Override
    public int compareTo(Range other) {
        if (constant == other.constant) {
            return Integer.compare(from, other.from);
        }
        return Integer.compare(constant, other.constant);
    }
}
