package AoC2021.Day8;

import AoC2021.AdventTask;

import java.util.List;

public class Task8A extends AdventTask {

    public Task8A() {
        super("Day8", "Task8A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int count = 0;
        for (String line : input) {
            for (int number : NumberDetector.processLine(line)) {
                if (List.of(1, 4, 7, 8).contains(number)) {
                    count++;
                }
            }
        }

        return List.of(count + "");
    }
}
