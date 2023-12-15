package AoC2023.Day15;

import AoC2023.AdventTask;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static AoC2023.AdventTaskUtils.answerAs;
import static AoC2023.AdventTaskUtils.splitOnSeparator;

public class Task15B extends AdventTask {

    public Task15B() {
        super("Day15", "Task15B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Sequence> sequences = splitOnSeparator(input.get(0), ",").stream()
                .map(Sequence::new)
                .collect(Collectors.toList());
        List<Box> boxes = IntStream.range(1, 257)
                .mapToObj(Box::of)
                .collect(Collectors.toList());
        sequences.forEach(sequence -> boxes.get(sequence.getBoxNumber()).applySequence(sequence));
        return answerAs(boxes.stream()
                .mapToInt(Box::calculatePower)
                .sum());
    }
}
