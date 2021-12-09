package AoC2021.Day7;

import AoC2021.AdventTask;

import java.util.Arrays;
import java.util.List;

public class Task7A extends AdventTask {

    public Task7A() {
        super("Day7", "Task7A");
    }

    @Override
    public List<String> perform(List<String> input) {
        String[] numbers = input.get(0).split(",");
        int max = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .max().orElse(0);

        int[] population = new int[max + 1];
        Arrays.stream(numbers)
                .map(Integer::parseInt)
                .forEach(number -> population[number]++);

        int lowestCost = Integer.MAX_VALUE;
        int beforePoints = numbers.length;
        int beforeCost = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt).sum();
        int afterPoints = 0;
        int afterCost = 0;

        int currentPoint;
        int currentCost;

        for (int i = 0; i < max; i++) {
            currentPoint = population[i];
            currentCost = afterCost + beforeCost;
            beforePoints -= currentPoint;
            beforeCost -= beforePoints;
            afterPoints += currentPoint;
            afterCost += afterPoints;


            if (currentCost < lowestCost) {
                lowestCost = currentCost;
            }
        }

        return List.of(lowestCost + "");
    }
}
