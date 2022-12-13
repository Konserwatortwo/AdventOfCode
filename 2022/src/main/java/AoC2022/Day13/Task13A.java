package AoC2022.Day13;

import AoC2022.AdventTask;

import java.util.List;

public class Task13A extends AdventTask {

    public Task13A() {
        super("Day13", "Task13A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int index = 1;
        int sum = 0;
        Packet left = null;

        for (String line : input) {
            if (line.isEmpty()) {
                index++;
                left = null;
            } else if (null == left) {
                left = new Packet(line);
            } else if (left.compareTo(new Packet(line)) < 0) {
                sum += index;
            }
        }

        return List.of(sum + "");
    }
}
