package AoC2022.Day22;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final List<String> instructionList;
    private Position position;
    private Direction direction;

    public Player(Position startingPosition, String instructionLine) {
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
                case "R" -> direction = direction.rotationClockwise();
                case "L" -> direction = direction.rotationCounterClockwise();
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
                Direction opositteToExisting = newSide.getOtherSideDirection(oldSide);
                direction = switch (opositteToExisting) {
                    case NORTH -> Direction.SOUTH;
                    case EAST -> Direction.WEST;
                    case SOUTH -> Direction.NORTH;
                    case WEST -> Direction.EAST;
                };
            }
        }
        System.out.println(position);
    }


    public int calculatePassword() {
        return 1000 * (position.getY() + 1) + 4 * (position.getX() + 1) + direction.getValueForPassword();
    }
}
