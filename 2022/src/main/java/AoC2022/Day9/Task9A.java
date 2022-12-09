package AoC2022.Day9;

import AoC2022.AdventTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task9A extends AdventTask {

    public Task9A() {
        super("Day9", "Task9A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Position headPosition = new Position();
        Position tailPosition = new Position(headPosition);
        Set<String> visitedPositions = new HashSet<>();
        visitedPositions.add(tailPosition.toString());

        for (String command : input) {
            String[] elements = command.split(" ");
            int numberOfSteps = Integer.parseInt(elements[1]);
            for (int i = 1; i <= numberOfSteps; i++) {
                headPosition.moveByDirection(elements[0]);
                if(!tailPosition.isAdjacentToPreviousPosition()) {
                    tailPosition.adjustToPreviousPosition();
                    visitedPositions.add(tailPosition.toString());
                }
            }
        }

        return List.of(visitedPositions.size()+"");
    }
}
