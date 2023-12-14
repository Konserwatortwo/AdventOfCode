package AoC2023.Day14;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task14B extends AdventTask {

    public Task14B() {
        super("Day14", "Task14B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Platform.of(input).findCyclesAndCountBalanceFor(1000000000L));
    }
}
