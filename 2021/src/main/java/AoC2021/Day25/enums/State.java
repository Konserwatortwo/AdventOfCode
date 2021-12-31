package AoC2021.Day25.enums;

import java.util.Arrays;

public enum State {
    EMPTY('.'),
    OCCUPIED('*'),
    JUST_MOVED('+'),
    EAST('>'),
    SOUTH('v');

    private final char text;

    State(char text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text + "";
    }

    public static State retrieveState(char searchedSing) {
        return Arrays.stream(values())
                .filter(state -> state.text == searchedSing)
                .findFirst()
                .orElse(null);
    }
}
