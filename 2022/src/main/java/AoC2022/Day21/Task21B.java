package AoC2022.Day21;

import AoC2022.AdventTask;

import java.util.List;

import static AoC2022.Day21.MonkeyHelper.calculateMonkeyResult;
import static AoC2022.Day21.MonkeyHelper.reverseEngineering;

public class Task21B extends AdventTask {

    public Task21B() {
        super("Day21", "Task21B");
    }

    @Override
    public List<String> perform(List<String> input) {
        OperationMonkey rootMonkey = (OperationMonkey) MonkeyHelper.createRootMonkey(input);
        calculateMonkeyResult(rootMonkey);

        long result = 0;
        if (!rootMonkey.getFirstMonkey().isHumanDependant()) {
            result = reverseEngineering(rootMonkey.getSecondMonkey(), rootMonkey.getFirstMonkey().getResult());
        }
        if (!rootMonkey.getSecondMonkey().isHumanDependant()) {
            result = reverseEngineering(rootMonkey.getFirstMonkey(), rootMonkey.getSecondMonkey().getResult());
        }


        return List.of(result + "");
    }

}
