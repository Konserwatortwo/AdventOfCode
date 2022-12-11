package AoC2022.Day11;

import AoC2022.AdventTask;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static AoC2022.Day11.MonkeyBuilder.prepareSmartMonkeys;

public class Task11B extends AdventTask {

    private static final int NUMBER_OF_ROUNDS = 10000;

    public Task11B() {
        super("Day11", "Task11B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return perform(input, NUMBER_OF_ROUNDS);
    }

    public List<String> perform(List<String> input, int numberOfRounds) {
        Map<Integer, SmartMonkey> monkeyMap = prepareSmartMonkeys(input);
        int numberOfMonkeys = monkeyMap.size();

        for (int roundNumber = 0; roundNumber < numberOfRounds; roundNumber++) {
            for (int monkeyNumber = 0; monkeyNumber < numberOfMonkeys; monkeyNumber++) {
                SmartMonkey currentMonkey = monkeyMap.get(monkeyNumber);
                while (currentMonkey.haveMoreItems()) {
                    Worry itemValue = currentMonkey.inspectNextItem();
                    int monkeyToThrow = currentMonkey.checkWhereThrowItem(itemValue);
                    monkeyMap.get(monkeyToThrow).addItem(itemValue);
                }
            }
        }

        List<Integer> inspectsPerMonkey = monkeyMap.values().stream()
                .map(Monkey::getNumberOfInspections)
                .sorted()
                .collect(Collectors.toList());
        Collections.reverse(inspectsPerMonkey);
        return List.of(BigInteger.valueOf(inspectsPerMonkey.get(0)).multiply(BigInteger.valueOf(inspectsPerMonkey.get(1))) + "");
    }
}
