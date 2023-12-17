package AoC2023.Day17;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task17A extends AdventTask {

    public Task17A() {
        super("Day17", "Task17A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(City.of(input).findBestSolution(2, 0));
    }
}
