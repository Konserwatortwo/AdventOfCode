package AoC2023.Day7;

import lombok.ToString;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@ToString(callSuper = true)
class NormalHand extends Hand {

    public NormalHand(String inputValue) {
        super(inputValue);
    }

    @Override
    protected String retrieveCardsValueOrder() {
        return "23456789TJQKA";
    }

    @Override
    protected HandType determineType(String value) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : value.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        String pattern = counter.values().stream()
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .reduce("", (x, y) -> x + y);
        return HandType.determineTypeFromPattern(pattern);
    }
}
