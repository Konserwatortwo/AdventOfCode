package AoC2022.Day11;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MonkeyBuilder {

    public static Map<Integer, NormalMonkey> prepareNormalMonkeys(List<String> input) {
        Map<Integer, TemporaryMonkey> temporaryMonkeyMap = prepareTemporaryMonkeys(input);
        return temporaryMonkeyMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().makeNormalMonkey()));
    }

    public static Map<Integer, SmartMonkey> prepareSmartMonkeys(List<String> input) {
        Map<Integer, TemporaryMonkey> temporaryMonkeyMap = prepareTemporaryMonkeys(input);
        List<Integer> allDivisible = temporaryMonkeyMap.values().stream()
                .map(TemporaryMonkey::getDivisibleBy)
                .collect(Collectors.toList());
        return temporaryMonkeyMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().makeSmartMonkey(allDivisible)));
    }

    private static Map<Integer, TemporaryMonkey> prepareTemporaryMonkeys(List<String> input) {
        Map<Integer, TemporaryMonkey> result = new HashMap<>();
        int number = 0;
        List<String> linesForMonkey = new ArrayList<>();
        for (String line : input) {
            if (line.isEmpty()) {
                TemporaryMonkey temporaryMonkey = createTemporaryMonkey(number, linesForMonkey);
                result.put(number, temporaryMonkey);

                number++;
                linesForMonkey.clear();
            } else {
                linesForMonkey.add(line);
            }
        }
        if (!linesForMonkey.isEmpty()) {
            result.put(number, createTemporaryMonkey(number, linesForMonkey));
        }
        return result;
    }

    private static TemporaryMonkey createTemporaryMonkey(Integer number, List<String> lines) {
        assert lines.size() == 6;
        assert lines.get(0).contains(number + "");
        return new TemporaryMonkey()
                .withNumber(number)
                .withItems(retrieveStartingItems(lines.get(1)))
                .withOperation(retrieveOperation(retrieveWordAfterPhase(lines.get(2), "=")))
                .withDivisibleBy(Integer.parseInt(retrieveWordAfterPhase(lines.get(3), "by")))
                .withNumberOfMonkeyIfTestPass(Integer.parseInt(retrieveWordAfterPhase(lines.get(4), "monkey")))
                .withNumberOfMonkeyIfTestFail(Integer.parseInt(retrieveWordAfterPhase(lines.get(5), "monkey")));
    }

    private static Queue<Integer> retrieveStartingItems(String line) {
        Queue<Integer> result = new LinkedList<>();
        String[] elements = retrieveWordAfterPhase(line, ":").split(", ");
        for (String element : elements) {
            result.add(Integer.parseInt(element));
        }
        return result;
    }

    private static String retrieveWordAfterPhase(String line, String phase) {
        return line.split(phase)[1].trim();
    }

    private static Function<Integer, Integer> retrieveOperation(String line) {
        if (line.equals("old * old")) {
            return x -> x * x;
        }
        String[] elements = line.split(" ");
        Integer value = Integer.parseInt(elements[2]);
        return switch (elements[1]) {
            case "+" -> x -> x + value;
            case "-" -> x -> x - value;
            case "*" -> x -> x * value;
            case "/" -> x -> x / value;
            default -> x -> x;
        };
    }

    private static class TemporaryMonkey {
        private Integer number;
        protected Queue<Integer> items;
        private Function<Integer, Integer> operation;
        private Integer divisibleBy;
        private int numberOfMonkeyIfTestPass;
        private int numberOfMonkeyIfTestFail;

        TemporaryMonkey withNumber(Integer number) {
            this.number = number;
            return this;
        }

        TemporaryMonkey withItems(Queue<Integer> items) {
            this.items = items;
            return this;
        }

        TemporaryMonkey withOperation(Function<Integer, Integer> operation) {
            this.operation = operation;
            return this;
        }

        TemporaryMonkey withDivisibleBy(Integer divisibleBy) {
            this.divisibleBy = divisibleBy;
            return this;
        }

        TemporaryMonkey withNumberOfMonkeyIfTestPass(int numberOfMonkeyIfTestPass) {
            this.numberOfMonkeyIfTestPass = numberOfMonkeyIfTestPass;
            return this;
        }

        TemporaryMonkey withNumberOfMonkeyIfTestFail(int numberOfMonkeyIfTestFail) {
            this.numberOfMonkeyIfTestFail = numberOfMonkeyIfTestFail;
            return this;
        }

        public Queue<Integer> getItems() {
            return items;
        }

        public Integer getDivisibleBy() {
            return divisibleBy;
        }

        NormalMonkey makeNormalMonkey() {
            return new NormalMonkey(number, items, operation, divisibleBy, numberOfMonkeyIfTestPass, numberOfMonkeyIfTestFail);
        }

        SmartMonkey makeSmartMonkey(List<Integer> allDivisible) {
            Queue<Worry> worries = new LinkedList<>();
            for (Integer item : items) {
                worries.add(new Worry(item, allDivisible));
            }
            return new SmartMonkey(number, worries, operation, divisibleBy, numberOfMonkeyIfTestPass, numberOfMonkeyIfTestFail);
        }
    }
}
