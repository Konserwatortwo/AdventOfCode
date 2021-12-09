package AoC2021.Day5;

import AoC2021.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task5B extends AdventTask {

    public Task5B() {
        super("Day5", "Task5B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int size = 1000;
        int[][] platform = new int[size][size];
        List<Direction> directions = new ArrayList<>();

        for (String line : input) {
            directions.add(new Direction(line));
        }

        for (Direction direction : directions) {
            if (direction.is45Degree()) {
                direction.markDirection(platform);
            }
        }

        int count = 0;
        for (int[] row : platform) {
            for (int point : row) {
                if (point > 1) {
                    count++;
                }
            }
        }
        return List.of(count + "");
    }
}
