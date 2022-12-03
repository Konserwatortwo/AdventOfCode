package AoC2022.Day3;

import AoC2022.AdventTask;

import java.util.List;

public class Task3B extends AdventTask {

    public Task3B() {
        super("Day3", "Task3B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int value = 0;
        int size = input.size() / 3;
        for (int i = 0; i < size; i++) {
            value += valueForGroup(input.get(i * 3), input.get(i * 3 + 1), input.get(i * 3 + 2));
        }
        return List.of(value + "");
    }

    private int valueForGroup(String first, String second, String third) {
        char letter = ' ';
        int index = 0;
        while (second.indexOf(letter) == -1 || third.indexOf(letter) == -1) {
            letter = first.charAt(index++);
        }
        return valueForLetter(letter);
    }

    private int valueForLetter(char letter) {
        return Character.isUpperCase(letter) ? (int) letter - 38 : (int) letter - 96;
    }
}
