package AoC2023.Day21;

import AoC2023.shared.Grid;
import AoC2023.shared.Position;

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
        int gridX = position.getX() % maxX;
        int gridY = position.getY() % maxY;
        gridX += gridX < 0 ? maxX : 0;
        gridY += gridY < 0 ? maxY : 0;
        return valueAt(gridX, gridY) != '#';
    }

    public long findPlacesInInfiniteGarden(int numberOfSteps) {
        Set<Position> reachedPositions = new HashSet<>();
        Set<Position> newPositions = new HashSet<>();
        newPositions.add(findStartingPosition());

        int cycleLength = maxX;
        int[][] positionSize = new int[3][cycleLength];
        Arrays.fill(positionSize[2], 1);
        List<Integer> stepsBigness = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<String> cycleFinder = new ArrayList<>();
        List<String> cycleFinder2 = new ArrayList<>();
        boolean cycleFinded = false;
        int eta = 0;

        int step = -1;
//        while (step++ < numberOfSteps && !Arrays.stream(positionSize[2]).allMatch(i -> i == 0)) {
        int stepsToFindSolution = 68;
        while (step++ < stepsToFindSolution) {
//        while (step++ < numberOfSteps && !cycleFinded) {
            newPositions = newPositions.stream()
                    .map(Position::nearbyPositions)
                    .flatMap(Collection::stream)
                    .filter(this::isPositionAvailable)
                    .filter(reachedPositions::add)
                    .collect(Collectors.toSet());
            int currentSize = newPositions.size();
            stepsBigness.add(currentSize);

            String currentVertex = getCurrentVertex(newPositions);
            if (cycleFinder.contains(currentVertex)) {
                if (cycleFinder2.contains(currentVertex) && !cycleFinded) {
                    eta = step;
                    cycleFinded = true;
                    int cycleLength2 = cycleFinder2.size();
                    List<Integer> indexes = IntStream.range(stepsBigness.size() - cycleLength2, stepsBigness.size())
                            .boxed()
                            .collect(Collectors.toList());
                    first = indexes.stream().map(stepsBigness::get).collect(Collectors.toList());
                    second = indexes.stream().map(i -> stepsBigness.get(i) - stepsBigness.get(i - cycleLength2)).collect(Collectors.toList());
                } else {
                    cycleFinder2.add(currentVertex);
                }
            } else {
                cycleFinder2.clear();
            }
            cycleFinder.add(getCurrentVertex(newPositions));

            int index = step % cycleLength;
            int difference = currentSize - positionSize[0][index];
            positionSize[2][index] = difference - positionSize[1][index];
            positionSize[1][index] = difference;
            positionSize[0][index] = currentSize;
        }

        boolean isNumberOfStepsEven = numberOfSteps % 2 == 0;
        long result = isNumberOfStepsEven ? retrieveOddValues(stepsBigness) : retrieveEvenValues(stepsBigness);
//        long result = isNumberOfStepsEven ? retrieveEvenValues(stepsBigness) : retrieveOddValues(stepsBigness);
        if (step == numberOfSteps) {
            return result;
        }


        List<Integer> positionsBigness = new ArrayList<>();
        List<Integer> positionsChange = new ArrayList<>();
        for (int i = 0; i < cycleLength; i++) {
            int index = (i + step) % cycleLength;
            positionsBigness.add(positionSize[0][index]);
            positionsChange.add(positionSize[1][index]);
        }

        Integer beta = second.remove(0);
        second.add(beta);
        Integer alfa = first.remove(0);
        first.add(alfa + beta);
        eta++;

//        Integer gamma = positionsBigness.remove(0);
//        positionsBigness.add(gamma);
//        Integer delta = positionsChange.remove(0);
//        positionsChange.add(delta + gamma);
//        step++;

        System.out.println(Arrays.toString(positionSize[0]));
        System.out.println(Arrays.toString(positionSize[1]));
        System.out.println(positionsBigness);
        System.out.println(positionsChange);
        System.out.println(first);
        System.out.println(second);
        System.out.println(step);
        System.out.println(eta);


        return calculateResult(
                result,
                cycleLength,
                numberOfSteps - step,
                positionsBigness,
                positionsChange,
                isNumberOfStepsEven
        );
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

    private Position getGridPosition(Position position) {
        int gridX = position.getX() % maxX;
        int gridY = position.getY() % maxY;
        gridX += gridX < 0 ? maxX : 0;
        gridY += gridY < 0 ? maxY : 0;
        return Position.of(gridX, gridY);
    }

    private long calculateResult(
            long previousResult,
            int cycleLength,
            int restSteps,
            List<Integer> positionsBigness,
            List<Integer> positionsChange,
            boolean isNumberOfStepsEven
    ) {
        long alfa = restSteps % cycleLength;
        long beta = restSteps / cycleLength;
        boolean isBetaEven = beta % 2 == 0;
        System.out.println(restSteps + " = " + beta + " - " + alfa);
        long gamma = retrieveEvenValues(positionsBigness);
        long delta = retrieveOddValues(positionsBigness);
        long epsilon = retrieveEvenValues(positionsChange);
        long zeta = retrieveOddValues(positionsChange);
        long lambda = beta / 2;
        long theta = (LongStream.range(0, beta).sum() + lambda) / 2;

        long result = previousResult;
        System.out.println(result);
        long k2 = lambda * (gamma + delta) + theta * (epsilon + zeta);
        System.out.println(k2);
        result += k2;
        System.out.println(result);
        if (isNumberOfStepsEven) {
            result += isBetaEven ? lambda * zeta : gamma + (lambda + 1) * epsilon;
        } else {
            result += isBetaEven ? lambda * epsilon : delta + (lambda + 1) * zeta;
        }
        System.out.println(result);
        result += IntStream.range(0, (int) alfa)
                .filter(x -> x % 2 == (isBetaEven == isNumberOfStepsEven ? 0 : 1))
                .mapToLong(x -> positionsBigness.get(x) + (beta + 1) * positionsChange.get(x))
                .sum();
        System.out.println(result);
        return result;
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
