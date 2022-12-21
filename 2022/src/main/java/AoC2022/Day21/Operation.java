package AoC2022.Day21;

import java.util.function.BiFunction;

public enum Operation {
    ADD((x, y) -> x + y),
    SUBTRACT((x, y) -> x - y),
    MULTIPLY((x, y) -> x * y),
    DIVIDE((x, y) -> x / y);

    private final BiFunction<Long, Long, Long> operation;

    Operation(BiFunction<Long, Long, Long> operation) {
        this.operation = operation;
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

    public static Operation determineReverseOperation(Operation operation) {
        return switch (operation) {
            case ADD -> Operation.SUBTRACT;
            case SUBTRACT -> Operation.ADD;
            case MULTIPLY -> Operation.DIVIDE;
            case DIVIDE -> Operation.MULTIPLY;
        };
    }
}
