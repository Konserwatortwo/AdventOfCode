package AoC2023.Day12;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode
@ToString
public class Phase {

    String inputValue;
    List<Integer> controlNumbers;
    int numberIdx;
    int length;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    HashMap<Phase, Long> cache;

    public static Phase of(String inputValue, List<Integer> controlNumbers) {
        return new Phase(inputValue + ".", controlNumbers, 0, 0, new HashMap<>());
    }

    public static Phase of(Phase phase, int numberIdx, int length) {
        return new Phase(
                phase.inputValue.substring(1),
                phase.controlNumbers,
                numberIdx,
                length,
                phase.cache
        );
    }

    public long countPhases() {
        if (StringUtils.isEmpty(inputValue)) {
            return length == 0 && numberIdx == controlNumbers.size() ? 1 : 0;
        }
        if (!cache.containsKey(this)) {
            cache.put(this, determineValue());
        }
        return cache.get(this);
    }

    private long determineValue() {
        return switch (inputValue.charAt(0)) {
            case '#' -> stepSpring();
            case '.' -> stepEmpty();
            case '?' -> stepSpring() + stepEmpty();
            default -> throw new IllegalStateException("Unexpected value: " + inputValue.charAt(0));
        };
    }

    private long stepSpring() {
        return numberIdx == controlNumbers.size() || length >= controlNumbers.get(numberIdx)
                ? 0
                : Phase.of(this, numberIdx, length + 1).countPhases();
    }

    private long stepEmpty() {
        if (length == 0) {
            return Phase.of(this, numberIdx, 0).countPhases();
        }
        return controlNumbers.get(numberIdx) != length
                ? 0
                : Phase.of(this, numberIdx + 1, 0).countPhases();
    }
}
