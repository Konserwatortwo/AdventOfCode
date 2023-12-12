package AoC2023.Day12;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode
@ToString
class Phase {

    static HashMap<Phase, Long> cache = new HashMap<>();

    String inputValue;
    List<Integer> controlNumbers;
    int length;

    public static Phase of(String inputValue, List<Integer> controlNumbers) {
        return new Phase(inputValue + ".", controlNumbers, 0);
    }

    public static Phase of(Phase phase, int length, boolean removeNumber) {
        List<Integer> controlNumbers = new ArrayList<>(phase.controlNumbers);
        if (removeNumber) {
            controlNumbers.remove(0);
        }
        return new Phase(phase.inputValue.substring(1), controlNumbers, length);
    }

    public long countPhases() {
        if (StringUtils.isEmpty(inputValue)) {
            return length == 0 && controlNumbers.isEmpty() ? 1 : 0;
        }
        if (!cache.containsKey(this)) {
            cache.put(this, determineValue());
        }
        return cache.get(this);
    }

    private long determineValue() {
        return switch (inputValue.charAt(0)) {
            case '#' -> addSpring();
            case '.' -> separateSprings();
            case '?' -> addSpring() + separateSprings();
            default -> throw new IllegalStateException("Unexpected value: " + inputValue.charAt(0));
        };
    }

    private long addSpring() {
        if (controlNumbers.isEmpty() || length >= controlNumbers.get(0)) {
            return 0;
        }
        return Phase.of(this, length + 1, false).countPhases();
    }

    private long separateSprings() {
        if (length == 0) {
            return Phase.of(this, 0, false).countPhases();
        }
        if (controlNumbers.get(0) != length) {
            return 0;
        }
        return Phase.of(this, 0, true).countPhases();
    }
}
