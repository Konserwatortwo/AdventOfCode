package AoC2023.Day24;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task24A extends AdventTask {

    public Task24A() {
        super("Day24", "Task24A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(CheckingGround.of(input).countCollisionIn(200000000000000L, 400000000000000L));
    }
}
