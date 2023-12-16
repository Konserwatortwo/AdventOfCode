package AoC2023.shared;

import lombok.Value;

@Value(staticConstructor = "of")
public class Position {
    int x;
    int y;
}
