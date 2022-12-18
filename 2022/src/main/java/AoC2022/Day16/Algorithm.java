package AoC2022.Day16;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm {
    public static final String STARTING_ROOM = "AA";

    public static int searchBestSolution(List<String> input, List<Worker> workers) {
        Room startingRoom = createRoomsAndAssignPaths(input);
        workers.forEach(worker -> worker.moveToRoom(startingRoom));

        Map<Set<Room>, List<Solution>> cache = new HashMap<>();
        IterationResult iterationResult = new IterationResult(new Solution(workers));

        while (!iterationResult.getNextIteration().isEmpty()) {
            iterationResult = runIteration(iterationResult, cache);
        }

        assert iterationResult.getBestSolution() != null;
        return iterationResult.getBestSolution().getValue();
    }

    private static IterationResult runIteration(IterationResult previousIteration, Map<Set<Room>, List<Solution>> cache) {
        Queue<Solution> currentIteration = new LinkedList<>(previousIteration.getNextIteration());
        IterationResult iterationResult = new IterationResult(previousIteration);

        while (!currentIteration.isEmpty()) {
            Solution currentSolution = currentIteration.remove();
            List<Solution> nextSolutions = currentSolution.generateSolutionFromPaths();
            Set<Solution> solutionsWithoutDuplicates = nextSolutions.stream()
                    .filter(solution -> !isBetterSolutionInCache(solution, cache))
                    .collect(Collectors.toSet());
            iterationResult.addToNextIteration(solutionsWithoutDuplicates);

            if (nextSolutions.isEmpty()) {
                iterationResult.assignBestSolution(currentSolution);
            }
        }

        return iterationResult;
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

    private static boolean isBetterSolutionInCache(Solution nextSolution, Map<Set<Room>, List<Solution>> cache) {
        Set<Room> key = nextSolution.getRoomsWithOpenValves();
        return cache.containsKey(key) && cache.get(key).stream()
                .anyMatch(similarSolution -> similarSolution.haveWorkersInSameRooms(nextSolution) && similarSolution.isBetterThan(nextSolution));
    }

    private static Room createRoomsAndAssignPaths(List<String> input) {
        Map<String, Room> roomMap = input.stream().map(Room::new).collect(Collectors.toMap(Room::getName, room -> room));
        roomMap.values().forEach(room -> room.assignRooms(roomMap));
        assignBestPathsToValves(new ArrayList<>(roomMap.values()));
        return roomMap.get(STARTING_ROOM);
    }

    private static class IterationResult {
        private Solution bestSolution;
        private final Queue<Solution> nextIteration;

        public IterationResult(Solution firstSolution) {
            this.bestSolution = null;
            this.nextIteration = new LinkedList<>();
            this.nextIteration.add(firstSolution);
        }

        public IterationResult(IterationResult other) {
            this.bestSolution = other.getBestSolution();
            this.nextIteration = new LinkedList<>();
        }

        public Solution getBestSolution() {
            return bestSolution;
        }

        public Queue<Solution> getNextIteration() {
            return nextIteration;
        }

        public void addToNextIteration(Set<Solution> solutions) {
            this.nextIteration.addAll(solutions);
        }

        public void assignBestSolution(Solution solution) {
            if (null == bestSolution || bestSolution.getValue() < solution.getValue()) {
                bestSolution = solution;
            }
        }
    }
}
