package AoC2023.Day12;

import AoC2023.AdventTaskUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static AoC2023.AdventTaskUtils.splitAndParseToInt;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Row {

    String inputValue;
    List<Integer> controlNumbers;

    public static Row of(String line) {
        List<String> elements = AdventTaskUtils.splitOnSeparator(line);
        return new Row(
                elements.get(0).replaceAll("(\\.)+", "."),
                splitAndParseToInt(elements.get(1), ",")
        );
    }

    public Row extend(int numberOfRepeats) {
        return new Row(
                StringUtils.repeat(inputValue, "?", numberOfRepeats),
                Collections.nCopies(5, controlNumbers).stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
        );
    }

    public long calculateNumberOfPhases() {
        return Phase.of(inputValue, controlNumbers).countPhases();
    }
}
