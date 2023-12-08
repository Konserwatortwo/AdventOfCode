package AoC2023.Day8;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Instruction {

    @Getter
    int nextPointer;
    final String value;

    public Instruction(String value) {
        this(0, value);
    }

    public char retrieveNextInstruction() {
        if (nextPointer == value.length()) {
            nextPointer = 0;
        }
        return value.charAt(nextPointer++);
    }
}
