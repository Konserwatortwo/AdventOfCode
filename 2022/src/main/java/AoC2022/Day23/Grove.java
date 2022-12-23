package AoC2022.Day23;

import java.util.*;
import java.util.stream.Collectors;

public class Grove {
    private final Queue<Direction> directionQueue;
    private final List<Elf> elfs;
    private boolean isIdle;

    public Grove(List<String> input) {
        this.directionQueue = new LinkedList<>();
        populateDirectionQueue();
        this.elfs = new ArrayList<>();
        createElfsInGrove(input);
        isIdle = false;
    }

    private void populateDirectionQueue() {
        this.directionQueue.add(Direction.NORTH);
        this.directionQueue.add(Direction.SOUTH);
        this.directionQueue.add(Direction.WEST);
        this.directionQueue.add(Direction.EAST);
    }

    private void createElfsInGrove(List<String> input) {
        int coordinateY = 0;
        for (String line : input) {
            char[] charArray = line.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                if (charArray[x] == '#') {
                    elfs.add(new Elf(Position.of(x, coordinateY)));
                }
            }
            coordinateY++;
        }
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void performRound() {
        List<Position> currentElfsPositions = elfs.stream()
                .map(Elf::getCurrentPosition)
                .collect(Collectors.toList());
        List<Elf> elfsWitchCanMove = elfs.stream()
                .filter(elf -> elf.shouldMoveInThisRound(currentElfsPositions))
                .filter(elf -> elf.considerNextPosition(currentElfsPositions, new LinkedList<>(directionQueue)))
                .collect(Collectors.toList());
        Map<Position, List<Elf>> positionToElfMap = elfsWitchCanMove.stream()
                .collect(Collectors.groupingBy(Elf::getConsideredPosition));
        List<Elf> elfsToMove = positionToElfMap.values().stream()
                .filter(list -> list.size() == 1)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        elfsToMove.forEach(Elf::moveToConsideredPosition);

        if (elfsToMove.size() == 0) {
            isIdle = true;
        } else {
            Direction firstDirection = directionQueue.remove();
            directionQueue.add(firstDirection);
        }
    }

    public int retrieveEmptyGroundBetweenElf() {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        List<Position> currentElfsPositions = elfs.stream()
                .map(Elf::getCurrentPosition)
                .collect(Collectors.toList());

        for (Position currentElfsPosition : currentElfsPositions) {
            minX = Math.min(minX, currentElfsPosition.getX());
            maxX = Math.max(maxX, currentElfsPosition.getX());
            minY = Math.min(minY, currentElfsPosition.getY());
            maxY = Math.max(maxY, currentElfsPosition.getY());
        }

        int rectangleSize = (maxX - minX + 1) * (maxY - minY + 1);
        return rectangleSize - currentElfsPositions.size();
    }
}
