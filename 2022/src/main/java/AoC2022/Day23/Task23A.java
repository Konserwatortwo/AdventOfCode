package AoC2022.Day23;

import AoC2022.AdventTask;

import java.util.List;

public class Task23A extends AdventTask {

    public Task23A() {
        super("Day23", "Task23A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Grove grove = new Grove(input);
        for (int i = 0; i < 10; i++) {
            grove.performRound();
        }
        return List.of(grove.retrieveEmptyGroundBetweenElf()+"");
    }
}
