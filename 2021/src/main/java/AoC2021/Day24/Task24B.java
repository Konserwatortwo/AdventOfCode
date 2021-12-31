package AoC2021.Day24;

import AoC2021.AdventTask;

import java.util.Collections;
import java.util.List;

public class Task24B extends AdventTask {

    public Task24B() {
        super("Day24", "Task24B");
    }

    @Override
    public List<String> perform(List<String> input) {
        ArithmeticLogicUnit logicUnit = new ArithmeticLogicUnit(input);
        List<Long> result = logicUnit.generateVersions();
        Collections.sort(result);
        return List.of(result.get(0) + "");
    }
}
