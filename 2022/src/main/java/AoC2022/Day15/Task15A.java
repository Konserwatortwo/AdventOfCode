package AoC2022.Day15;

import AoC2022.AdventTask;

import java.util.*;
import java.util.stream.Collectors;

public class Task15A extends AdventTask {

    public Task15A() {
        super("Day15", "Task15A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return perform(input, 2000000);
    }

    public List<String> perform(List<String> input, int level) {
        Device device = new Device(input);
        List<Range> ranges = device.retrieveRangeForLevel(level);
        int sum = ranges.stream().mapToInt(Range::distance).sum();
        return List.of(sum+"");
    }
}
