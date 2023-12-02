package AoC2023.Day2;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task2A extends AdventTask {

    private final static int LIMIT_OF_RED_CUBES = 12;
    private final static int LIMIT_OF_GREEN_CUBES = 13;
    private final static int LIMIT_OF_BLUE_CUBES = 14;

    public Task2A() {
        super("Day2", "Task2A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(input.stream()
                .map(Game::parse)
                .filter(game -> game.isNumberOfCubesLessThan(LIMIT_OF_RED_CUBES, LIMIT_OF_GREEN_CUBES, LIMIT_OF_BLUE_CUBES))
                .mapToInt(Game::getNumber)
                .sum());
    }
}
