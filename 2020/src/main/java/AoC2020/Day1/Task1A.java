package AoC2020.Day1;

import AoC2020.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

import static AoC2020.AdventTaskUtils.answerAs;

public class Task1A extends AdventTask {

    public Task1A() {
        super("Day1", "Task1A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Integer> numbers = input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int firstNumber = 0;
        int secondNumber = 0;
        for (int i = 0; i < numbers.size() && firstNumber + secondNumber != 2020; i++) {
            firstNumber = numbers.get(i);
            for (int j = i + 1; j < numbers.size() && firstNumber + secondNumber != 2020; j++) {
                secondNumber = numbers.get(j);
            }
        }
        return answerAs(firstNumber * secondNumber);
    }
}
