package AoC2023.Day19;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Array;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
class Range {

    final Map<Character, Integer> minMap;
    final Map<Character, Integer> maxMap;
    @Getter
    @Setter
    String nextWorkflow;

    public static Range of() {
        Array<Character> categories = Array.of('x', 'm', 'a', 's');
        return new Range(
                categories.toStream().collect(Collectors.toMap(x -> x, x -> 1)),
                categories.toStream().collect(Collectors.toMap(x -> x, x -> 4000)),
                "in"
        );
    }

    public static Range of(Range otherRange, Character category, int min, int max) {
        Map<Character, Integer> minMap = new HashMap<>(otherRange.minMap);
        Map<Character, Integer> maxMap = new HashMap<>(otherRange.maxMap);
        minMap.put(category, min);
        maxMap.put(category, max);
        return new Range(minMap, maxMap, "");
    }

    public boolean isAccepted() {
        return nextWorkflow.equals("A");
    }

    public boolean isInFinalState() {
        return isAccepted() || nextWorkflow.equals("R");
    }

    public long count() {
        long count = 1;
        for (Character category : minMap.keySet()) {
            count *= maxMap.get(category) - minMap.get(category) + 1;
        }
        return count;
    }

    public Tuple2<Range, Range> splitOnCondition(Condition condition) {
        Range accepted = null;
        Range rejected = null;
        Character category = condition.getCategory();
        int minForCategory = minMap.get(category);
        int maxForCategory = maxMap.get(category);
        int conditionValue = condition.getValue();
        if (condition.isGreaterThan()) {
            if (minForCategory > conditionValue) {
                accepted = this;
            } else if (maxForCategory < conditionValue) {
                rejected = this;
            } else {
                accepted = Range.of(this, category, conditionValue + 1, maxForCategory);
                rejected = Range.of(this, category, minForCategory, conditionValue);
            }
        } else {
            if (minForCategory > conditionValue) {
                rejected = this;
            } else if (maxForCategory < conditionValue) {
                accepted = this;
            } else {
                accepted = Range.of(this, category, minForCategory, conditionValue - 1);
                rejected = Range.of(this, category, conditionValue, maxForCategory);
            }
        }
        return Tuple.of(accepted, rejected);
    }
}
