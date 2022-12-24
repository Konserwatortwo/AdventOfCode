package AoC2022.Day15;

import AoC2022.common.Position;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Device {

    private final List<Sensor> sensors;

    public Device(List<String> input) {
        this.sensors = input.stream()
                .map(Sensor::new)
                .collect(Collectors.toList());
    }

    public List<Range> retrieveRangeForLevelWithLimit(int level, int limit) {
        return retrieveRangeFromSensor(sensor -> sensor.generateRangeForLevelWithLimit(level, limit));
    }

    public List<Range> retrieveRangeForLevel(int level) {
        return retrieveRangeFromSensor(sensor -> sensor.generateRangeForLevel(level));
    }

    private List<Range> retrieveRangeFromSensor(Function<Sensor, Range> generateRange) {
        List<Range> duplicatedRanges = sensors.stream()
                .map(generateRange)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return removeDuplicates(duplicatedRanges);
    }

    private List<Range> removeDuplicates(List<Range> duplicatedRanges) {
        if (duplicatedRanges.size() < 2) {
            return duplicatedRanges;
        }
        Collections.sort(duplicatedRanges);
        List<Range> consideredRanges = new LinkedList<>();
        Queue<Range> notConsideredRanges = new LinkedList<>(duplicatedRanges);

        Range currentRange = notConsideredRanges.remove();
        while (!notConsideredRanges.isEmpty()) {
            Range duplicatedRange = notConsideredRanges.remove();
            if (currentRange.isRangeOverlapping(duplicatedRange)) {
                currentRange.extendRange(duplicatedRange);
            } else {
                consideredRanges.add(currentRange);
                currentRange = duplicatedRange;
            }
        }
        consideredRanges.add(currentRange);
        return consideredRanges;
    }

    public boolean isPositionBeacon(Position position) {
        return sensors.stream().map(Sensor::getNearestBeacon).collect(Collectors.toSet()).contains(position);
    }
}
