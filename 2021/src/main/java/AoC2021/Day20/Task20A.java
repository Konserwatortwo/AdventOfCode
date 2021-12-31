package AoC2021.Day20;

import AoC2021.AdventTask;

import java.util.List;

public class Task20A extends AdventTask {

    public Task20A() {
        super("Day20", "Task20A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Algorithm algorithm = new Algorithm(input.get(0));
        Image image = new Image(input.subList(2, input.size()));
        for (int i = 0; i < 2; i++) {
            image = algorithm.perform(image);
        }
        return List.of(image.countBites() + "");
    }
}
