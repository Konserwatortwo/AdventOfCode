package AoC2023.Day2;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Game {

    int number;
    int maxRedCubes;
    int maxGreenCubes;
    int maxBlueCubes;

    public static Game parse(String line) {
        String[] elements = line.split(" ");
        int gameNumber = Integer.parseInt(elements[1].replace(":", ""));
        int redCubes = 0;
        int greenCubes = 0;
        int blueCubes = 0;
        for (int i = 3; i < elements.length; i += 2) {
            if (elements[i].contains("blue")) {
                blueCubes = Math.max(blueCubes, Integer.parseInt(elements[i - 1]));
            } else if (elements[i].contains("red")) {
                redCubes = Math.max(redCubes, Integer.parseInt(elements[i - 1]));
            } else if (elements[i].contains("green")) {
                greenCubes = Math.max(greenCubes, Integer.parseInt(elements[i - 1]));
            }
        }
        return new Game(gameNumber, redCubes, greenCubes, blueCubes);
    }

    public boolean isNumberOfCubesLessThan(int limitOfRedCubes, int limitOfGreenCubes, int limitOfBlueCubes) {
        return maxRedCubes <= limitOfRedCubes
                && maxGreenCubes <= limitOfGreenCubes
                && maxBlueCubes <= limitOfBlueCubes;
    }

    public int calculateValue() {
        return maxRedCubes * maxGreenCubes * maxBlueCubes;
    }
}
