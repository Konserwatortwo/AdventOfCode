package AoC2022.Day9;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task9B extends AdventTask {

    private static final int NUMBER_OF_POSITIONS = 9;

    public Task9B() {
        super("Day9", "Task9B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Location headLocation = new Location();
        List<Location> locations = createPositionsAfterHead(headLocation);
        Location lastLocation = locations.get(NUMBER_OF_POSITIONS - 1);
        Set<String> visitedPositions = new HashSet<>();

        for (String command : input) {
            String[] elements = command.split(" ");
            int numberOfSteps = Integer.parseInt(elements[1]);
            for (int i = 1; i <= numberOfSteps; i++) {
                headLocation.moveByDirection(elements[0]);

                for (int j = 0; j < NUMBER_OF_POSITIONS; j++) {
                    if (!locations.get(j).isAdjacentToPreviousPosition()) {
                        locations.get(j).adjustToPreviousPosition();
                    }
                }

                visitedPositions.add(lastLocation.toString());
            }
        }

        return List.of(visitedPositions.size() + "");
    }

    private List<Location> createPositionsAfterHead(Location head) {
        List<Location> result = new ArrayList<>();
        Location last = head;
        for (int i = 1; i <= NUMBER_OF_POSITIONS; i++) {
            Location newLocation = new Location(last);
            result.add(newLocation);
            last = newLocation;
        }
        return result;
    }
}
