package AoC2023.Day11;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task11A extends AdventTask {

    public Task11A() {
        super("Day11", "Task11A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Grid.of(input).calculateDistanceBetweenGalaxies(2));
    }
}
