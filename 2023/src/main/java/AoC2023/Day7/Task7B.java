package AoC2023.Day7;

import AoC2023.AdventTask;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task7B extends AdventTask {

    public Task7B() {
        super("Day7", "Task7B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Hand> hands = input.stream()
                .map(HandWithJokers::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        long sum = 0;
        int multiplayer = 1;
        for (Hand hand : hands) {
            sum += hand.bidValue(multiplayer++);
        }
        return answerAs(sum);
    }
}
