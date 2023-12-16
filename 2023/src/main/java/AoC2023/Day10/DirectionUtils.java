package AoC2023.Day10;

import AoC2023.shared.Direction;

import java.util.Map;

class DirectionUtils {

    private static final Map<Direction, Character> turnRightSign =
            Map.of(
                    Direction.NORTH, 'F',
                    Direction.EAST, '7',
                    Direction.SOUTH, 'J',
                    Direction.WEST, 'L'
            );

    private static final Map<Direction, Character> turnLeftSign =
            Map.of(
                    Direction.NORTH, '7',
                    Direction.EAST, 'J',
                    Direction.SOUTH, 'L',
                    Direction.WEST, 'F'
            );

    public static Direction determineNextDirection(Direction direction, char sing) {
        if (sing == 'S') {
            return direction;
        } else if (direction.isVertical() && sing == '|') {
            return direction;
        } else if (!direction.isVertical() && sing == '-') {
            return direction;
        } else if (turnRightSign.get(direction) == sing) {
            return direction.goRight();
        } else if (turnLeftSign.get(direction) == sing) {
            return direction.goLeft();
        }
        return null;
    }
}
