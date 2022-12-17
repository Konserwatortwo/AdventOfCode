package AoC2022.Day16;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task16A extends AdventTask {

    public Task16A() {
        super("Day16", "Task16A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker(30, "Norbert"));
        return List.of(Algorithm.searchBestSolution(input, workers)+"");
    }
}
