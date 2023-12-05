package AoC2023.Day5;

import io.vavr.Tuple;
import io.vavr.Tuple3;
import lombok.Value;

@Value(staticConstructor = "of")
class Range implements Comparable<Range> {

    long from;
    long to;

    public boolean isInRange(long x) {
        return x >= from && x < to;
    }

    public boolean isInRange(Range otherRange) {
        return isInRange(otherRange.from) || isInRange(otherRange.to);
    }

    public Tuple3<Range, Range, Range> split(Range otherRange) {
        Range previousRange = null;
        if (from > otherRange.from) {
            previousRange = Range.of(otherRange.from, from);
        }
        Range mutualRange = Range.of(Math.max(from, otherRange.from), Math.min(to, otherRange.to));
        Range remainingRange = null;
        if (to < otherRange.to) {
            remainingRange = Range.of(to, otherRange.to);
        }
        return Tuple.of(previousRange, mutualRange, remainingRange);
    }

    @Override
    public int compareTo(Range other) {
        return Long.compare(from, other.from);
    }
}
