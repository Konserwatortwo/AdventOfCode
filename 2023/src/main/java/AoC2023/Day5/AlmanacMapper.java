package AoC2023.Day5;

import io.vavr.Tuple3;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class AlmanacMapper {

    String name;
    List<RangeMapper> rangeMappers;

    public AlmanacMapper(List<String> inputValue) {
        this.name = inputValue.get(0);
        this.rangeMappers = new ArrayList<>();
        for (int i = 1; i < inputValue.size(); i++) {
            this.rangeMappers.add(RangeMapper.of(inputValue.get(i)));
        }
        Collections.sort(this.rangeMappers);
    }

    public long map(long x) {
        return rangeMappers.stream()
                .filter(rangeMapper -> rangeMapper.isInRange(x))
                .findAny()
                .map(y -> y.map(x))
                .orElse(x);
    }

    public List<Range> map(Range range) {
        List<Range> result = new ArrayList<>();
        Range remainingRange = range;
        Iterator<RangeMapper> iterator = rangeMappers.iterator();
        while (iterator.hasNext() && null != remainingRange) {
            RangeMapper rangeMapper = iterator.next();
            if (rangeMapper.isInRange(remainingRange)) {
                Tuple3<Range, Range, Range> splitResult = rangeMapper.splitAndMap(remainingRange);
                result.add(splitResult._1);
                result.add(splitResult._2);
                remainingRange = splitResult._3;
            }
        }
        result.add(remainingRange);
        return result.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
