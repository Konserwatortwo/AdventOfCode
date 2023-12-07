package AoC2023.Day7;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
enum HandType {
    FIVE_OF_KIND,
    FOUR_OF_KIND,
    FULL_HOUSE,
    THREE_OF_KIND,
    TWO_PAIR,
    PAIR,
    HIGH_CARD;
    
    public static HandType determineTypeFromPattern(String pattern) {
        return switch (pattern) {
            case "5" -> FIVE_OF_KIND;
            case "41" -> FOUR_OF_KIND;
            case "32" -> FULL_HOUSE;
            case "311" -> THREE_OF_KIND;
            case "221" -> TWO_PAIR;
            case "2111" -> PAIR;
            default -> HIGH_CARD;
        };
    }
}
