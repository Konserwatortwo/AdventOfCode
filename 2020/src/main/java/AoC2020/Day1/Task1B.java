package AoC2020.Day1;

import AoC2020.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

import static AoC2020.AdventTaskUtils.answerAs;

public class Task1B extends AdventTask {

    public Task1B() {
        super("Day1", "Task1B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Integer> numbers = input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 0;
        for (int i = 0; i < numbers.size() && firstNumber + secondNumber + thirdNumber != 2020; i++) {
            firstNumber = numbers.get(i);
            for (int j = i + 1; j < numbers.size() && firstNumber + secondNumber + thirdNumber != 2020; j++) {
                secondNumber = numbers.get(j);
                for (int k = j + 1; k < numbers.size() && firstNumber + secondNumber + thirdNumber != 2020; k++) {
                    thirdNumber = numbers.get(k);
                }
            }
        }
        return answerAs(firstNumber * secondNumber * thirdNumber);
    }
}
