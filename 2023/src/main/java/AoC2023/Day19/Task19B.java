package AoC2023.Day19;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task19B extends AdventTask {

    public Task19B() {
        super("Day19", "Task19B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(GearSystem.of(input).checkAllCombinations());
    }
}
