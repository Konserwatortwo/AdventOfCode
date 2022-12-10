package AoC2022.Day10;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task10A extends AdventTask {

    public Task10A() {
        super("Day10", "Task10A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int valueOfX = 1;
        int cycleCounter = 0;
        int checkSignalCycle = 20;
        List<Integer> sumOfSignals = new ArrayList<>();

        for (String line : input) {
            int valueToAdd = 0;
            if(line.equals("noop")) {
                cycleCounter +=1;
            } else {
                cycleCounter +=2;
                String[] elements = line.split(" ");
                valueToAdd = Integer.parseInt(elements[1]);
            }

            if(cycleCounter >= checkSignalCycle) {
                sumOfSignals.add(valueOfX * checkSignalCycle);
                checkSignalCycle += 40;
            }

            valueOfX += valueToAdd;
        }

        return List.of(sumOfSignals.stream().mapToInt(Integer::intValue).sum() + "");
    }
}
