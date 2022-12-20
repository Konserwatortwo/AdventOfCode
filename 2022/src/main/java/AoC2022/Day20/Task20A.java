package AoC2022.Day20;

import AoC2022.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task20A extends AdventTask {

    public Task20A() {
        super("Day20", "Task20A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Number> originalList = input.stream().map(Number::new).collect(Collectors.toList());
        List<Number> mixedList = Mixer.mixNumbers(originalList, 1);
        long sum = Mixer.calculateCoordinates(mixedList);
        return List.of(sum + "");
    }
}
