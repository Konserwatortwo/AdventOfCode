package AoC2021.Day21;

import AoC2021.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task21A extends AdventTask {

    public Task21A() {
        super("Day21", "Task21A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Player> players = input.stream().map(Player::new).collect(Collectors.toList());
        Game game = new Game(players);
        int gameScore = game.play();
        return List.of(gameScore + "");
    }
}
