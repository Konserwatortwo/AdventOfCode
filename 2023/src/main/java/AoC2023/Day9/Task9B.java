package AoC2023.Day9;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

public class Task9B extends AdventTask {

    public Task9B() {
        super("Day9", "Task9B");
    }

    @Override
    public List<String> perform(List<String> input) {
        long sum = input.stream()
                .map(Sequence::of)
                .mapToLong(Sequence::getFirstNumber)
                .sum();
        return AdventTaskUtils.answerAs(sum);
    }
}
