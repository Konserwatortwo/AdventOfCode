package AoC2023.Day2;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

public class Task2A extends AdventTask {

    public Task2A() {
        super("Day2", "Task2A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int[] alfa = OPCalculator.parseInput(input);
        alfa[1] = 12;
        alfa[2] = 2;
        return AdventTaskUtils.answerAs(OPCalculator.executeOPCode(alfa));
    }
}
