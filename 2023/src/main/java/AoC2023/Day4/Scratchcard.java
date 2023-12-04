package AoC2023.Day4;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class Scratchcard {

    List<Integer> winningNumbers;
    List<Integer> cardsNumbers;

    public Scratchcard(String inputLine) {
        String[] elements = inputLine.split(":")[1].split("\\|");
        this.winningNumbers = parseNumbers(elements[0]);
        this.cardsNumbers = parseNumbers(elements[1]);
    }

    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(" "))
                .filter(StringUtils::isNotEmpty)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int numberOfWinningCards() {
        return (int) cardsNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int value() {
        return (int) (Math.pow(2, numberOfWinningCards()) / 2);
    }
}
