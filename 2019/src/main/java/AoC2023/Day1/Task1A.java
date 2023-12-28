package AoC2023.Day1;

import AoC2023.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task1A extends AdventTask {

    public Task1A() {
        super("Day1", "Task1A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<String> output = new ArrayList<>();
        long sum = 0;
        for (String s : input) {
            sum += Integer.parseInt(s) / 3 - 2;
        }
        output.add(sum + "");
        return output;
    }
}
