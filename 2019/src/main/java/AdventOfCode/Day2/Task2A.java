package AdventOfCode.Day2;

import AdventOfCode.AdventTask;

import java.util.Collections;
import java.util.List;

public class Task2A extends AdventTask {

    @Override
    protected List<String> perform(List<String> input) {
        int[] expressions = parseInput(input);

        int commandPosition = 0;
        boolean isCompleted = false;
        while (!isCompleted) {
            long result;
            int firstPosition, secondPosition, thirdPosition;
            switch (expressions[commandPosition]) {
                case 1:
                    firstPosition = expressions[commandPosition + 1];
                    secondPosition = expressions[commandPosition + 2];
                    thirdPosition = expressions[commandPosition + 3];
                    result = expressions[firstPosition] + expressions[secondPosition];
                    expressions[thirdPosition] = (int) result;
                    break;
                case 2:
                    firstPosition = expressions[commandPosition + 1];
                    secondPosition = expressions[commandPosition + 2];
                    thirdPosition = expressions[commandPosition + 3];
                    result = expressions[firstPosition] * expressions[secondPosition];
                    expressions[thirdPosition] = (int) result;
                    break;
                case 99:
                    isCompleted = true;
                    break;
                default:
                    throw new IllegalStateException();
            }
            commandPosition += 4;
            isCompleted |= commandPosition > expressions.length;
        }
        return Collections.singletonList(expressions[0] + "");
    }

    private int[] parseInput(List<String> input) {
        String[] lines = input.get(0).split(",");
        int[] result = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = Integer.parseInt(lines[i]);
        }
        return result;
    }

}
