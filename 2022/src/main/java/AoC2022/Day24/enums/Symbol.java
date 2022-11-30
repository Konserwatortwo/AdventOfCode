package AoC2022.Day24.enums;

import java.util.Arrays;

public enum Symbol {
    A("a"),
    W("w"),
    X("x"),
    Y("y"),
    Z("z");

    private final String text;

    Symbol(String text) {
        this.text = text;
    }

    public static Symbol retrieveSymbol(String searchedText) {
        return Arrays.stream(values())
                .filter(symbol -> symbol.text.equals(searchedText))
                .findFirst()
                .orElse(null);
    }
}
