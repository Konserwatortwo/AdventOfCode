package AoC2022.Day1;

import AoC2022.AdventTask;

import java.util.List;

public class Task1A extends AdventTask {

    public Task1A() {
        super("Day1", "Task1A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int increasesMeasurements = 0;
        int previousMeasurement = Integer.MAX_VALUE;
        for (String s : input) {
            int currentMeasurement = Integer.parseInt(s);
            if (currentMeasurement > previousMeasurement) {
                increasesMeasurements++;
            }
            previousMeasurement = currentMeasurement;
        }
        return List.of(increasesMeasurements + "");
    }
}
