package AoC2022.Day24;

import AoC2022.AdventTask;

import java.util.List;

public class Task24B extends AdventTask {

    public Task24B() {
        super("Day24", "Task24B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Basin basin = new Basin(input);
        basin.runToEnd();
        basin.runToStart();
        basin.runToEnd();
        return List.of(basin.getIterationNumber() + "");

    }
}
