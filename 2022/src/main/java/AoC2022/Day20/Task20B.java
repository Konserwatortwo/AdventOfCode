package AoC2022.Day20;

import AoC2022.AdventTask;

import java.util.List;

public class Task20B extends AdventTask {

    public Task20B() {
        super("Day20", "Task20B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Algorithm algorithm = new Algorithm(input.get(0));
        Image image = new Image(input.subList(2, input.size()));
        for (int i = 0; i < 50; i++) {
            image = algorithm.perform(image);
        }
        return List.of(image.countBites() + "");
    }
}
