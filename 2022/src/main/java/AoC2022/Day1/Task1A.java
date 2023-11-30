package AoC2022.Day1;

import AoC2022.AdventTask;

import java.util.List;

public class Task1A extends AdventTask {

    public Task1A() {
        super("Day1", "Task1A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int max = 0;
        int sum = 0;
        for (String line : input) {
            if (line.isBlank()) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }
        if (sum > max) {
            max = sum;
        }
        return List.of(max + "");
    }
}
