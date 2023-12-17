package AoC2023.Day17;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task17B extends AdventTask {

    public Task17B() {
        super("Day17", "Task17B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(City.of(input).findBestSolution(9, 3));
    }
}
