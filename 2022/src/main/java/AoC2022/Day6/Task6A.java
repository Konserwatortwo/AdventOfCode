package AoC2022.Day6;

import AoC2022.AdventTask;

import java.util.Arrays;
import java.util.List;

public class Task6A extends AdventTask {

    public Task6A() {
        super("Day6", "Task6A");
    }

    @Override
    public List<String> perform(List<String> input) {
        String[] lanternfish = input.get(0).split(",");
        int[] population = new int[10];
        for (String s : lanternfish) {
            population[Integer.parseInt(s)]++;
        }

        for (int day = 1; day <= 80; day++) {
            int newborns = population[0];
            for (int phase = 0; phase <= 8; phase++) {
                population[phase] = population[phase + 1];
            }
            population[6] += newborns;
            population[8] += newborns;
        }
        int totalPopulation = Arrays.stream(population).sum();
        return List.of(totalPopulation + "");
    }
}
