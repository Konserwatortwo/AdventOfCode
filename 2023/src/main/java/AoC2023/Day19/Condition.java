package AoC2023.Day19;

import lombok.Value;

@Value
class Condition {

    char category;
    boolean isGreaterThan;
    int value;
    String redirection;

    public static Condition of(String input) {
        int splitIndex = input.indexOf(":");
        assert splitIndex > 0;
        return new Condition(
                input.charAt(0),
                input.charAt(1) == '>',
                Integer.parseInt(input.substring(2, splitIndex)),
                input.substring(splitIndex + 1));
    }
}
