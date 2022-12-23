package AoC2022.Day16;

import AoC2022.AdventTask;

import java.util.List;

public class Task16B extends AdventTask {

    public Task16B() {
        super("Day16", "Task16B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Path> paths = PathFinder.generatePathsWithoutDuplicates(input, 26);
        int bestValue = findBestValue(paths);
        return List.of(bestValue + "");
    }

    private static int findBestValue(List<Path> paths) {
        int best = 0;
        for (Path path : paths) {
            for (Path otherPath : paths) {
                if (path.containsSameRoom(otherPath)) {
                    best = Math.max(best, path.getValue() + otherPath.getValue());
                }
            }
        }
        return best;
    }
}
