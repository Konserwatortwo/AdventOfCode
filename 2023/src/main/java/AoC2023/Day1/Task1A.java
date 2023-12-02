package AoC2023.Day1;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task1A extends AdventTask {

    public Task1A() {
        super("Day1", "Task1A");
    }

    @Override
    public List<String> perform(List<String> input) {
        char firstDigit = ' ';
        char lastDigit = ' ';
        int sum = 0;

        for (String line : input) {
            for (char sign : line.toCharArray()) {
                if (sign >= 48 && sign <= 57) {
                    if (firstDigit == ' ') {
                        firstDigit = sign;
                    }
                    lastDigit = sign;
                }
            }
            sum += Integer.parseInt(firstDigit + "" + lastDigit);
            firstDigit = ' ';
        }
        return answerAs(sum);
    }
}
