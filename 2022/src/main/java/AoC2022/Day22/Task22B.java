package AoC2022.Day22;

import AoC2022.AdventTask;

import java.util.List;

public class Task22B extends AdventTask {

    public Task22B() {
        super("Day22", "Task22B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return perform(input, 50);
    }

    public List<String> perform(List<String> input, int sideSize) {
        int index = input.indexOf("");
        Cube cube = new Cube(input.subList(0, index), sideSize);
        ExtendedPosition startingPosition = cube.getFirstPosition();
        Player player = new Player(startingPosition, input.get(index + 1));
        player.runInstructions();
        return List.of(player.calculatePassword() + "");
    }
}
