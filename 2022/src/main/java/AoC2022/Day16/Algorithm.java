package AoC2022.Day16;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm {


    public static final String STARTING_ROOM = "AA";

    public static int searchBestSolution(List<String> input, List<Worker> workers) {
        Room startingRoom = createRoomsAndAssignPaths(input);
        workers.forEach(worker -> worker.moveToRoom(startingRoom));

        Queue<Solution> possibleSolutions = new LinkedList<>();
        possibleSolutions.add(new Solution(workers));
        Solution bestSolution = null;

        while (!possibleSolutions.isEmpty()) {
            Solution currentSolution = possibleSolutions.remove();
            List<Solution> nextSolutions = currentSolution.generateSolutionFromPaths();
            if (nextSolutions.isEmpty()) {
                if(null == bestSolution || bestSolution.getValue() < currentSolution.getValue()) {
                    bestSolution = currentSolution;
                }
            } else {
                possibleSolutions.addAll(nextSolutions);
            }
        }

        return bestSolution.getValue();
    }

    private static Room createRoomsAndAssignPaths(List<String> input) {
        Map<String, Room> roomMap = input.stream().map(Room::new).collect(Collectors.toMap(Room::getName, room -> room));
        roomMap.values().forEach(room -> room.assignRooms(roomMap));
        assignBestPathsToValves(new ArrayList<>(roomMap.values()));
        return roomMap.get(STARTING_ROOM);
    }

    private static void assignBestPathsToValves(List<Room> rooms) {
        for (int i = 0; i < rooms.size() - 1; i++) {
            Room startRoom = rooms.get(i);
            for (int j = i + 1; j < rooms.size(); j++) {
                Room endRoom = rooms.get(j);
                int distance = findBestDistanceBetweenRooms(startRoom, endRoom);
                if (endRoom.isWorthOpening()) {
                    startRoom.assignPathToValve(new Path(endRoom, distance));
                }
                if (startRoom.isWorthOpening()) {
                    endRoom.assignPathToValve(new Path(startRoom, distance));
                }
            }
        }
    }

    private static int findBestDistanceBetweenRooms(Room start, Room end) {
        Set<Room> visited = new HashSet<>();
        Set<Room> nextLevel = new HashSet<>();
        nextLevel.add(start);
        int distance = 0;
        while (!nextLevel.contains(end)) {
            distance++;
            visited.addAll(nextLevel);
            nextLevel = nextLevel.stream()
                    .map(Room::getAdjacentRooms)
                    .flatMap(List::stream)
                    .filter(nextRoom -> !visited.contains(nextRoom))
                    .collect(Collectors.toSet());

        }
        return distance;
    }
}
