package AoC2023.Day11;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task11B extends AdventTask {

    public Task11B() {
        super("Day11", "Task11B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Space.of(input).calculateDistanceBetweenGalaxies(1000000));
    }
}
