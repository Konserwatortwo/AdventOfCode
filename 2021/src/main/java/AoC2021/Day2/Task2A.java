package AoC2021.Day2;

import AoC2021.AdventTask;

import java.util.List;

public class Task2A extends AdventTask {

    public Task2A() {
        super("Day2", "Task2A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int x = 0;
        int y = 0;
        for (String line : input) {
            String[] command = line.split(" ");
            switch (command[0]) {
                case "forward" -> x += Integer.parseInt(command[1]);
                case "down" -> y += Integer.parseInt(command[1]);
                case "up" -> y -= Integer.parseInt(command[1]);
            }
        }
        return List.of(x * y + "");
    }
}
