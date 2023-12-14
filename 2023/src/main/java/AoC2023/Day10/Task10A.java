package AoC2023.Day10;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task10A extends AdventTask {

    public Task10A() {
        super("Day10", "Task10A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Area.of(input).calculateLoop().size() / 2);
    }
}
