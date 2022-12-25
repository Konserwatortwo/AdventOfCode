package AoC2022.Day21;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonkeyHelper {
    public static final String ROOT_MONKEY_NAME = "root";
    public static final String HUMAN_MONKEY_NAME = "humn";

    public static Monkey createRootMonkey(List<String> input) {
        Map<String, String> monkeyNamesMap = input.stream()
                .map(line -> line.split(":"))
                .collect(Collectors.toMap(elements -> elements[0], elements -> elements[1].trim()));
        return createMonkey(ROOT_MONKEY_NAME, monkeyNamesMap);
    }

    private static Monkey createMonkey(String monkeyName, Map<String, String> monkeyNamesMap) {
        String[] constructionElements = monkeyNamesMap.get(monkeyName).split(" ");
        if (constructionElements.length == 1) {
            return new Monkey(monkeyName, Long.parseLong(constructionElements[0]));
        }
        Operation operation = Operation.determineOperation(constructionElements[1]);
        Monkey firstMonkey = createMonkey(constructionElements[0], monkeyNamesMap);
        Monkey secondMonkey = createMonkey(constructionElements[2], monkeyNamesMap);
        boolean isHumanDependant = Stream.of(firstMonkey, secondMonkey).anyMatch(MonkeyHelper::checkIfIsHumanDependant);
        return new OperationMonkey(monkeyName, operation, firstMonkey, secondMonkey, isHumanDependant);
    }

    private static boolean checkIfIsHumanDependant(Monkey monkey) {
        return HUMAN_MONKEY_NAME.equals(monkey.getName()) || monkey.isHumanDependant();
    }

    public static long calculateMonkeyResult(Monkey currentMonkey) {
        if (currentMonkey.shouldCalculateResult()) {
            OperationMonkey operationMonkey = (OperationMonkey) currentMonkey;
            long firstMonkeyResult = calculateMonkeyResult(operationMonkey.getFirstMonkey());
            long secondMonkeyResult = calculateMonkeyResult(operationMonkey.getSecondMonkey());
            operationMonkey.performOperation(firstMonkeyResult, secondMonkeyResult);
        }
        return currentMonkey.getResult();
    }

    public static long reverseEngineering(Monkey currentMonkey, Long value) {
        if (currentMonkey instanceof OperationMonkey) {
            OperationMonkey operationMonkey = (OperationMonkey) currentMonkey;
            if (checkIfIsHumanDependant(operationMonkey.getFirstMonkey())) {
                long reverseValue = operationMonkey.getOperation().performReverseOperationLeft(value, operationMonkey);
                return reverseEngineering(operationMonkey.getFirstMonkey(), reverseValue);
            }
            if (checkIfIsHumanDependant(operationMonkey.getSecondMonkey())) {
                long reverseValue = operationMonkey.getOperation().performReverseOperationRight(value, operationMonkey);
                return reverseEngineering(operationMonkey.getSecondMonkey(), reverseValue);
            }
        }
        return value;
    }
}