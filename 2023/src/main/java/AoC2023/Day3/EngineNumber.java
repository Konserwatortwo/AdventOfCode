package AoC2023.Day3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
class EngineNumber {

    int value;

    public static EngineNumber of(String value) {
        return new EngineNumber(Integer.parseInt(value));
    }
}
