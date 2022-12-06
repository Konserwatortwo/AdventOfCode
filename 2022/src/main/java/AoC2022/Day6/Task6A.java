package AoC2022.Day6;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task6A extends AdventTask {

    public Task6A() {
        super("Day6", "Task6A");
    }

    @Override
    public List<String> perform(List<String> input) {
        String line = input.get(0);
        int marker = 0;
        List<Character> buffer = new ArrayList<>();

        char[] charArray = line.toCharArray();
        int i = 0, charArrayLength = charArray.length;
        while (i < charArrayLength && marker == 0) {
            Character letter = charArray[i++];
            if(buffer.contains(letter)) {
               buffer = buffer.subList(buffer.indexOf(letter) + 1, buffer.size());
            }
            buffer.add(letter);
            if (buffer.size() == 4) {
                marker = i;
            }
        }
        return List.of(marker+"");
    }
}
