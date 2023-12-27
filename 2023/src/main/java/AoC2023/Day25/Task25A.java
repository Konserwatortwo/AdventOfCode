package AoC2023.Day25;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.List;

public class Task25A extends AdventTask {

    public Task25A() {
        super("Day25", "Task25A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return AdventTaskUtils.answerAs(Machine.of(input).findThreeSeparators());
    }
}
