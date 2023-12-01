package AoC2023.Day1;

import AoC2023.AdventTask;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Task1B extends AdventTask {

    private enum Numbers {
        one('1'),
        two('2'),
        three('3'),
        four('4'),
        five('5'),
        six('6'),
        seven('7'),
        eight('8'),
        nine('9'),
        zero('0');

        final char value;

        Numbers(char value) {
            this.value = value;
        }
    }

    public Task1B() {
        super("Day1", "Task1B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int sum = 0;
        for (String line : input) {
            char firstDigit = findDigit(line, (x, y) -> x + y);
            char lastDigit = findDigit(StringUtils.reverse(line), (x, y) -> y + x);
            sum += Integer.parseInt(firstDigit + "" + lastDigit);
        }
        return List.of(sum + "");
    }

    private char findDigit(String line, BiFunction<String, Character, String> applyingNewSing) {
        String readerLine = "";
        for (char sign : line.toCharArray()) {
            if (sign >= 48 && sign <= 57) {
                return sign;
            }
            readerLine = applyingNewSing.apply(readerLine, sign);
            Numbers possibleNumber = containsNumber(readerLine);
            if (null != possibleNumber) {
                return possibleNumber.value;
            }
        }
        throw new IllegalStateException("Did not find any number in line");
    }

    private Numbers containsNumber(String line) {
        return Arrays.stream(Numbers.values())
                .filter(number -> line.contains(number.name()))
                .findAny()
                .orElse(null);
    }
}
