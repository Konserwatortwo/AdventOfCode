package AoC2021.Day10;

import AoC2021.AdventTask;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Task10A extends AdventTask {

    private static final Map<Character, Character> brackets =
            Map.of(
                    '(', ')',
                    '[', ']',
                    '{', '}',
                    '<', '>');

    public Task10A() {
        super("Day10", "Task10A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int inputValue = 0;
        for (String line : input) {
            inputValue += validateLine(line);
        }

        return List.of(inputValue + "");
    }

    private int validateLine(String line) {
        Stack<Character> currentChunk = new Stack<>();
        for (char sign : line.toCharArray()) {
            if (brackets.containsKey(sign)) {
                currentChunk.push(sign);
            } else {
                if (sign != brackets.get(currentChunk.pop())) {
                    return switch (sign) {
                        case ')' -> 3;
                        case ']' -> 57;
                        case '}' -> 1197;
                        case '>' -> 25137;
                        default -> throw new IllegalStateException();
                    };
                }
            }
        }
        return 0;
    }
}
