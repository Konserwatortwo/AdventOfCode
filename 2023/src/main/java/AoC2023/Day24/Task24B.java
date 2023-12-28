package AoC2023.Day24;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task24B extends AdventTask {

    public Task24B() {
        super("Day24", "Task24B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(CheckingGround.of(input).calculateThrow());
    }
}
