package AoC2023.Day13;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task13B extends AdventTask {

    public Task13B() {
        super("Day13", "Task13B");
    }

    @Override
    public List<String> perform(List<String> input) {
        input.add("");
        return answerAs(Pattern.createFromInput(input).stream()
                .mapToInt(Pattern::calculateMirrorWithOneSmudgeValue)
                .sum()
        );
    }
}
