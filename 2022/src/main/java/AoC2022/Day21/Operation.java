package AoC2022.Day21;

import java.util.function.BiFunction;

public enum Operation {
    ADD((x, y) -> x + y, (x, y) -> x - y, (x, y) -> x - y),
    SUBTRACT((x, y) -> x - y, (x, y) -> x + y, (x, y) -> y - x),
    MULTIPLY((x, y) -> x * y, (x, y) -> x / y, (x, y) -> x / y),
    DIVIDE((x, y) -> x / y, (x, y) -> x * y, (x, y) -> y / x);

    private final BiFunction<Long, Long, Long> operation;
    private final BiFunction<Long, Long, Long> reverseOperationLeft;
    private final BiFunction<Long, Long, Long> reverseOperationRight;


    Operation(BiFunction<Long, Long, Long> operation,
              BiFunction<Long, Long, Long> reverseOperationLeft,
              BiFunction<Long, Long, Long> reverseOperationRight) {
        this.operation = operation;
        this.reverseOperationLeft = reverseOperationLeft;
        this.reverseOperationRight = reverseOperationRight;
    }

    public Long perform(Long first, Long second) {
        return operation.apply(first, second);
    }

    public static Operation determineOperation(String sign) {
        return switch (sign) {
            case "+" -> Operation.ADD;
            case "-" -> Operation.SUBTRACT;
            case "*" -> Operation.MULTIPLY;
            case "/" -> Operation.DIVIDE;
            default -> throw new IllegalStateException();
        };
    }

    public Long performReverseOperationLeft(Long first, OperationMonkey operationMonkey) {
        return reverseOperationLeft.apply(first, operationMonkey.getSecondMonkey().getResult());
    }

    public Long performReverseOperationRight(Long first, OperationMonkey operationMonkey) {
        return reverseOperationRight.apply(first, operationMonkey.getFirstMonkey().getResult());
    }
}
