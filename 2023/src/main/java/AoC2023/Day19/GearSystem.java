package AoC2023.Day19;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class GearSystem {

    Map<String, Workflow> workflows;
    List<Part> parts;

    public static GearSystem of(List<String> input) {
        int indexOfSplit = input.indexOf("");
        assert indexOfSplit > 0;
        Map<String, Workflow> workflows = input.subList(0, indexOfSplit).stream()
                .map(Workflow::of)
                .collect(Collectors.toMap(Workflow::getName, Function.identity()));
        List<Part> parts = input.subList(indexOfSplit + 1, input.size()).stream()
                .map(Part::of)
                .collect(Collectors.toList());
        return new GearSystem(workflows, parts);
    }

    public int sumAcceptedParts() {
        int sum = 0;
        for (Part part : parts) {
            while (!part.isInFinalState()) {
                workflows.get(part.getNextWorkflow()).moveThrough(part);
            }
            if (part.isAccepted()) {
                sum += part.getSum();
            }
        }
        return sum;
    }

    public long checkAllCombinations() {
        long count = 0;
        List<Range> ranges = new ArrayList<>();
        ranges.add(Range.of());
        while (!ranges.isEmpty()) {
            List<Range> nextGeneration = ranges.stream()
                    .map(range -> workflows.get(range.getNextWorkflow()).moveThrough(range))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            ranges = nextGeneration.stream()
                    .filter(range -> !range.isInFinalState())
                    .collect(Collectors.toList());
            count += nextGeneration.stream()
                    .filter(Range::isAccepted)
                    .mapToLong(Range::count)
                    .sum();
        }
        return count;
    }
}
