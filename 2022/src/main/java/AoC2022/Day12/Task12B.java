package AoC2022.Day12;

import AoC2022.AdventTask;

import java.util.List;

public class Task12B extends AdventTask {

    public Task12B() {
        super("Day12", "Task12B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Algorithm algorithm = new Algorithm(input);
        return List.of(algorithm.runBackwards() + "");
    }
}
