package AoC2023.Day3;

import AoC2023.shared.Position;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class EngineGrid {

    Map<Position, EngineNumber> placesWithNumbers;
    Map<Position, Character> placesWithSymbol;

    public EngineGrid(List<String> input) {
        placesWithNumbers = new HashMap<>();
        placesWithSymbol = new HashMap<>();
        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            String currentNumber = "";
            char[] charArray = line.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                char currentSign = charArray[x];
                if (Character.isDigit(currentSign)) {
                    currentNumber += currentSign;
                } else {
                    if (StringUtils.isNotEmpty(currentNumber)) {
                        EngineNumber engineNumber = EngineNumber.of(currentNumber);
                        for (int i = 0; i < currentNumber.length(); i++) {
                            placesWithNumbers.put(Position.of(x - i - 1, y), engineNumber);
                        }
                        currentNumber = "";
                    }
                    if (currentSign != '.') {
                        placesWithSymbol.put(Position.of(x, y), currentSign);
                    }
                }
            }
            if (StringUtils.isNotEmpty(currentNumber)) {
                EngineNumber engineNumber = EngineNumber.of(currentNumber);
                for (int i = 0; i < currentNumber.length(); i++) {
                    placesWithNumbers.put(Position.of(charArray.length - i - 1, y), engineNumber);
                }
            }
        }
    }

    public int sumOfAllNumbersNearSymbol() {
        Set<EngineNumber> engineNumbers = new HashSet<>();
        for (Position placeWithSymbol : placesWithSymbol.keySet()) {
            engineNumbers.addAll(
                    placeWithSymbol.nearbyPositionsExtended().stream()
                            .filter(placesWithNumbers::containsKey)
                            .map(placesWithNumbers::get)
                            .collect(Collectors.toSet())
            );
        }
        return engineNumbers.stream()
                .mapToInt(EngineNumber::getValue)
                .sum();
    }

    public int sumOfAllNumbersNearGear() {
        int sum = 0;
        for (Position enginePlace : placesWithSymbol.keySet()) {
            if (placesWithSymbol.get(enginePlace) == '*') {
                Set<EngineNumber> engineNumbers = enginePlace.nearbyPositionsExtended().stream()
                        .filter(placesWithNumbers::containsKey)
                        .map(placesWithNumbers::get)
                        .collect(Collectors.toSet());
                if (engineNumbers.size() == 2) {
                    sum += engineNumbers.stream()
                            .mapToInt(EngineNumber::getValue)
                            .reduce(1, (x, y) -> x * y);
                }
            }
        }
        return sum;
    }
}
