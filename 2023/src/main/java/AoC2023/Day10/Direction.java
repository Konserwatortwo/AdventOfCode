package AoC2023.Day10;

import AoC2023.shared.Position;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
enum Direction {

    NORTH('|', 'F', '7'),
    EAST('-', '7', 'J'),
    SOUTH('|', 'J', 'L'),
    WEST('-', 'L', 'F');

    char forward;
    char turnRight;
    char turnLeft;

    Direction(char forward, char turnRight, char turnLeft) {
        this.forward = forward;
        this.turnLeft = turnLeft;
        this.turnRight = turnRight;
    }

    public Position determineNextPosition(Position currentPosition) {
        return switch (this) {
            case NORTH -> Position.of(currentPosition.getX(), currentPosition.getY() - 1);
            case EAST -> Position.of(currentPosition.getX() + 1, currentPosition.getY());
            case SOUTH -> Position.of(currentPosition.getX(), currentPosition.getY() + 1);
            case WEST -> Position.of(currentPosition.getX() - 1, currentPosition.getY());
        };
    }

    public Direction determineNextDirection(char sing) {
        if (sing == forward || sing == 'S') {
            return this;
        }
        if (sing == turnRight) {
            return switch (this) {
                case NORTH -> EAST;
                case EAST -> SOUTH;
                case SOUTH -> WEST;
                case WEST -> NORTH;
            };
        }
        if (sing == turnLeft) {
            return switch (this) {
                case NORTH -> WEST;
                case EAST -> NORTH;
                case SOUTH -> EAST;
                case WEST -> SOUTH;
            };
        }
        return null;
    }
}
