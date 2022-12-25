package AoC2022.Day21;

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

    public Operation getOperation() {
        return operation;
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
}
