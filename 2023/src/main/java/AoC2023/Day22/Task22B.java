package AoC2023.Day22;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task22B extends AdventTask {

    public Task22B() {
        super("Day22", "Task22B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Pile pile = Pile.of(input);
        pile.landBricks();
        return answerAs(pile.countChainReaction());
    }
}
