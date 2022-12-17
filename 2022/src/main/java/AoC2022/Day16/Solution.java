package AoC2022.Day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution implements Comparable<Solution> {

    private int value;
    private List<Room> roomsWithOpenValves;
    private Queue<Worker> workers;

    private List<String> journal;

    public Solution(List<Worker> workers) {
        this.value = 0;
        this.roomsWithOpenValves = new ArrayList<>();
        this.workers = new LinkedList<>(workers);
        this.journal = new ArrayList<>();
    }

    public Solution(Solution copyFromSolution, Worker currentWorker, Path pathToValve) {
        Room newRoom = pathToValve.getTo();
        Worker newWorker = new Worker(currentWorker);

        newWorker.takeTime(pathToValve.getCost() + 1);
        newWorker.moveToRoom(newRoom);

        this.value = copyFromSolution.value + (newWorker.getTimeLeft() * newRoom.getFlowRate());

        this.roomsWithOpenValves = new ArrayList<>(copyFromSolution.roomsWithOpenValves);
        this.roomsWithOpenValves.add(newRoom);

        this.workers = new LinkedList<>(copyFromSolution.workers);
        this.workers.add(newWorker);

        this.journal = new ArrayList<>(copyFromSolution.journal);
       this.journal.add(newWorker.getName() + " wchodzi do " + newRoom + " -> " + newWorker);

    }

    public List<Solution> generateSolutionFromPaths() {
        List<Solution> result = new ArrayList<>();
        while (result.isEmpty() && !workers.isEmpty()) {
            Worker nextWorker = workers.remove();
            result =  nextWorker.getCurrentRoom().getPathsToOtherValves().stream()
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

    @Override
    public int compareTo(Solution other) {
        return value - other.value;
    }
}
