package AoC2022.Day9;

import AoC2022.AdventTask;

import java.util.List;

public class Task9A extends AdventTask {
    int sizeY;
    int sizeX;
    int[][] table;


    public Task9A() {
        super("Day9", "Task9A");
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

        int counter = 0;
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
                    counter += currentValue + 1;
                }
            }
        }

        return List.of(counter + "");
    }

    private boolean checkIfPointIHigher(int x, int y, int value) {
        return checkIfBorder(x, y) || table[x][y] > value;
    }

    private boolean checkIfBorder(int x, int y) {
        return x == -1 || x == sizeX || y == -1 || y == sizeY;
    }
}
