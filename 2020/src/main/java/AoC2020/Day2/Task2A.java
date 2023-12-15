package AoC2020.Day2;

import AoC2020.AdventTask;
import AoC2023.AdventTaskUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task2A extends AdventTask {

    public Task2A() {
        super("Day2", "Task2A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(input.stream()
                .filter(this::isLineValid)
                .count());
    }

    private boolean isLineValid(String inputLine) {
        List<String> elements = AdventTaskUtils.splitOnSeparator(inputLine);
        assert elements.size() == 3;
        List<Integer> numbers = AdventTaskUtils.splitAndParseToInt(elements.get(0), "-");
        assert numbers.size() == 2;
        int numberOfLetters = StringUtils.countMatches(elements.get(2), elements.get(1).charAt(0));
        return numbers.get(0) <= numberOfLetters && numberOfLetters <= numbers.get(1);
    }
}
