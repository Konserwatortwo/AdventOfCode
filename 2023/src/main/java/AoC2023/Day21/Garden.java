package AoC2023.Day21;

import AoC2023.shared.Grid;
import AoC2023.shared.Position;
import io.vavr.Tuple;
import io.vavr.Tuple3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Garden extends Grid {

    private Garden(List<String> inputValue) {
        super(inputValue);
    }

    public static Garden of(List<String> inputValue) {
        return new Garden(inputValue);
    }

    public long findPlacesAfter64Steps() {
        Set<Position> reachedPositions = new HashSet<>();
        reachedPositions.add(findStartingPosition());
        for (int i = 0; i < 64; i++) {
            reachedPositions = reachedPositions.stream()
                    .map(Position::nearbyPositions)
                    .flatMap(Collection::stream)
                    .filter(this::isInGrid)
                    .filter(this::isPositionAvailable)
                    .collect(Collectors.toSet());
        }
        return reachedPositions.size();
    }

    private Position findStartingPosition() {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if ('S' == valueAt(x, y)) {
                    return Position.of(x, y);
                }
            }
        }
        throw new IllegalStateException("Starting Position not found");
    }

    private boolean isPositionAvailable(Position position) {
        return valueAt(getGridPosition(position)) != '#';
    }

    private Position getGridPosition(Position position) {
        int gridX = position.getX() % maxX;
        int gridY = position.getY() % maxY;
        gridX += gridX < 0 ? maxX : 0;
        gridY += gridY < 0 ? maxY : 0;
        return Position.of(gridX, gridY);
    }

    public long findPlacesInInfiniteGarden(int numberOfSteps) {
        Tuple3<List<Integer>, Integer, Integer> startingIterations = findLoop(numberOfSteps);
        List<Integer> stepsBigness = startingIterations._1;
        int step = startingIterations._2;
        int cycleLength = startingIterations._3;
        long result = numberOfSteps % 2 == 0 ? retrieveOddValues(stepsBigness) : retrieveEvenValues(stepsBigness);
        return step == numberOfSteps ? result :
                calculateResult(
                        numberOfSteps,
                        step,
                        cycleLength,
                        result,
                        stepsBigness
                );
    }

    private Tuple3<List<Integer>, Integer, Integer> findLoop(int numberOfSteps) {
        Set<Position> reachedPositions = new HashSet<>();
        Set<Position> newPositions = findStartingPosition().nearbyPositions()
                .stream()
                .filter(this::isPositionAvailable)
                .filter(reachedPositions::add)
                .collect(Collectors.toSet());
        List<Integer> stepsBigness = new ArrayList<>();
        stepsBigness.add(newPositions.size());

        List<String> cycleFinder = new ArrayList<>();
        int cycleLength = 0;
        int cycleIndex = 0;
        String currentVertex = "";

        int step = 0;
        while (++step < numberOfSteps && !(cycleLength > 1 && cycleFinder.get(cycleIndex).equals(currentVertex))) {
            newPositions = newPositions.stream()
                    .map(Position::nearbyPositions)
                    .flatMap(Collection::stream)
                    .filter(this::isPositionAvailable)
                    .filter(reachedPositions::add)
                    .collect(Collectors.toSet());
            stepsBigness.add(newPositions.size());
            currentVertex = getCurrentVertex(newPositions);
            int indexOfElement = cycleFinder.lastIndexOf(currentVertex);
            if (indexOfElement == -1) {
                cycleIndex = 0;
                cycleLength = 0;
            } else {
                if (cycleIndex != 0) {
                    if (indexOfElement == cycleIndex + cycleLength) {
                        cycleLength++;
                    } else {
                        cycleIndex = 0;
                        cycleLength = 0;
                    }
                } else {
                    cycleIndex = indexOfElement;
                    cycleLength = 1;
                }
            }
            cycleFinder.add(currentVertex);
        }
        return Tuple.of(stepsBigness, step, cycleLength - 1);
    }

    private String getCurrentVertex(Set<Position> newPositions) {
        StringBuilder builder = new StringBuilder();
        Position north = newPositions.stream().min(Comparator.comparing(Position::getY)).orElseThrow();
        builder.append("north").append(getGridPosition(north)).append("-");
        Position south = newPositions.stream().max(Comparator.comparing(Position::getY)).orElseThrow();
        builder.append("south").append(getGridPosition(south)).append("-");
        Position west = newPositions.stream().min(Comparator.comparing(Position::getX)).orElseThrow();
        builder.append("west").append(getGridPosition(west)).append("-");
        Position east = newPositions.stream().max(Comparator.comparing(Position::getX)).orElseThrow();
        builder.append("east").append(getGridPosition(east));
        return builder.toString();
    }

    private long calculateResult(
            int numberOfSteps,
            int step,
            int cycleLength,
            long previousResult,
            List<Integer> stepsBigness
    ) {
        List<Integer> positionsBigness = IntStream.range(stepsBigness.size() - cycleLength, stepsBigness.size())
                .map(stepsBigness::get)
                .boxed()
                .toList();
        List<Integer> positionsChange = IntStream.range(stepsBigness.size() - cycleLength, stepsBigness.size())
                .map(i -> stepsBigness.get(i) - stepsBigness.get(i - cycleLength))
                .boxed()
                .toList();

        long restSteps = numberOfSteps - step;
        long cyclesInRest = restSteps / cycleLength;
        long evenCycles = cyclesInRest / 2;

        boolean isCyclesInRestEven = cyclesInRest % 2 == 0;
        boolean isStepEven = step % 2 == 0;
        boolean isNumberOfStepsEven = numberOfSteps % 2 == 0;

        long result = previousResult;
        result += evenCycles * retrieveAllValues(positionsBigness);
        long factorial = LongStream.range(0, evenCycles).sum() * 2 + evenCycles;
        result += factorial * retrieveAllValues(positionsChange);

        long evenChange = retrieveEvenValues(positionsChange);
        long oddChange = retrieveOddValues(positionsChange);
        if (isNumberOfStepsEven == isStepEven) {
            result += evenCycles * evenChange;
            if (!isCyclesInRestEven) {
                result += retrieveOddValues(positionsBigness) + cyclesInRest * oddChange;
            }
        } else {
            result += evenCycles * oddChange;
            if (!isCyclesInRestEven) {
                result += retrieveEvenValues(positionsBigness) + cyclesInRest * evenChange;
            }
        }

        long restAfterCycles = restSteps % cycleLength;
        if (isCyclesInRestEven == isStepEven == isNumberOfStepsEven) {
            result += IntStream.range(0, (int) restAfterCycles)
                    .filter(x -> x % 2 == 1)
                    .mapToLong(x -> positionsBigness.get(x) + (cyclesInRest + 1) * positionsChange.get(x))
                    .sum();
        } else {
            result += IntStream.range(0, (int) restAfterCycles)
                    .filter(x -> x % 2 == 0)
                    .mapToLong(x -> positionsBigness.get(x) + (cyclesInRest + 1) * positionsChange.get(x))
                    .sum();
        }
        return result;
    }

    private long retrieveAllValues(List<Integer> list) {
        return list.stream().mapToLong(x -> x).sum();
    }

    private long retrieveEvenValues(List<Integer> list) {
        return retrieveValuesFromList(list, i -> i % 2 == 0);
    }

    private long retrieveOddValues(List<Integer> list) {
        return retrieveValuesFromList(list, i -> i % 2 == 1);
    }

    private long retrieveValuesFromList(List<Integer> list, Predicate<Integer> indexPredicate) {
        return IntStream.range(0, list.size())
                .filter(indexPredicate::test)
                .mapToLong(list::get)
                .sum();
    }
}
