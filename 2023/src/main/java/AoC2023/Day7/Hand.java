package AoC2023.Day7;

import AoC2023.AdventTaskUtils;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
abstract class Hand implements Comparable<Hand> {

    String value;
    HandType handType;
    int bid;

    protected Hand(String inputValue) {
        List<String> elements = AdventTaskUtils.splitOnSeparator(inputValue);
        this.value = elements.get(0);
        this.handType = determineType(elements.get(0));
        this.bid = Integer.parseInt(elements.get(1));
    }

    protected abstract String retrieveCardsValueOrder();

    protected abstract HandType determineType(String value);

    public int bidValue(int multiplayer) {
        return bid * multiplayer;
    }

    @Override
    public int compareTo(Hand otherHand) {
        return handType == otherHand.handType
                ? compareValues(otherHand.value)
                : handType.compareTo(otherHand.handType);
    }

    private int compareValues(String otherHandValue) {
        String cardsValue = retrieveCardsValueOrder();
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != otherHandValue.charAt(i)) {
                return Integer.compare(cardsValue.indexOf(otherHandValue.charAt(i)), cardsValue.indexOf(value.charAt(i)));
            }
        }
        return 0;
    }
}
