package AoC2023.Day13;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Pattern {

    char[][] grid;
    int maxY;
    int maxX;

    public static List<Pattern> createFromInput(List<String> input) {
        List<Pattern> patterns = new ArrayList<>();
        List<String> inputForPattern = new ArrayList<>();
        for (String line : input) {
            if (StringUtils.isEmpty(line)) {
                patterns.add(Pattern.of(inputForPattern));
                inputForPattern.clear();
            } else {
                inputForPattern.add(line);
            }
        }
        return patterns;
    }

    private static Pattern of(List<String> inputValue) {
        assert inputValue.size() > 1;
        int maxY = inputValue.size();
        int maxX = inputValue.get(0).length();
        char[][] grid = new char[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            System.arraycopy(inputValue.get(y).toCharArray(), 0, grid[y], 0, maxX);
        }
        return new Pattern(grid, maxY, maxX);
    }

    public int calculateCleanMirrorValue() {
        return findVerticalMirror(0) * 100 + findHorizontalMirror(0);
    }

    public int calculateMirrorWithOneSmudgeValue() {
        return findVerticalMirror(1) * 100 + findHorizontalMirror(1);
    }

    private int findHorizontalMirror(int numberOfSmudges) {
        boolean reflectionFound = false;
        int reflectionPointer = 0;
        while (!reflectionFound && reflectionPointer < maxX - 1) {
            int y = 0;
            int pointsWithoutReflection = 0;
            while (pointsWithoutReflection <= numberOfSmudges && y < maxY) {
                pointsWithoutReflection += findHorizontalPointsWithoutReflection(reflectionPointer, y++);
            }
            reflectionFound = pointsWithoutReflection == numberOfSmudges;
            reflectionPointer++;
        }
        return reflectionFound ? reflectionPointer : 0;
    }

    private int findHorizontalPointsWithoutReflection(int reflectionPointer, int y) {
        int pointsWithoutReflection = 0;
        int first = reflectionPointer;
        int second = reflectionPointer + 1;
        while (first >= 0 && second < maxX) {
            if (grid[y][first--] != grid[y][second++]) {
                pointsWithoutReflection++;
            }
        }
        return pointsWithoutReflection;
    }

    private int findVerticalMirror(int numberOfSmudges) {
        boolean reflectionFound = false;
        int reflectionPointer = 0;
        while (!reflectionFound && reflectionPointer < maxY - 1) {
            int x = 0;
            int pointsWithoutReflection = 0;
            while (pointsWithoutReflection <= numberOfSmudges && x < maxX) {
                pointsWithoutReflection += findVerticalPointsWithoutReflection(reflectionPointer, x++);
            }
            reflectionFound = pointsWithoutReflection == numberOfSmudges;
            reflectionPointer++;
        }
        return reflectionFound ? reflectionPointer : 0;
    }

    private int findVerticalPointsWithoutReflection(int reflectionPointer, int x) {
        int pointsWithoutReflection = 0;
        int first = reflectionPointer;
        int second = reflectionPointer + 1;
        while (first >= 0 && second < maxY) {
            if (grid[first--][x] != grid[second++][x]) {
                pointsWithoutReflection++;
            }
        }
        return pointsWithoutReflection;
    }
}
