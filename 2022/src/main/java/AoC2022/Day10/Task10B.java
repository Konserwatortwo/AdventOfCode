package AoC2022.Day10;

import AoC2022.AdventTask;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.w3c.dom.ls.LSInput;

import java.math.BigInteger;
import java.util.*;

public class Task10B extends AdventTask {

    private static final Map<Character, Character> brackets =
            Map.of(
                    '(', ')',
                    '[', ']',
                    '{', '}',
                    '<', '>');

    public Task10B() {
        super("Day10", "Task10B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<BigInteger> outputs = new ArrayList<>();
        for (String line : input) {
            outputs.add(validateLine(line));
        }
        CollectionUtils.filter(outputs, PredicateUtils.notNullPredicate());
        Collections.sort(outputs);
        BigInteger middleElement = outputs.get(outputs.size() / 2);

        return List.of(middleElement + "");
    }

    private BigInteger validateLine(String line) {
        Stack<Character> currentChunk = new Stack<>();
        for (char sign : line.toCharArray()) {
            if (brackets.containsKey(sign)) {
                currentChunk.push(sign);
            } else {
                if (sign != brackets.get(currentChunk.pop())) {
                    return null;
                }
            }
        }

        BigInteger score = BigInteger.ZERO;
        while (!currentChunk.isEmpty()) {
            score = score.multiply(BigInteger.valueOf(5));
            score = score.add(switch (currentChunk.pop()) {
                case '(' -> BigInteger.valueOf(1);
                case '[' -> BigInteger.valueOf(2);
                case '{' -> BigInteger.valueOf(3);
                case '<' -> BigInteger.valueOf(4);
                default -> throw new IllegalStateException();
            });
        }
        return score;
    }
}
