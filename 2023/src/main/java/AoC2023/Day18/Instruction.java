package AoC2023.Day18;

import AoC2023.AdventTaskUtils;
import AoC2023.shared.Direction;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Instruction {

    Direction direction;
    int length;

    public static List<Instruction> createInstructions(List<String> inputValue) {
        return inputValue.stream()
                .map(AdventTaskUtils::splitOnSeparator)
                .map(Instruction::of)
                .collect(Collectors.toList());
    }

    public static List<Instruction> createDecodedInstructions(List<String> inputValue) {
        return inputValue.stream()
                .map(AdventTaskUtils::splitOnSeparator)
                .map(Instruction::decode)
                .collect(Collectors.toList());
    }

    private static Instruction of(List<String> elements) {
        assert elements.size() == 3;
        Direction direction = switch (elements.get(0)) {
            case "U" -> Direction.NORTH;
            case "D" -> Direction.SOUTH;
            case "R" -> Direction.EAST;
            case "L" -> Direction.WEST;
            default -> throw new IllegalStateException("Wrong letter");
        };
        return new Instruction(direction, Integer.parseInt(elements.get(1)));
    }

    private static Instruction decode(List<String> elements) {
        assert elements.size() == 3;
        String colorValue = elements.get(2);
        colorValue = colorValue.substring(1, colorValue.length() - 1);
        String hexNumber = colorValue.substring(0, colorValue.length() - 1).replace("#", "0x");
        Direction direction = switch (colorValue.charAt(colorValue.length() - 1)) {
            case '3' -> Direction.NORTH;
            case '1' -> Direction.SOUTH;
            case '0' -> Direction.EAST;
            case '2' -> Direction.WEST;
            default -> throw new IllegalStateException("Wrong letter");
        };
        return new Instruction(direction, Integer.decode(hexNumber));
    }
}
