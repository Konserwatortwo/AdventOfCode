package AoC2023.Day9;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

public class Task9A extends AdventTask {

    public Task9A() {
        super("Day9", "Task9A");
    }

    @Override
    public List<String> perform(List<String> input) {
        long sum = input.stream()
                .map(Sequence::of)
                .mapToLong(Sequence::getLastNumber)
                .sum();
        return AdventTaskUtils.answerAs(sum);
    }
}
