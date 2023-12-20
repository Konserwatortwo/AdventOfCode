package AoC2023.Day20;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task20A extends AdventTask {

    public Task20A() {
        super("Day20", "Task20A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(CommunicationCenter.of(input).count1000Signals());
    }
}
