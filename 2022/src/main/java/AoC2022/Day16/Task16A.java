package AoC2022.Day16;

import AoC2022.AdventTask;

import java.util.List;

public class Task16A extends AdventTask {

    public Task16A() {
        super("Day16", "Task16A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Path> paths = PathFinder.generatePathsWithoutDuplicates(input, 30);
        int bestValue = findBestValue(paths);
        return List.of(bestValue + "");
    }

    private static int findBestValue(List<Path> paths) {
        int best = 0;
        for (Path path : paths) {
            best = Math.max(best, path.getValue());
        }
        return best;
    }
}
