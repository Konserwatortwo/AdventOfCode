package AoC2022.Day21;

import AoC2022.AdventTask;
import AoC2022.Day21.Universe.Outcome;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Task21B extends AdventTask {

    public Task21B() {
        super("Day21", "Task21B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Player> players = input.stream().map(Player::new).collect(Collectors.toList());
        Universe firstUniverse = new Universe(players.get(0), players.get(1));
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(firstUniverse);
        Outcome result = firstUniverse.join();
        return List.of(result.returnBigger() + "");
    }
}
