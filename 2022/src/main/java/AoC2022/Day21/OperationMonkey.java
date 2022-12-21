package AoC2022.Day21;

import org.apache.commons.lang3.StringUtils;

public class OperationMonkey extends Monkey {
    private final Operation operation;
    private final Monkey firstMonkey;
    private final Monkey secondMonkey;

    public OperationMonkey(String name, Operation operation, Monkey firstMonkey, Monkey secondMonkey, boolean isHumanDependant) {
        super(name, isHumanDependant);
        this.operation = operation;
        this.firstMonkey = firstMonkey;
        this.secondMonkey = secondMonkey;
    }

    public Monkey getFirstMonkey() {
        return firstMonkey;
    }

    public Monkey getSecondMonkey() {
        return secondMonkey;
    }

    public void performOperation(long firstMonkeyResult, long secondMonkeyResult) {
        setResult(operation.perform(firstMonkeyResult, secondMonkeyResult));
    }

    public long reverseOperation(long firstMonkeyResult, long secondMonkeyResult) {
        Operation reversedOperation = Operation.determineReverseOperation(operation);
        return reversedOperation.perform(firstMonkeyResult, secondMonkeyResult);
    }

    @Override
    public String toString() {
        return super.toString() + ": " + operation + " [" + StringUtils.upperCase(firstMonkey.getName())
                + "," + StringUtils.upperCase(secondMonkey.getName()) + "]";
    }
}
