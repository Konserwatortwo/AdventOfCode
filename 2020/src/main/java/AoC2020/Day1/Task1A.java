package AoC2020.Day1;

import AoC2020.AdventTask;
import AoC2020.AdventTaskUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Task1A extends AdventTask {

    public Task1A() {
        super("Day1", "Task1A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Integer> numbers =  input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        
        return AdventTaskUtils.answerAs()
    }
}
