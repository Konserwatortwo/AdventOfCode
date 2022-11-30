package AoC2022.Day18;

import AoC2022.AdventTask;

import java.util.List;

import static AoC2022.Day18.SailfishNumberUtils.addSailfishNumbers;

public class Task18A extends AdventTask {

    public Task18A() {
        super("Day18", "Task18A");
    }

    @Override
    public List<String> perform(List<String> input) {
        SailfishNumber resultNumber = new SailfishNumber(input.get(0));
        for (int i = 1, inputSize = input.size(); i < inputSize; i++) {
            resultNumber = addSailfishNumbers(resultNumber, new SailfishNumber(input.get(i)));
        }
        return List.of(resultNumber.getMagnitude() + "");
    }
}
