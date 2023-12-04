package AoC2023.Day4;

import AoC2023.AdventTask;

import java.util.Arrays;
import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task4B extends AdventTask {

    public Task4B() {
        super("Day4", "Task4B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int[] board = new int[input.size()];
        Arrays.fill(board, 1);
        for (int i = 0; i < input.size(); i++) {
            Scratchcard scratchcard = new Scratchcard(input.get(i));
            for (int j = 1; j <= scratchcard.numberOfWinningCards() && i + j < board.length; j++) {
                board[i + j] += board[i];
            }
        }
        return answerAs(Arrays.stream(board).sum());
    }
}
