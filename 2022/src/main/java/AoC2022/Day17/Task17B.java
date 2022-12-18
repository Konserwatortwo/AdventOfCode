package AoC2022.Day17;

import AoC2022.AdventTask;

import java.util.List;

public class Task17B extends AdventTask {

    public Task17B() {
        super("Day17", "Task17B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Board board = new Board(input);
        return List.of(board.fallRocksAndMeasureHeight(1000000000000L) + "");
    }
}
