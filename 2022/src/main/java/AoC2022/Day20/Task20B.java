package AoC2022.Day20;

import AoC2022.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task20B extends AdventTask {

    private static final int DECRYPTION_KEY = 811589153;

    public Task20B() {
        super("Day20", "Task20B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Number> originalList = input.stream().map(line -> new Number(line, DECRYPTION_KEY)).collect(Collectors.toList());
        List<Number> mixedList = Mixer.mixNumbers(originalList, 10);
        long sum = Mixer.calculateCoordinates(mixedList);
        return List.of(sum + "");
    }
}
