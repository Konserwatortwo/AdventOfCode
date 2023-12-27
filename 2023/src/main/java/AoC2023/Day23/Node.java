package AoC2023.Day23;

import AoC2023.shared.Position;
import lombok.Value;

@Value(staticConstructor = "of")
class Node {

    Position first;
    Position last;
    int size;

    public Position getOtherPosition(Position position) {
        return last.equals(position) ? first : last;
    }
}
