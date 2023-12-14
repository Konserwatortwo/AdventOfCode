package AoC2023.Day13;

import AoC2023.shared.Grid;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

class Pattern extends Grid {

    public Pattern(List<String> inputValue) {
        super(inputValue);
    }

    public static List<Pattern> createFromInput(List<String> input) {
        List<Pattern> patterns = new ArrayList<>();
        List<String> inputForPattern = new ArrayList<>();
        for (String line : input) {
            if (StringUtils.isEmpty(line)) {
                patterns.add(new Pattern(inputForPattern));
                inputForPattern.clear();
            } else {
                inputForPattern.add(line);
            }
        }
        return patterns;
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
