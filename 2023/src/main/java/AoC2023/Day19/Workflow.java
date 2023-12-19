package AoC2023.Day19;

import io.vavr.Tuple2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static AoC2023.AdventTaskUtils.splitOnSeparator;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class Workflow {

    @Getter
    String name;
    List<Condition> conditions;
    String finalRedirection;

    public static Workflow of(String input) {
        String name = input.substring(0, input.indexOf("{"));
        List<String> elements = splitOnSeparator(input.substring(input.indexOf("{")), ",", "{", "}");
        int lastElementIndex = elements.size() - 1;
        return new Workflow(name,
                elements.subList(0, lastElementIndex).stream()
                        .map(Condition::of)
                        .collect(Collectors.toList()),
                elements.get(lastElementIndex)
        );
    }

    public void moveThrough(Part part) {
        Condition successfulCondition = null;
        int i = 0;
        while (null == successfulCondition && i < conditions.size()) {
            Condition condition = conditions.get(i++);
            if (part.checkCondition(condition)) {
                successfulCondition = condition;
            }
        }
        if (null == successfulCondition) {
            part.setNextWorkflow(finalRedirection);
        } else {
            part.setNextWorkflow(successfulCondition.getRedirection());
        }
    }

    public List<Range> moveThrough(Range range) {
        List<Range> createdRanges = new ArrayList<>();
        Range currentRange = range;
        int i = 0;
        while (null != currentRange && i < conditions.size()) {
            Condition condition = conditions.get(i++);
            Tuple2<Range, Range> result = currentRange.splitOnCondition(condition);
            if (null != result._1) {
                result._1.setNextWorkflow(condition.getRedirection());
                createdRanges.add(result._1);
            }
            currentRange = result._2;
        }
        if (null != currentRange) {
            currentRange.setNextWorkflow(finalRedirection);
            createdRanges.add(currentRange);
        }
        return createdRanges;
    }
}
