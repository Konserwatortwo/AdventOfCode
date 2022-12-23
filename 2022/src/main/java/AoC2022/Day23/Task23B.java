package AoC2022.Day23;

import AoC2022.AdventTask;

import java.util.List;

public class Task23B extends AdventTask {

    public Task23B() {
        super("Day23", "Task23B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Grove grove = new Grove(input);
        int roundNumber = 0;
        while (!grove.isIdle()) {
            roundNumber++;
            grove.performRound();
        }
        return List.of(roundNumber + "");
    }
}
