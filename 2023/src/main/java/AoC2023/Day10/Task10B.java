package AoC2023.Day10;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task10B extends AdventTask {

    public Task10B() {
        super("Day10", "Task10B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Area.of(input).extendArea().retrieveNumberOfEmptySpacesInsideLoop());
    }
}
