package AoC2023.Day2;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task2B extends AdventTask {

    public Task2B() {
        super("Day2", "Task2B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(input.stream()
                .map(Game::parse)
                .mapToInt(Game::calculateValue)
                .sum());
    }
}
