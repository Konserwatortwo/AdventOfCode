package AoC2023.Day15;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;
import static AoC2023.AdventTaskUtils.splitOnSeparator;

public class Task15A extends AdventTask {

    public Task15A() {
        super("Day15", "Task15A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(splitOnSeparator(input.get(0), ",").stream()
                .map(Sequence::new)
                .mapToInt(Sequence::getHash)
                .sum());
    }
}
