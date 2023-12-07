package AoC2023.Day7;

import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

import static AoC2023.Day7.HandType.FIVE_OF_KIND;

@ToString(callSuper = true)
class HandWithJokers extends Hand {
    public HandWithJokers(String inputValue) {
        super(inputValue);
    }

    @Override
    protected String retrieveCardsValueOrder() {
        return "J23456789TQKA";
    }

    @Override
    protected HandType determineType(String value) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : value.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        int numberOfJokers = Optional.of(counter)
                .map(x -> x.remove('J'))
                .orElse(0);
        if (numberOfJokers == 5) {
            return FIVE_OF_KIND;
        }

        Queue<Integer> numberOfCards = counter.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedList::new));
        StringBuilder patternBuilder = new StringBuilder();
        patternBuilder.append(numberOfCards.remove() + numberOfJokers);
        numberOfCards.forEach(patternBuilder::append);
        return HandType.determineTypeFromPattern(patternBuilder.toString());
    }
}
