package AoC2023.Day4;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static AoC2023.AdventTaskUtils.splitAndParseToInt;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class Scratchcard {

    List<Integer> winningNumbers;
    List<Integer> cardsNumbers;

    public Scratchcard(String inputLine) {
        String[] elements = inputLine.split(":")[1].split("\\|");
        this.winningNumbers = splitAndParseToInt(elements[0]);
        this.cardsNumbers = splitAndParseToInt(elements[1]);
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
