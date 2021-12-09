package AoC2021.Day3;

import AoC2021.AdventTask;

import java.util.List;

public class Task3A extends AdventTask {

    public Task3A() {
        super("Day3", "Task3A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int[] table = new int[input.get(0).length()];

        for (String s : input) {
            char[] line = s.toCharArray();
            for (int i = 0; i < table.length; i++) {
                if (line[i] == '0') {
                    table[i] -= 1;
                } else {
                    table[i] += 1;
                }
            }
        }

        int gammaRate = 0;
        int epsilonRate = 0;
        int multiplayer = 1;

        for (int j = table.length - 1; j >= 0; j--) {
            int i = table[j];
            if (i > 0) {
                gammaRate += multiplayer;
            } else {
                epsilonRate += multiplayer;
            }
            multiplayer *= 2;
        }


        return List.of(gammaRate * epsilonRate + "");
    }
}
