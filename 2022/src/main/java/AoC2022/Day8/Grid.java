package AoC2022.Day8;

import java.util.List;
import java.util.function.Function;

public class Grid {

    private final int sizeX;

    private final int sizeY;

    private final Tree[][] treeGrid;

    public Grid(List<String> lines) {
        this.sizeX = lines.get(0).length();
        this.sizeY = lines.size();
        this.treeGrid = new Tree[sizeX][sizeY];
        populateGrid(lines);
    }

    private void populateGrid(List<String> input) {
        for (int y = 0; y < input.size(); y++) {
            char[] charArray = input.get(y).toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                treeGrid[x][y] = new Tree(Integer.parseInt(charArray[x] + ""));
            }
        }
    }

    public void checkVisibleTrees() {
        markEdgesAsVisible();

        for (int y = 1; y < sizeY - 1; y++) {
            calculateVisibilityForRow(y);
        }
        for (int x = 1; x < sizeX - 1; x++) {
            calculateVisibilityForColumn(x);
        }
    }

    private void markEdgesAsVisible() {
        for (int x = 0; x < sizeX; x++) {
            treeGrid[x][0].setAsVisible();
            treeGrid[x][sizeY - 1].setAsVisible();
        }
        for (int y = 0; y < sizeY; y++) {
            treeGrid[0][y].setAsVisible();
            treeGrid[sizeX - 1][y].setAsVisible();
        }
    }

    private void calculateVisibilityForRow(int columnNumber) {
        calculateVisibilityForLine(0, sizeX - 1, x -> treeGrid[x][columnNumber]);
        calculateVisibilityForLine(sizeX - 1, 0, x -> treeGrid[x][columnNumber]);
    }

    private void calculateVisibilityForColumn(int rowNumber) {
        calculateVisibilityForLine(0, sizeY - 1, y -> treeGrid[rowNumber][y]);
        calculateVisibilityForLine(sizeY - 1, 0, y -> treeGrid[rowNumber][y]);
    }

    private void calculateVisibilityForLine(int start, int end, Function<Integer, Tree> function) {
        int highest = -1;
        int iterator = start;
        int change = end > start ? 1 : -1;

        while (iterator != end) {
            Tree tree = function.apply(iterator);
            if (highest < tree.getValue()) {
                highest = tree.getValue();
                tree.setAsVisible();
            }
            iterator += change;
        }
    }

    public int countVisibleTrees() {
        int visibleTrees = 0;
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                visibleTrees += treeGrid[x][y].isVisible() ? 1 : 0;
            }
        }
        return visibleTrees;
    }

    public int highestScenicScore() {
        int highest = 0;
        for (int x = 1; x < sizeX - 1; x++) {
            for (int y = 1; y < sizeY - 1; y++) {
                int score = calculateScenicScoreForTree(x, y);
                highest = Math.max(score, highest);
            }
        }
        return highest;
    }

    private int calculateScenicScoreForTree(int x, int y) {
        int score = 1;
        score *= calculateVisibleTreesInDirection(x, y, a -> a + 1, b -> b);
        score *= calculateVisibleTreesInDirection(x, y, a -> a - 1, b -> b);
        score *= calculateVisibleTreesInDirection(x, y, a -> a, b -> b + 1);
        score *= calculateVisibleTreesInDirection(x, y, a -> a, b -> b - 1);
        return score;
    }

    private int calculateVisibleTreesInDirection(int x, int y, Function<Integer, Integer> changeX, Function<Integer, Integer> changeY) {
        int visibleTrees = 0;
        int limit = treeGrid[x][y].getValue();
        int currentValue = -1;
        int currentX = changeX.apply(x);
        int currentY = changeY.apply(y);

        while (isInBound(currentX, sizeX) && isInBound(currentY, sizeY) && currentValue < limit) {
            visibleTrees++;
            currentValue = treeGrid[currentX][currentY].getValue();
            currentX = changeX.apply(currentX);
            currentY = changeY.apply(currentY);
        }
        return visibleTrees;
    }

    private boolean isInBound(int value, int size) {
        return value >= 0 && value < size;
    }

}
