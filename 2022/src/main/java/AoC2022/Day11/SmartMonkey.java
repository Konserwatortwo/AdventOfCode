package AoC2022.Day11;

import java.util.Queue;
import java.util.function.Function;
import java.util.function.Predicate;

public class SmartMonkey extends Monkey<Worry> {

    public SmartMonkey(Integer number,
                       Queue<Worry> items,
                       Function<Integer, Integer> operation,
                       Integer divisibleBy,
                       int numberOfMonkeyIfTestPass,
                       int numberOfMonkeyIfTestFail) {
        super(number, items, operation, divisibleBy, numberOfMonkeyIfTestPass, numberOfMonkeyIfTestFail);
    }

    @Override
    public Worry performInspection() {
        Worry worry = items.remove();
        worry.performOperation(operation);
        return worry;
    }

    @Override
    public boolean performTest(Worry value) {
        return value.checkIfDivisible(divisibleBy);
    }
}
