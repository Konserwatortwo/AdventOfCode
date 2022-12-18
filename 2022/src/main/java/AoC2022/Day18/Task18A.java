package AoC2022.Day18;

import AoC2022.AdventTask;

import java.util.List;

public class Task18A extends AdventTask {

    public Task18A() {
        super("Day18", "Task18A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return List.of(Counter.calculateTotalSurfaceArea(input) + "");
    }
}
