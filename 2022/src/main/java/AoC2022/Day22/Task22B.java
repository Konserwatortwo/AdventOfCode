package AoC2022.Day22;

import AoC2022.AdventTask;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task22B extends AdventTask {

    public Task22B() {
        super("Day22", "Task22B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Cuboid> cuboids = input.stream().map(Cuboid::new).collect(Collectors.toList());
        BigInteger result = CuboidUtils.completeSetup(cuboids);
        return List.of(result + "");
    }
}
