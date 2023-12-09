package AoC2023.Day9;

import AoC2023.AdventTaskUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
class Sequence {

    final List<Integer> numbers;
    Sequence nextSequence;

    public static Sequence of(String inputValue) {
        return Sequence.of(AdventTaskUtils.splitAndParseToInt(inputValue));
    }

    private static Sequence of(List<Integer> numbers) {
        return new Sequence(numbers, generateNextSequence(numbers));
    }

    private static Sequence generateNextSequence(List<Integer> numbers) {
        return numbers.stream().allMatch(x -> x == 0) ? null : Sequence.of(
                IntStream.range(0, numbers.size() - 1)
                        .map(i -> numbers.get(i + 1) - numbers.get(i))
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    public long getLastNumber() {
        return null == nextSequence ? 0 : nextSequence.getLastNumber() + numbers.get(numbers.size() - 1);
    }

    public long getFirstNumber() {
        return null == nextSequence ? 0 : numbers.get(0) - nextSequence.getFirstNumber();
    }
}
