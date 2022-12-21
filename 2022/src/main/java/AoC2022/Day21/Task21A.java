package AoC2022.Day21;

import AoC2022.AdventTask;

import java.util.List;
import java.util.Map;

import static AoC2022.Day21.MonkeyHelper.calculateMonkeyResult;

public class Task21A extends AdventTask {

    public Task21A() {
        super("Day21", "Task21A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Monkey rootMonkey = MonkeyHelper.createRootMonkey(input);
        long result = calculateMonkeyResult(rootMonkey);
        return List.of(result+"");
    }
}
