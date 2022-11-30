package AoC2022.Day8;

import AoC2022.AdventTask;

import java.util.List;

public class Task8B extends AdventTask {

    public Task8B() {
        super("Day8", "Task8B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int count = 0;
        for (String line : input) {
            count += NumberDetector.processLineAsNumber(line);
        }
        return List.of(count + "");
    }
}
