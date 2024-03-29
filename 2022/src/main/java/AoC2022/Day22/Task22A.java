package AoC2022.Day22;

import AoC2022.AdventTask;

import java.util.List;

public class Task22A extends AdventTask {

    public Task22A() {
        super("Day22", "Task22A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int index = input.indexOf("");
        Plain plain = new Plain(input.subList(0, index));
        ExtendedPosition startingPosition = plain.getFirstPosition();
        Player player = new Player(startingPosition, input.get(index + 1));
        player.runInstructions();
        return List.of(player.calculatePassword() + "");
    }
}
