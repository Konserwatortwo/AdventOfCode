package AoC2023.Day3;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task3B extends AdventTask {

    public Task3B() {
        super("Day3", "Task3B");
    }

    @Override
    public List<String> perform(List<String> input) {
        EngineGrid engineGrid = new EngineGrid(input);
        return answerAs(engineGrid.sumOfAllNumbersNearGear());
    }
}
