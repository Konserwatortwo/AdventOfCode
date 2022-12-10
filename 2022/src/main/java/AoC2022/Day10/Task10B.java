package AoC2022.Day10;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task10B extends AdventTask {

    public Task10B() {
        super("Day10", "Task10B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<String> result = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();
        int valueOfX = 1;
        int cycleCounter = 0;

        for (String line : input) {
            int valueToAdd = 0;
            int numberOfCycles = 1;

            if(!line.equals("noop")) {
                numberOfCycles = 2;
                String[] elements = line.split(" ");
                valueToAdd = Integer.parseInt(elements[1]);
            }

            for (int i = 0; i < numberOfCycles; i++) {
                lineBuilder.append(Math.abs(cycleCounter - valueOfX) <= 1 ? "#" : ".");
                if(cycleCounter == 39) {
                    result.add(lineBuilder.toString());
                    lineBuilder = new StringBuilder();
                    cycleCounter = 0;
                } else {
                    cycleCounter++;
                }
            }

            valueOfX += valueToAdd;
        }

        return result;
    }
}
