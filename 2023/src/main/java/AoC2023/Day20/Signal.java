package AoC2023.Day20;

import lombok.Value;

@Value(staticConstructor = "of")
class Signal {

    boolean isHigh;
    String from;
    String to;
}
