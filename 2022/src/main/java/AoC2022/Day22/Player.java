package AoC2022.Day22;

import AoC2022.common.Direction;
import AoC2022.common.DirectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final List<String> instructionList;
    private ExtendedPosition position;
    private Direction direction;

    public Player(ExtendedPosition startingPosition, String instructionLine) {
        this.instructionList = generateInstructions(instructionLine);
        this.position = startingPosition;
        this.direction = Direction.EAST;
    }

    private List<String> generateInstructions(String instructionLine) {
        String[] elements = instructionLine
                .replace("L", ";L;")
                .replace("R", ";R;")
                .split(";");
        return Arrays.stream(elements).collect(Collectors.toList());
    }

    public void runInstructions() {
        for (String instructions : instructionList) {
            switch (instructions) {
                case "R" -> direction = DirectionUtils.retrieveClockwise(direction);
                case "L" -> direction = DirectionUtils.retrieveCounterClockwise(direction);
                default -> move(Integer.parseInt(instructions));
            }
        }
    }


    private void move(int stepsNumber) {
        int steps = 0;
        while (position.canMoveInDirection(direction) && steps < stepsNumber) {
            steps++;
            Side oldSide = position.getSide();
            position = position.moveInDirection(direction);
            Side newSide = position.getSide();
            if (null != oldSide && null != newSide && oldSide != newSide) {
                direction = DirectionUtils.retrieveOpposite(newSide.getOtherSideDirection(oldSide));
            }
        }
        System.out.println(position);
    }


    public int calculatePassword() {
        int valueForDirection = switch (direction) {
            case NORTH -> 3;
            case EAST -> 0;
            case SOUTH -> 1;
            case WEST -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
        return 1000 * (position.getY() + 1) + 4 * (position.getX() + 1) + valueForDirection;
    }

}
