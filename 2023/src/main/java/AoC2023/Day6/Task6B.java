package AoC2023.Day6;

import AoC2023.AdventTask;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task6B extends AdventTask {

    public Task6B() {
        super("Day6", "Task6B");
    }

    @Override
    public List<String> perform(List<String> input) {
        assert input.size() == 2;
        long time = Long.parseLong(StringUtils.deleteWhitespace(input.get(0)).replace("Time:", ""));
        long distance = Long.parseLong(StringUtils.deleteWhitespace(input.get(1)).replace("Distance:", ""));
        return answerAs(Race.of(time, distance).getPossibleSuccessfulOutcomes());
    }
}
