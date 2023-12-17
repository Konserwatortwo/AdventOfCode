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
        Map<Integer, List<Solution>> groupForResult = new HashMap<>();
        groupForResult.put(0, new ArrayList<>());
        groupForResult.get(0).add(Solution.of(Direction.SOUTH, Position.of(0, 0), maxLength, minLength));
        groupForResult.get(0).add(Solution.of(Direction.EAST, Position.of(0, 0), maxLength, minLength));
        Set<Solution> checkedSolutions = new HashSet<>();
        int currentGroup = -1;
        int bestSolution = Integer.MAX_VALUE;
        while (bestSolution == Integer.MAX_VALUE) {
            currentGroup++;
            if (groupForResult.containsKey(currentGroup)) {
                Set<Solution> currentSolutions = groupForResult.get(currentGroup).stream()
                        .map(Solution::generateNextSolutions)
                        .flatMap(Collection::stream)
                        .filter(solution -> isInGrid(solution.getCurrentPosition()))
                        .filter(solution -> !checkedSolutions.contains(solution))
                        .collect(Collectors.toSet());
                checkedSolutions.addAll(currentSolutions);
                for (Solution currentSolution : currentSolutions) {
                    int value = currentGroup + valueAt(currentSolution.getCurrentPosition());
                    if (isFinishedSolution(currentSolution)) {
                        bestSolution = value;
                    } else {
                        groupForResult.computeIfAbsent(value, x -> new ArrayList<>()).add(currentSolution);
                    }
                }
                groupForResult.remove(currentGroup);
            }
        }
        return bestSolution;
    }

    private int valueAt(Position position) {
        return blocksGrid[position.getY()][position.getX()];
    }

    private boolean isInGrid(Position position) {
        return position.getX() >= 0 && position.getX() < maxX && position.getY() >= 0 && position.getY() < maxY;
    }

    private boolean isFinishedSolution(Solution solution) {
        return solution.getCurrentPosition().getX() == maxX - 1
                && solution.getCurrentPosition().getY() == maxY - 1
                && solution.canTurn();
    }
}
