package AoC2022.Day16;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task16B extends AdventTask {

    public Task16B() {
        super("Day16", "Task16B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker(26));
        workers.add(new Worker(26));
        return List.of(Algorithm.searchBestSolution(input, workers) + "");
    }
}
