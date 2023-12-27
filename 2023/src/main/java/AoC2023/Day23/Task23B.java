package AoC2023.Day23;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task23B extends AdventTask {

    public Task23B() {
        super("Day23", "Task23B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Forest.of(input).findLongestBiDirectionalRoute());
    }
}
