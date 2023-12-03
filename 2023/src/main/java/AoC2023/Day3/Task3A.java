package AoC2023.Day3;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task3A extends AdventTask {

    public Task3A() {
        super("Day3", "Task3A");
    }

    @Override
    public List<String> perform(List<String> input) {
        EngineGrid engineGrid = new EngineGrid(input);
        return answerAs(engineGrid.sumOfAllNumbersNearSymbol());
    }
}
