package AoC2022.Day16;

import java.util.*;
import java.util.stream.Collectors;

public class PathFinder {

    public static List<Path> generatePathsWithoutDuplicates(List<String> input, int timeForPath) {
        Room startingRoom = RoomBuilder.createRoomsAndAssignPaths(input);
        List<Path> paths = generatePaths(startingRoom, timeForPath);
        return removeDuplicates(paths);
    }

    private static List<Path> generatePaths(Room currentRoom, int timeLeft) {
        return currentRoom.getCostsToOtherValves().stream()
                .map(cost -> generatePaths(cost, timeLeft))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static List<Path> generatePaths(Cost cost, int timeLeft) {
        return generatePaths(cost.getTo(), timeLeft - cost.getCost(), 0, new HashSet<>());
    }

    private static List<Path> generatePaths(Room currentRoom, int timeLeft, int value, Set<Room> alreadyVisited) {
        List<Path> result = new ArrayList<>();
        alreadyVisited.add(currentRoom);
        int currentValue = value + currentRoom.getFlowRate() * timeLeft;
        result.add(new Path(currentValue, alreadyVisited));

        List<Cost> possibleCosts = currentRoom.getCostsToOtherValves().stream()
                .filter(cost -> cost.getCost() < timeLeft)
                .filter(cost -> !alreadyVisited.contains(cost.getTo()))
                .collect(Collectors.toList());
        for (Cost cost : possibleCosts) {
            result.addAll(generatePaths(cost.getTo(), timeLeft - cost.getCost(), currentValue, new HashSet<>(alreadyVisited)));
        }
        return result;
    }

    private static List<Path> removeDuplicates(List<Path> paths) {
        Map<Set<Room>, List<Path>> pathsRoomMap = paths.stream()
                .collect(Collectors.groupingBy(Path::getRooms));
        return pathsRoomMap.values().stream()
                .map(Collections::max)
                .collect(Collectors.toList());
    }
}
