package AoC2022.Day3;

import AoC2022.AdventTask;

import java.util.List;

public class Task3A extends AdventTask {

    public Task3A() {
        super("Day3", "Task3A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int value = 0;
        for (String line : input) {
            value += valueForItem(line);
        }
        return List.of(value + "");
    }

    private int valueForItem(String line) {
        int mid = line.length() / 2;
        String firstCompartment = line.substring(0, mid);
        String secondCompartment = line.substring(mid);

        char letter = ' ';
        int index = 0;
        while(secondCompartment.indexOf(letter) == -1) {
            letter = firstCompartment.charAt(index++);
        }

        return valueForLetter(letter);
    }

    private int valueForLetter(char letter) {
        return Character.isUpperCase(letter) ? (int) letter - 38 : (int) letter - 96;
    }

}
