package AoC2022.Day24;

import AoC2022.common.Direction;
import AoC2022.common.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Basin {
    private final int maxX;
    private final int maxY;
    private final List<Blizzard> blizzardsInBasin;
    private final List<Voyager> voyagersInBasin;
    private int iterationNumber;
    private Position startingPosition;
    private Position goalPosition;
    private boolean isGoalFulfilled;

    public Basin(List<String> input) {
        this.maxX = input.get(0).length() - 2;
        this.maxY = input.size() - 2;
        this.voyagersInBasin = new ArrayList<>();
        this.iterationNumber = 0;

        this.blizzardsInBasin = new ArrayList<>();
        for (int y = 1; y < input.size() - 1; y++) {
            char[] charArray = input.get(y).toCharArray();
            for (int x = 1; x < charArray.length - 1; x++) {
                Position position = Position.of(x - 1, y - 1);
                switch (charArray[x]) {
                    case '>' -> blizzardsInBasin.add(new Blizzard(Direction.EAST, position));
                    case '<' -> blizzardsInBasin.add(new Blizzard(Direction.WEST, position));
                    case '^' -> blizzardsInBasin.add(new Blizzard(Direction.NORTH, position));
                    case 'v' -> blizzardsInBasin.add(new Blizzard(Direction.SOUTH, position));
                }
            }
        }
    }

    public int getIterationNumber() {
        return iterationNumber;
    }

    public void runToEnd() {
        setUpRun(Position.of(0, -1), Position.of(maxX - 1, maxY));
        while (!isGoalFulfilled) {
            runIteration();
        }
    }

    public void runToStart() {
        setUpRun(Position.of(maxX - 1, maxY), Position.of(0, -1));
        while (!isGoalFulfilled) {
            runIteration();
        }
    }

    private void setUpRun(Position startingPosition, Position goalPosition) {
        this.voyagersInBasin.clear();
        this.isGoalFulfilled = false;
        this.startingPosition = startingPosition;
        this.goalPosition = goalPosition;
    }

    private void runIteration() {
        iterationNumber++;
        blizzardsInBasin.forEach(this::moveBlizzard);
        if (voyagersInBasin.isEmpty()) {
            voyagersInBasin.add(new Voyager(startingPosition));
        }
        moveVoyagers();
    }

    private void moveBlizzard(Blizzard blizzard) {
        Position nextPosition = blizzard.getNextPosition();
        if (nextPosition.getX() < 0) {
            nextPosition = Position.of(maxX - 1, nextPosition.getY());
        }
        if (nextPosition.getX() >= maxX) {
            nextPosition = Position.of(0, nextPosition.getY());
        }
        if (nextPosition.getY() < 0) {
            nextPosition = Position.of(nextPosition.getX(), maxY - 1);
        }
        if (nextPosition.getY() >= maxY) {
            nextPosition = Position.of(nextPosition.getX(), 0);
        }
        blizzard.setPosition(nextPosition);
    }

    private void moveVoyagers() {
        Set<Position> positionsWithBlizzards = blizzardsInBasin.stream()
                .map(Blizzard::getPosition)
                .collect(Collectors.toSet());
        Set<Position> nextPositionOfVoyagers = voyagersInBasin.stream()
                .map(Voyager::retrieveNextPossiblePositions)
                .flatMap(List::stream)
                .filter(position -> !positionsWithBlizzards.contains(position))
                .collect(Collectors.toSet());
        isGoalFulfilled = nextPositionOfVoyagers.stream().anyMatch(position -> goalPosition.equals(position));
        voyagersInBasin.clear();
        nextPositionOfVoyagers.stream()
                .filter(this::positionInBorders)
                .map(Voyager::new)
                .forEach(voyagersInBasin::add);
    }

    private boolean positionInBorders(Position position) {
        return position.getX() >= 0 && position.getX() < maxX && position.getY() >= 0 && position.getY() < maxY;
    }
}
