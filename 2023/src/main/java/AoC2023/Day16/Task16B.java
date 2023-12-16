package AoC2023.Day16;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task16B extends AdventTask {

    public Task16B() {
        super("Day16", "Task16B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Contraption.of(input).findBestLightAngle());
    }
}
