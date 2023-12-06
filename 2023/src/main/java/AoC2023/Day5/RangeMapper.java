package AoC2023.Day5;

import AoC2023.AdventTaskUtils;
import io.vavr.Tuple;
import io.vavr.Tuple3;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class RangeMapper implements Comparable<RangeMapper> {

    Range source;
    long change;

    public static RangeMapper of(String inputValue) {
        List<Long> elements = AdventTaskUtils.splitAndParseToLong(inputValue);
        return new RangeMapper(
                Range.of(elements.get(1), elements.get(1) + elements.get(2)),
                elements.get(0) - elements.get(1)
        );
    }

    public boolean isInRange(long x) {
        return source.isInRange(x);
    }

    public boolean isInRange(Range otherRange) {
        return source.isInRange(otherRange);
    }

    public long map(long x) {
        return x + change;
    }

    private Range map(Range range) {
        return Range.of(map(range.getFrom()), map(range.getTo()));
    }

    public Tuple3<Range, Range, Range> splitAndMap(Range otherRange) {
        Tuple3<Range, Range, Range> splitResult = source.split(otherRange);
        return Tuple.of(splitResult._1, map(splitResult._2), splitResult._3);
    }

    @Override
    public int compareTo(RangeMapper other) {
        return source.compareTo(other.source);
    }
}
