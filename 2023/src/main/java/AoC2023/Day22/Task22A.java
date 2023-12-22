package AoC2023.Day22;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task22A extends AdventTask {

    public Task22A() {
        super("Day22", "Task22A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Pile pile = Pile.of(input);
        pile.landBricks();
        return answerAs(pile.countAbleToDestroy());
    }
}
