package AoC2023.Day2;

import java.util.List;

class OPCalculator {

    public static int[] parseInput(List<String> input) {
        String[] lines = input.get(0).split(",");
        int[] result = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = Integer.parseInt(lines[i]);
        }
        return result;
    }

    public static int executeOPCode(int[] expressions) {
        int commandPosition = 0;
        boolean isCompleted = false;
        while (!isCompleted) {
            long result;
            int firstPosition, secondPosition, thirdPosition;
            switch (expressions[commandPosition]) {
                case 1 -> {
                    firstPosition = expressions[commandPosition + 1];
                    secondPosition = expressions[commandPosition + 2];
                    thirdPosition = expressions[commandPosition + 3];
                    result = expressions[firstPosition] + expressions[secondPosition];
                    expressions[thirdPosition] = (int) result;
                }
                case 2 -> {
                    firstPosition = expressions[commandPosition + 1];
                    secondPosition = expressions[commandPosition + 2];
                    thirdPosition = expressions[commandPosition + 3];
                    result = (long) expressions[firstPosition] * expressions[secondPosition];
                    expressions[thirdPosition] = (int) result;
                }
                case 99 -> isCompleted = true;
                default -> throw new IllegalStateException();
            }
            commandPosition += 4;
            isCompleted |= commandPosition > expressions.length;
        }
        return expressions[0];
    }
}
