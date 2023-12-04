package AoC2023.Day4;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task4A extends AdventTask {

    public Task4A() {
        super("Day4", "Task4A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(input.stream()
                .map(Scratchcard::new)
                .mapToInt(Scratchcard::value)
                .sum());
    }
}
