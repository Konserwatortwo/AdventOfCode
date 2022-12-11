package AoC2022.Day11;

import AoC2022.AdventTask;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static AoC2022.Day11.MonkeyBuilder.prepareNormalMonkeys;

public class Task11A extends AdventTask {

    private static final int NUMBER_OF_ROUNDS = 20;

    public Task11A() {
        super("Day11", "Task11A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Map<Integer, NormalMonkey> monkeyMap = prepareNormalMonkeys(input);
        int numberOfMonkeys = monkeyMap.size();

        for (int roundNumber = 0; roundNumber < NUMBER_OF_ROUNDS; roundNumber++) {
            for (int monkeyNumber = 0; monkeyNumber < numberOfMonkeys; monkeyNumber++) {
                NormalMonkey currentMonkey = monkeyMap.get(monkeyNumber);
                while (currentMonkey.haveMoreItems()) {
                    Integer itemValue = currentMonkey.inspectNextItem();
                    itemValue /= 3;
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

        return List.of(inspectsPerMonkey.get(0) * inspectsPerMonkey.get(1) + "");
    }
}
