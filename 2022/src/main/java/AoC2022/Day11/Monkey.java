package AoC2022.Day11;

import java.util.Queue;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Monkey<T> {

    private final Integer number;
    protected final Queue<T> items;
    protected final Function<Integer, Integer> operation;
    protected final Integer divisibleBy;
    private final int numberOfMonkeyIfTestPass;
    private final int numberOfMonkeyIfTestFail;

    private int numberOfInspections;

    public Monkey(Integer number,
                  Queue<T> items,
                  Function<Integer, Integer> operation,
                  Integer divisibleBy,
                  int numberOfMonkeyIfTestPass,
                  int numberOfMonkeyIfTestFail) {
        this.number = number;
        this.items = items;
        this.operation = operation;
        this.divisibleBy = divisibleBy;
        this.numberOfMonkeyIfTestPass = numberOfMonkeyIfTestPass;
        this.numberOfMonkeyIfTestFail = numberOfMonkeyIfTestFail;
        this.numberOfInspections = 0;
    }

    public boolean haveMoreItems() {
        return !items.isEmpty();
    }

    public T inspectNextItem() {
        numberOfInspections++;
        return performInspection();
    }

    protected abstract T performInspection();

    public int checkWhereThrowItem(T value) {
        return performTest(value) ? numberOfMonkeyIfTestPass : numberOfMonkeyIfTestFail;
    }

    protected abstract boolean performTest(T value);

    public void addItem(T item) {
        items.add(item);
    }

    public int getNumberOfInspections() {
        return numberOfInspections;
    }

    @Override
    public String toString() {
        return "Monkey " + number + ", Items: " + items;
    }
}
