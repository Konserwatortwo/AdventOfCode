package AoC2023.Day1;

import AoC2023.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task1B extends AdventTask {

    public Task1B() {
        super("Day1", "Task1B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<String> output = new ArrayList<>();
        long totalSum = 0;
        for (String s : input) {
            long sumForComponent = 0;
            long fuel = Integer.parseInt(s) / 3 - 2;
            while (fuel > 0) {
                sumForComponent += fuel;
                fuel = fuel / 3 - 2;
            }
            totalSum += sumForComponent;
        }
        output.add(totalSum + "");
        return output;
    }
}
