package AdventOfCode.Day1;

import AdventOfCode.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task1A extends AdventTask {

    @Override
    protected List<String> perform(List<String> input) {
        List<String> output = new ArrayList<>();
        long sum = 0;
        for (String s : input) {
            int value = Integer.parseInt(s);
            sum += fuelForMass(value);
        }
        output.add(sum + "");
        return output;
    }

    long fuelForMass(long mass) {
        return mass / 3 - 2;
    }
}
