package AoC2022.Day13;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

public class Sheet {

    private int sizeX;
    private int sizeY;

    private int dotsNumber;
    private boolean[][] sheet;

    public Sheet(List<String> dotsData) {
        sizeX = Integer.MIN_VALUE;
        sizeY = Integer.MIN_VALUE;

        List<Point> dots = new ArrayList<>();
        for (String line : dotsData) {
            String[] elements = line.split(",");
            Point point = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
            dots.add(point);
            sizeX = Math.max(sizeX, point.x);
            sizeY = Math.max(sizeY, point.y);
        }
        dotsNumber = dots.size();

        sheet = new boolean[++sizeX][++sizeY];
        for (Point dot : dots) {
            sheet[dot.x][dot.y] = true;
        }
    }

    public int getDotsNumber() {
        return dotsNumber;
    }

    public void fold(String foldCommand) {
        String[] elements = foldCommand.split("=");
        int foldCoordinate = Integer.parseInt(elements[1]);

        if (elements[0].contains("x")) {
            folding(foldCoordinate + 1, 0, x -> calculateMirror(x, foldCoordinate), y -> y);
            sizeX = foldCoordinate;
        } else {
            folding(0, foldCoordinate + 1, x -> x, y -> calculateMirror(y, foldCoordinate));
            sizeY = foldCoordinate;
        }
    }

    private void folding(int startX, int startY, Function<Integer, Integer> mappingX, Function<Integer, Integer> mappingY) {
        for (int x = startX; x < sizeX; x++) {
            for (int y = startY; y < sizeY; y++) {
                if (sheet[x][y]) {
                    int mirrorX = mappingX.apply(x);
                    int mirrorY = mappingY.apply(y);
                    if (sheet[mirrorX][mirrorY]) {
                        dotsNumber--;
                    } else {
                        sheet[mirrorX][mirrorY] = true;
                    }
                }
            }
        }
    }

    private int calculateMirror(int coordinate, int fold) {
        return fold * 2 - coordinate;
    }

    public List<String> printBoardPretty() {
        List<String> output = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) {
            StringJoiner joiner = new StringJoiner(" ");
            for (int x = 0; x < sizeX; x++) {
                joiner.add(sheet[x][y] ? "█" : " ");
            }
            output.add(joiner.toString());
        }
        return output;
    }
}
