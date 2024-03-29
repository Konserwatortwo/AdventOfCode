package AoC2023.Day12;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

public class Task12A extends AdventTask {

    public Task12A() {
        super("Day12", "Task12A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return AdventTaskUtils.answerAs(input.stream()
                .map(Row::of)
                .mapToLong(Row::calculateNumberOfPhases)
                .sum());
    }
}
