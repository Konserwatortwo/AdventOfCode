package AoC2023.Day21;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task21B extends AdventTask {

    public Task21B() {
        super("Day21", "Task21B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Garden.of(input).findPlacesInInfiniteGarden(26501365));
    }
}
