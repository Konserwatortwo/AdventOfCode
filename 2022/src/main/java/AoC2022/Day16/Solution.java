package AoC2022.Day16;

import java.util.*;
import java.util.stream.Collectors;

public class Solution implements Comparable<Solution> {

    private final int value;
    private final Set<Room> roomsWithOpenValves;
    private final Queue<Worker> workers;

    public Solution(List<Worker> workers) {
        this.value = 0;
        this.roomsWithOpenValves = new HashSet<>();
        this.workers = new LinkedList<>(workers);
    }

    public Solution(Solution copyFromSolution, Worker currentWorker, Path pathToValve) {
        Room newRoom = pathToValve.getTo();
        Worker newWorker = new Worker(currentWorker);

        newWorker.takeTime(pathToValve.getCost() + 1);
        newWorker.moveToRoom(newRoom);

        this.value = copyFromSolution.value + (newWorker.getTimeLeft() * newRoom.getFlowRate());

        this.roomsWithOpenValves = new HashSet<>(copyFromSolution.roomsWithOpenValves);
        this.roomsWithOpenValves.add(newRoom);

        this.workers = new LinkedList<>(copyFromSolution.workers);
        this.workers.add(newWorker);
    }

    public List<Solution> generateSolutionFromPaths() {
        List<Solution> result = new ArrayList<>();
        while (result.isEmpty() && !workers.isEmpty()) {
            Worker nextWorker = workers.remove();
            result = nextWorker.getCurrentRoom().getPathsToOtherValves().stream()
                    .filter(path -> canWorkerMove(nextWorker, path))
                    .map(path -> new Solution(this, nextWorker, path))
                    .collect(Collectors.toList());
        }
        return result;
    }

    private boolean canWorkerMove(Worker worker, Path pathToValve) {
        return worker.haveEnoughTime(pathToValve.getCost()) && !roomsWithOpenValves.contains(pathToValve.getTo());
    }

    public int getValue() {
        return value;
    }

    public Set<Room> getRoomsWithOpenValves() {
        return roomsWithOpenValves;
    }

    public boolean haveWorkersInSameRooms(Solution other) {
        return getWorkersRooms().equals(other.getWorkersRooms());
    }

    private Set<Room> getWorkersRooms() {
        return workers.stream()
                .map(Worker::getCurrentRoom)
                .collect(Collectors.toSet());
    }

    public boolean isBetter(Solution other) {
        return value >= other.getValue() && workersHaveBetterTime(other);
    }

    private boolean workersHaveBetterTime(Solution other) {
        Set<Room> roomsWithWorkers = getWorkersRooms();
        return roomsWithWorkers.stream()
                .allMatch(room -> retrieveTimeLeftForWorkerInRoom(room) >= other.retrieveTimeLeftForWorkerInRoom(room));
    }

    private int retrieveTimeLeftForWorkerInRoom(Room room) {
        return workers.stream()
                .filter(worker -> worker.getCurrentRoom().equals(room))
                .map(Worker::getTimeLeft)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    @Override
    public int compareTo(Solution other) {
        return value - other.value;
    }
}
