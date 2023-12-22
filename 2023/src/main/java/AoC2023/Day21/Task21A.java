package AoC2023.Day21;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task21A extends AdventTask {

    public Task21A() {
        super("Day21", "Task21A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Garden.of(input).findPlacesAfter64Steps());
    }
}
