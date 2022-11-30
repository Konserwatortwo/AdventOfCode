package AoC2022.Day6;

import AoC2022.AdventTask;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Task6B extends AdventTask {

    public Task6B() {
        super("Day6", "Task6B");
    }

    @Override
    public List<String> perform(List<String> input) {
        String[] lanternfish = input.get(0).split(",");
        BigInteger[] population = new BigInteger[10];
        Arrays.fill(population, BigInteger.ZERO);

        for (String s : lanternfish) {
            population[Integer.parseInt(s)] = population[Integer.parseInt(s)].add(BigInteger.ONE);
        }

        for (int day = 1; day <= 256; day++) {
            BigInteger newborns = population[0];
            for (int phase = 0; phase <= 8; phase++) {
                population[phase] = population[phase + 1];
            }
            population[6] = population[6].add(newborns);
            population[8] = population[8].add(newborns);
        }
        BigInteger totalPopulation = Arrays.stream(population).reduce(BigInteger::add).orElse(BigInteger.ZERO);
        return List.of(totalPopulation + "");
    }
}
