package AoC2022.Day9;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task9B extends AdventTask {
    int sizeY;
    int sizeX;
    int[][] table;


    public Task9B() {
        super("Day9", "Task9B");
    }

    @Override
    public List<String> perform(List<String> input) {
        sizeY = input.size();
        sizeX = input.get(0).length();
        table = new int[sizeX][sizeY];


        for (int y = 0; y < sizeY; y++) {
            char[] line = input.get(y).toCharArray();
            for (int x = 0; x < sizeX; x++) {
                table[x][y] = Integer.parseInt(line[x] + "");
            }
        }

        List<Integer> basinSizes = new ArrayList<>();
        boolean isLowest;
        int currentValue;

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                currentValue = table[x][y];
                isLowest = checkIfPointIHigher(x - 1, y, currentValue);
                isLowest &= checkIfPointIHigher(x + 1, y, currentValue);
                isLowest &= checkIfPointIHigher(x, y - 1, currentValue);
                isLowest &= checkIfPointIHigher(x, y + 1, currentValue);

                if (isLowest) {
                    basinSizes.add(discoverNearbyFields(x, y, new ArrayList<>()));
                }
            }
        }
        Collections.sort(basinSizes);
        Collections.reverse(basinSizes);

        return List.of(basinSizes.get(0)*basinSizes.get(1)*basinSizes.get(2) + "");
    }

    private boolean checkIfPointIHigher(int x, int y, int value) {
        return checkIfBorder(x, y) || table[x][y] > value;
    }

    private boolean checkIfBorder(int x, int y) {
        return x == -1 || x == sizeX || y == -1 || y == sizeY;
    }


    private int discoverNearbyFields(int x, int y, List<String> tabuList) {
        String tabuPoint = x + ":" + y;
        if (checkIfBorder(x, y) || table[x][y] == 9 || tabuList.contains(tabuPoint)) {
            return 0;
        }
        int basinSize = 1;
        tabuList.add(tabuPoint);
        basinSize += discoverNearbyFields(x - 1, y, tabuList);
        basinSize += discoverNearbyFields(x + 1, y, tabuList);
        basinSize += discoverNearbyFields(x, y - 1, tabuList);
        basinSize += discoverNearbyFields(x, y + 1, tabuList);
        return basinSize;
    }
}
