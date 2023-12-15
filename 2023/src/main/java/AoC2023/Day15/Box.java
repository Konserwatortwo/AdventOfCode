package AoC2023.Day15;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
public class Box {

    int number;
    Map<String, Integer> lensesPowerMap;

    public static Box of(int number) {
        return new Box(number, new LinkedHashMap<>());
    }

    public void applySequence(Sequence sequence) {
        if (sequence.isRemoving()) {
            lensesPowerMap.remove(sequence.getLabel());
        } else {
            lensesPowerMap.put(sequence.getLabel(), sequence.getFocalLength());
        }
    }

    public int calculatePower() {
        int sum = 0;
        int multiplayer = 1;
        for (Integer value : lensesPowerMap.values()) {
            sum += value * multiplayer++;
        }
        return number * sum;
    }
}
