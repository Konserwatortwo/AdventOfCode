package AoC2022.Day8;

import AoC2022.AdventTask;

import java.util.List;

public class Task8B extends AdventTask {

    public Task8B() {
        super("Day8", "Task8B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Grid grid = new Grid(input);
        int highestScenicScore = grid.highestScenicScore();
        return List.of(highestScenicScore + "");
    }
}
