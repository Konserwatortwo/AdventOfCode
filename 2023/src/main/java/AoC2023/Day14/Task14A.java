package AoC2023.Day14;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task14A extends AdventTask {

    public Task14A() {
        super("Day14", "Task14A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Platform.of(input).tiltNorthAndCountBalance());
    }
}
