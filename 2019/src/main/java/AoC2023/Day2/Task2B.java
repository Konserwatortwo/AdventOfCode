package AoC2023.Day2;

import AoC2023.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task2B extends AdventTask {

    public Task2B() {
        super("Day2", "Task2B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<String> output = new ArrayList<>();
        for (int noun = 0; noun < 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                int[] expressions = OPCalculator.parseInput(input);
                expressions[1] = noun;
                expressions[2] = verb;
                int result = OPCalculator.executeOPCode(expressions);
                if (19690720 == result) {
                    output.add("" + noun + verb);
                }
            }
        }
        return output;
    }
}
