package AoC2023.Day19;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task19A extends AdventTask {

    public Task19A() {
        super("Day19", "Task19A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(GearSystem.of(input).sumAcceptedParts());
    }
}
