package AoC2023.Day20;

import AoC2023.AdventTaskUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
@ToString
class Module {

    final String name;
    List<String> outputs;

    public Module(String inputLine) {
        int indexOfArrow = inputLine.indexOf("->");
        this.name = inputLine.substring(0, indexOfArrow - 1).replace("%", "").replace("&", "");
        this.outputs = AdventTaskUtils.splitOnSeparator(inputLine.substring(indexOfArrow + 2), " ", ",");
    }

    public List<Signal> receiveSignal(Signal signal) {
        return proceedThroughOutput(signal.isHigh());
    }

    protected List<Signal> proceedThroughOutput(boolean isSignalHigh) {
        return outputs.stream()
                .map(output -> Signal.of(isSignalHigh, name, output))
                .collect(Collectors.toList());
    }
}
