package AoC2021.Day1;

import AoC2021.AdventTask;

import java.util.List;

public class Task1B extends AdventTask {

    public Task1B() {
        super("Day1", "Task1B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int increasesMeasurements = 0;
        for (int i = 3, inputSize = input.size(); i < inputSize; i++) {
            int firstMeasurement = Integer.parseInt(input.get(i-3));
            int secondMeasurement = Integer.parseInt(input.get(i));

            if (firstMeasurement < secondMeasurement) {
                increasesMeasurements++;
            }
        }
        return List.of(increasesMeasurements + "");
    }
}
