package AoC2020.Day2;

import AoC2020.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task2B extends AdventTask {

    public Task2B() {
        super("Day2", "Task2B");
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
        char checkedLetter = elements.get(1).charAt(0);
        char firstLetter = elements.get(2).charAt(numbers.get(0) - 1);
        char secondLetter = elements.get(2).charAt(numbers.get(1) - 1);
        return firstLetter != secondLetter && (firstLetter == checkedLetter || secondLetter == checkedLetter);
    }
}
