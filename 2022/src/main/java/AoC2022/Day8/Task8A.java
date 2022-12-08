package AoC2022.Day8;

import AoC2022.AdventTask;

import java.util.List;

public class Task8A extends AdventTask {

    public Task8A() {
        super("Day8", "Task8A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Grid grid = new Grid(input);
        grid.checkVisibleTrees();
        return List.of(grid.countVisibleTrees() + "");
    }
}
