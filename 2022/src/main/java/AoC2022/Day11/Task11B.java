package AoC2022.Day11;

import AoC2022.AdventTask;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class Task11B extends AdventTask {

    private static final int SIZE_X = 10;
    private static final int SIZE_Y = 10;
    private static final int STEPS_NUMBER = 100;

    private final int[][] platform;

    public Task11B() {
        super("Day11", "Task11B");
        platform = new int[SIZE_X][SIZE_Y];
    }

    @Override
    public List<String> perform(List<String> input) {
        performOnEachPoint((x, y) -> platform[x][y] = Integer.parseInt(input.get(x).charAt(y) + ""));

        int numberOfFlashesInStep = 0;
        int stepNumber = 0;
        while (numberOfFlashesInStep != SIZE_X * SIZE_Y) {
            numberOfFlashesInStep = performStep(platform);
            stepNumber++;
        }

        return List.of(stepNumber + "");
    }

    private void performOnEachPoint(BiConsumer<Integer, Integer> consumer) {
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                consumer.accept(x, y);
            }
        }
    }

    private int performStep(int[][] platform) {
        performOnEachPoint((x, y) -> platform[x][y]++);
        performOnEachPoint(this::checkFlash);
        AtomicInteger counter = new AtomicInteger();
        performOnEachPoint((x, y) -> counter.addAndGet(countFlashes(x, y)));
        return counter.get();
    }

    private void checkFlash(int x, int y) {
        if (platform[x][y] < 10) {
            return;
        }
        platform[x][y] = Integer.MIN_VALUE;

        for (int pointX = -1; pointX <= 1; pointX++) {
            for (int pointY = -1; pointY <= 1; pointY++) {
                int nearbyX = x + pointX;
                int nearbyY = y + pointY;
                if (!checkIfBorder(nearbyX, nearbyY)) {
                    platform[nearbyX][nearbyY]++;
                    checkFlash(nearbyX, nearbyY);
                }
            }
        }
    }

    private int countFlashes(int x, int y) {
        if (platform[x][y] < 0) {
            platform[x][y] = 0;
            return 1;
        }
        return 0;
    }

    private boolean checkIfBorder(int x, int y) {
        return x < 0 || x > SIZE_X - 1 || y < 0 || y > SIZE_Y - 1;
    }
}
