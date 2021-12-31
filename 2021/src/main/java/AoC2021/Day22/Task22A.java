package AoC2021.Day22;

import AoC2021.AdventTask;

import java.util.List;
import java.util.Objects;

public class Task22A extends AdventTask {

    public Task22A() {
        super("Day22", "Task22A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Grid grid = new Grid();
        for (String line : input) {
            grid.setCubesInRange(new Cuboid(line));
        }
        return List.of(grid.countCubesOn() + "");
    }
}
