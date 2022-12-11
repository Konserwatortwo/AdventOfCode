package AoC2022.Day11;

import java.util.Queue;
import java.util.function.Function;
import java.util.function.Predicate;

public class NormalMonkey extends Monkey<Integer> {

    public NormalMonkey(Integer number,
                        Queue<Integer> items,
                        Function<Integer, Integer> operation,
                        Integer divisibleBy,
                        int numberOfMonkeyIfTestPass,
                        int numberOfMonkeyIfTestFail) {
        super(number, items, operation, divisibleBy, numberOfMonkeyIfTestPass, numberOfMonkeyIfTestFail);
    }

    @Override
    public Integer performInspection() {
        return operation.apply(items.poll());
    }

    @Override
    public boolean performTest(Integer value) {
        return value % divisibleBy == 0;
    }
}
