package AoC2023.Day6;

import AoC2023.AdventTask;

import java.util.ArrayList;
import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;
import static AoC2023.AdventTaskUtils.splitAndParseToLong;

public class Task6A extends AdventTask {

    public Task6A() {
        super("Day6", "Task6A");
    }

    @Override
    public List<String> perform(List<String> input) {
        assert input.size() == 2;
        List<Long> times = splitAndParseToLong(input.get(0), null, "Time:");
        List<Long> distances = splitAndParseToLong(input.get(1), null, "Distance:");
        List<Race> races = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            races.add(Race.of(times.get(i), distances.get(i)));
        }
        return answerAs(races.stream()
                .mapToLong(Race::getPossibleSuccessfulOutcomes)
                .reduce(1L, (x, y) -> x * y));
    }
}
