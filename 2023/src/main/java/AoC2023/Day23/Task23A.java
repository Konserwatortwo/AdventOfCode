package AoC2023.Day23;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task23A extends AdventTask {

    public Task23A() {
        super("Day23", "Task23A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Forest.of(input).findLongestDirectionalRoute());
    }
}
