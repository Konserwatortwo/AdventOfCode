package AoC2021.Day25;

import AoC2021.AdventTask;

import java.util.List;

public class Task25A extends AdventTask {

    public Task25A() {
        super("Day25", "Task25A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Board board = new Board(input);
        int countSteps = 1;
        while (board.step()) {
            countSteps++;
        }
        return List.of(countSteps + "");
    }
}
