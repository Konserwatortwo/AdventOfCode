package AoC2022.Day14;

import AoC2022.AdventTask;

import java.util.List;

public class Task14A extends AdventTask {

    public Task14A() {
        super("Day14", "Task14A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Board board = new Board(input);
        board.runSandEndlessly();
        return List.of(board.countSand() + "");
    }
}
