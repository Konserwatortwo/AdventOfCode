package AoC2021.Day24.enums;

import java.util.Arrays;

public enum Operation {
    ADD("add"),
    MUL("mul"),
    DIV("div"),
    MOD("mod"),
    EQL("eql");

    private final String text;

    Operation(String text) {
        this.text = text;
    }

    public static Operation retrieveOperation(String searchedText) {
        return Arrays.stream(values())
                .filter(operation -> operation.text.equals(searchedText))
                .findFirst()
                .orElse(null);
    }
}
