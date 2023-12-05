package AoC2023.Day5;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task5B extends AdventTask {

    public Task5B() {
        super("Day5", "Task5B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Almanac almanac = new Almanac(input);
        return answerAs(almanac.lowestLocationForRangeSeeds());
    }
}
