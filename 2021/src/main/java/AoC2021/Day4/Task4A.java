package AoC2021.Day4;

import AoC2021.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task4A extends AdventTask {

    public Task4A() {
        super("Day4", "Task4A");
    }


    @Override
    public List<String> perform(List<String> input) {
        String[] numbers = input.get(0).split(",");
        List<String> bingoLines = new ArrayList<>();
        List<BingoTable> bingos = new ArrayList<>();
        int iter = 0;

        for (int i = 2; i < input.size(); i++) {
            String line = input.get(i);
            if (line.trim().isEmpty()) {
                bingos.add(new BingoTable(iter++, bingoLines));
                bingoLines.clear();
            } else {
                bingoLines.add(line);
            }
        }
        if (!bingoLines.isEmpty()) {
            bingos.add(new BingoTable(iter, bingoLines));
        }

        int score = 0;
        int i = 0;
        while (score == 0) {
            int number = Integer.parseInt(numbers[i++]);
            for (BingoTable bingo : bingos) {
                if (bingo.checkNumber(number)) {
                    score = number * bingo.getRestScore();
                    break;
                }
            }
        }

        return List.of(score + "");
    }


}
