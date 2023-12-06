package AoC2023;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AdventTaskUtils {

    public static List<String> splitOnSeparator(String input, String separator, String... wordsToRemove) {
        for (String wordToRemove : wordsToRemove) {
            input = StringUtils.remove(input, wordToRemove);
        }
        return Arrays.stream(StringUtils.split(input, separator))
                .collect(Collectors.toList());
    }

    public static List<String> splitOnSeparatorWithoutWhitespaces(String input, String separator, String... wordsToRemove) {
        return splitOnSeparator(input, separator, wordsToRemove).stream()
                .map(StringUtils::deleteWhitespace)
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toList());
    }

    public static <T> List<T> splitAndParse(
            String input,
            String separator,
            Function<String, T> parsingFunction,
            String... wordsToRemove) {
        return splitOnSeparatorWithoutWhitespaces(input, separator, wordsToRemove).stream()
                .map(parsingFunction)
                .collect(Collectors.toList());
    }

    public static List<Integer> splitAndParseToInt(String input, String separator, String... wordsToRemove) {
        return splitAndParse(input, separator, Integer::parseInt, wordsToRemove);
    }

    public static List<Long> splitAndParseToLong(String input, String separator, String... wordsToRemove) {
        return splitAndParse(input, separator, Long::parseLong, wordsToRemove);
    }

    public static List<Double> splitAndParseToDouble(String input, String separator, String... wordsToRemove) {
        return splitAndParse(input, separator, Double::parseDouble, wordsToRemove);
    }

    public static List<String> answerAs(String answer) {
        return List.of(answer);
    }

    public static List<String> answerAs(int answer) {
        return List.of(answer + "");
    }

    public static List<String> answerAs(long answer) {
        return List.of(answer + "");
    }

    public static List<String> answerAs(double answer) {
        return List.of(answer + "");
    }
}
