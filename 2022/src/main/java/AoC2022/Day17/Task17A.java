package AoC2022.Day17;

import AoC2022.AdventTask;

import java.util.List;

public class Task17A extends AdventTask {

    public Task17A() {
        super("Day17", "Task17A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Board board = new Board(input);
        board.fallRocks(2022);
        return List.of(board.getHighestPeak()+"");
    }
}
