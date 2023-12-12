package AoC2023.Day12;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

public class Task12B extends AdventTask {

    public Task12B() {
        super("Day12", "Task12B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return AdventTaskUtils.answerAs(input.stream()
                .map(Row::of)
                .map(row -> row.extend(5))
                .mapToLong(Row::calculateNumberOfPhases)
                .sum());
    }
}
