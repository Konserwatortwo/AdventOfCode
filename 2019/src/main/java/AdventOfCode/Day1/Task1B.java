package AdventOfCode.Day1;

import AdventOfCode.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task1B extends AdventTask {

    @Override
    protected List<String> perform(List<String> input) {
        List<String> output = new ArrayList<>();
        long totalSum = 0;
        for (String s : input) {
            long sumForComponent = 0;
            int value = Integer.parseInt(s);
            long fuel = fuelForMass(value);
            while (fuel > 0) {
                sumForComponent += fuel;
                fuel = fuelForMass(fuel);
            }
            totalSum += sumForComponent;
        }
        output.add(totalSum + "");
        return output;
    }

    long fuelForMass(long mass) {
        return mass / 3 - 2;
    }
}
