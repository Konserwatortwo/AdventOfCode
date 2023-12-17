package AoC2023.Day17;

import AoC2023.shared.Direction;
import AoC2023.shared.Position;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class City {

    int[][] blocksGrid;
    int maxX;
    int maxY;

    private City(List<String> inputValue) {
        assert inputValue.size() > 1;
        this.maxX = inputValue.get(0).length();
        this.maxY = inputValue.size();
        this.blocksGrid = new int[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            char[] array = inputValue.get(y).toCharArray();
            for (int x = 0; x < maxX; x++) {
                blocksGrid[y][x] = Integer.parseInt(array[x] + "");
            }
        }
    }

    public static City of(List<String> inputValue) {
        return new City(inputValue);
    }

    public int findBestSolution(int maxLength, int minLength) {
        int bestSolution = Integer.MAX_VALUE;
        List<Solution> currentSolutions = new ArrayList<>();
        currentSolutions.add(Solution.of(Direction.SOUTH, Position.of(0, 0), maxLength, minLength));
        currentSolutions.add(Solution.of(Direction.EAST, Position.of(0, 0), maxLength, minLength));
        Map<String, Solution> checkedSolutions = new HashMap<>();
        while (!currentSolutions.isEmpty()) {
            currentSolutions = generateNextIterationSolutions(currentSolutions);
            currentSolutions.forEach(solution -> solution.heatLoss(valueAt(solution.getCurrentPosition())));
            bestSolution = checkFinishedSolutions(currentSolutions, bestSolution);
            currentSolutions = filterSolutions(currentSolutions, checkedSolutions, bestSolution);
        }
        return bestSolution;
    }

    private int valueAt(Position position) {
        return blocksGrid[position.getY()][position.getX()];
    }

    private List<Solution> generateNextIterationSolutions(List<Solution> previousSolutions) {
        return previousSolutions.stream()
                .map(Solution::generateNextSolutions)
                .flatMap(Collection::stream)
                .filter(solution -> isInGrid(solution.getCurrentPosition()))
                .collect(Collectors.toList());
    }

    private boolean isInGrid(Position position) {
        return position.getX() >= 0 && position.getX() < maxX && position.getY() >= 0 && position.getY() < maxY;
    }

    private int checkFinishedSolutions(List<Solution> currentSolutions, int previousBestSolution) {
        List<Solution> finishedSolutions = currentSolutions.stream()
                .filter(this::isSolutionInFinalPosition)
                .collect(Collectors.toList());
        return Math.min(previousBestSolution, finishedSolutions.stream()
                .filter(Solution::canTurn)
                .mapToInt(Solution::getCurrentHeatLoss)
                .min()
                .orElse(Integer.MAX_VALUE));
    }

    private boolean isSolutionInFinalPosition(Solution solution) {
        return solution.getCurrentPosition().getX() == maxX - 1 && solution.getCurrentPosition().getY() == maxY - 1;
    }

    private List<Solution> filterSolutions(
            List<Solution> currentSolutions,
            Map<String, Solution> checkedSolutions,
            int bestSolution
    ) {
        List<Solution> filteredSolutions = new ArrayList<>();
        for (Solution currentSolution : currentSolutions) {
            String key = currentSolution.getKey();
            if (!checkedSolutions.containsKey(key) || currentSolution.canBeBetter(checkedSolutions.get(key))) {
                checkedSolutions.put(key, currentSolution);
                if (currentSolution.getCurrentHeatLoss() < bestSolution) {
                    filteredSolutions.add(currentSolution);
                }
            }
        }
        return filteredSolutions;
    }
}
