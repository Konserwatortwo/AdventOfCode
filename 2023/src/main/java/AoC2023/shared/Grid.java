package AoC2023.shared;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
@EqualsAndHashCode
public class Grid {

    char[][] grid;
    int maxX;
    int maxY;

    protected Grid(char[][] grid) {
        this.grid = grid;
        this.maxX = grid[0].length;
        this.maxY = grid.length;
    }

    protected Grid(List<String> inputValue) {
        assert inputValue.size() > 1;
        this.maxX = inputValue.get(0).length();
        this.maxY = inputValue.size();
        this.grid = new char[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            System.arraycopy(inputValue.get(y).toCharArray(), 0, grid[y], 0, maxX);
        }
    }

    public static Grid of(List<String> inputValue) {
        return new Grid(inputValue);
    }

    public Grid copy() {
        char[][] copyGrid = new char[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            System.arraycopy(grid[y], 0, copyGrid[y], 0, maxX);
        }
        return new Grid(copyGrid, maxX, maxY);
    }

    public char valueAt(int x, int y) {
        return grid[y][x];
    }

    public void setValueAt(int x, int y, char value) {
        grid[y][x] = value;
    }

    public boolean isInGrid(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    public void iterateOverGrid(BiConsumer<Integer, Integer> perform) {
        iterateOverGrid((x, y) -> true, perform);
    }

    public void iterateOverGrid(
            BiPredicate<Integer, Integer> condition,
            BiConsumer<Integer, Integer> perform
    ) {
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (condition.test(x, y)) {
                    perform.accept(x, y);
                }
            }
        }
    }

    public void reverseIterateOverGrid(BiConsumer<Integer, Integer> perform) {
        iterateOverGrid((x, y) -> true, perform);
    }

    public void reverseIterateOverGrid(
            BiPredicate<Integer, Integer> condition,
            BiConsumer<Integer, Integer> perform
    ) {
        for (int y = maxY - 1; y >= 0; y--) {
            for (int x = maxX - 1; x >= 0; x--) {
                if (condition.test(x, y)) {
                    perform.accept(x, y);
                }
            }
        }
    }

    public long sumGrid(BiFunction<Integer, Integer, Long> calculateValue) {
        return sumGrid((x, y) -> true, calculateValue);
    }

    public long sumGrid(BiPredicate<Integer, Integer> condition) {
        return sumGrid(condition, (x, y) -> 1L);
    }

    public long sumGrid(
            BiPredicate<Integer, Integer> condition,
            BiFunction<Integer, Integer, Long> calculateValue
    ) {
        long sum = 0;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (condition.test(x, y)) {
                    sum += calculateValue.apply(x, y);
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                builder.append(valueAt(x, y));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
