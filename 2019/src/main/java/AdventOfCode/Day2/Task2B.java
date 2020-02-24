package AdventOfCode.Day2;

import AdventOfCode.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task2B extends AdventTask {

    @Override
    protected List<String> perform(List<String> input) {
        List<String> output = new ArrayList<>();
        for (int noun = 0; noun < 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                int[] expressions = parseInput(input);
                expressions[1] = noun;
                expressions[2] = verb;
                int result = executeOPCode(expressions);
                if (19690720 == result) {
                    output.add("" + noun + verb);
                }
            }
        }
        return output;
    }


    private int[] parseInput(List<String> input) {
        String[] lines = input.get(0).split(",");
        int[] result = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = Integer.parseInt(lines[i]);
        }
        return result;
    }

    private int executeOPCode(int[] expressions) {
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
        return expressions[0];
    }

}
