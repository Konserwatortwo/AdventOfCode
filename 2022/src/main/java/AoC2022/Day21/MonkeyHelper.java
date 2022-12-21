package AoC2022.Day21;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        boolean isHumanDependant = determineHumanDependency(firstMonkey, secondMonkey);
        return new OperationMonkey(monkeyName, operation, firstMonkey, secondMonkey, isHumanDependant);
    }

    private static boolean determineHumanDependency(Monkey firstMonkey, Monkey secondMonkey) {
        return HUMAN_MONKEY_NAME.equals(firstMonkey.getName()) || firstMonkey.isHumanDependant()
                || HUMAN_MONKEY_NAME.equals(secondMonkey.getName()) || secondMonkey.isHumanDependant();
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
        if (HUMAN_MONKEY_NAME.equals(currentMonkey.getName())) {
            return value;
        }

        OperationMonkey operationMonkey = (OperationMonkey) currentMonkey;
        if (operationMonkey.getFirstMonkey().isHumanDependant() || HUMAN_MONKEY_NAME.equals(operationMonkey.getFirstMonkey().getName())) {
            long reverseValue = operationMonkey.reverseOperation(value, operationMonkey.getSecondMonkey().getResult());
            return reverseEngineering(operationMonkey.getFirstMonkey(), reverseValue);
        }

        if (operationMonkey.getSecondMonkey().isHumanDependant() || HUMAN_MONKEY_NAME.equals(operationMonkey.getSecondMonkey().getName())) {
            long reverseValue = operationMonkey.reverseOperation(value, operationMonkey.getFirstMonkey().getResult());
            return reverseEngineering(operationMonkey.getSecondMonkey(), reverseValue);
        }

        throw new IllegalStateException();
    }
}
