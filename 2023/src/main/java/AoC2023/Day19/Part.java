package AoC2023.Day19;

import AoC2023.AdventTaskUtils;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
class Part {

    final Map<Character, Integer> categoryMap;
    @Getter
    @Setter
    String nextWorkflow;

    public static Part of(String input) {
        List<String> elements = AdventTaskUtils.splitOnSeparator(input, ",", "{", "}");
        Map<Character, Integer> valueMap = elements.stream()
                .collect(Collectors.toMap(
                        element -> element.charAt(0),
                        element -> Integer.parseInt(element.substring(2))
                ));
        return new Part(valueMap, "in");
    }

    public boolean isAccepted() {
        return nextWorkflow.equals("A");
    }

    public boolean isInFinalState() {
        return isAccepted() || nextWorkflow.equals("R");
    }

    public int getSum() {
        return categoryMap.values().stream().mapToInt(x -> x).sum();
    }

    public boolean checkCondition(Condition condition) {
        int partValue = categoryMap.get(condition.getCategory());
        return condition.isGreaterThan() ? partValue > condition.getValue() : partValue < condition.getValue();
    }
}
