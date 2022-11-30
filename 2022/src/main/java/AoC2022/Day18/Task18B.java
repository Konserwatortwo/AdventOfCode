package AoC2022.Day18;

import AoC2022.AdventTask;

import java.math.BigInteger;
import java.util.List;

import static AoC2022.Day18.SailfishNumberUtils.addSailfishNumbers;

public class Task18B extends AdventTask {

    public Task18B() {
        super("Day18", "Task18B");
    }

    @Override
    public List<String> perform(List<String> input) {
        BigInteger largestMagnitude = BigInteger.ZERO;

        for (int i = 0, inputSize = input.size(); i < inputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                if (i != j) {
                    SailfishNumber result = addSailfishNumbers(new SailfishNumber(input.get(i)), new SailfishNumber(input.get(j)));
                    largestMagnitude = largestMagnitude.compareTo(result.getMagnitude()) > 0 ? largestMagnitude : result.getMagnitude();
                }
            }
        }

        return List.of(largestMagnitude + "");
    }
}
