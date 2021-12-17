package AoC2021;

import AoC2021.Day1.Task1A;
import AoC2021.Day1.Task1B;
import AoC2021.Day10.Task10A;
import AoC2021.Day10.Task10B;
import AoC2021.Day11.Task11A;
import AoC2021.Day11.Task11B;
import AoC2021.Day12.Task12A;
import AoC2021.Day12.Task12B;
import AoC2021.Day13.Task13A;
import AoC2021.Day13.Task13B;
import AoC2021.Day14.Task14A;
import AoC2021.Day14.Task14B;
import AoC2021.Day15.Task15A;
import AoC2021.Day15.Task15B;
import AoC2021.Day16.Task16A;
import AoC2021.Day16.Task16B;
import AoC2021.Day17.Task17A;
import AoC2021.Day17.Task17B;
import AoC2021.Day18.Task18A;
import AoC2021.Day18.Task18B;
import AoC2021.Day19.Task19A;
import AoC2021.Day19.Task19B;
import AoC2021.Day2.Task2A;
import AoC2021.Day2.Task2B;
import AoC2021.Day3.Task3A;
import AoC2021.Day3.Task3B;
import AoC2021.Day4.Task4A;
import AoC2021.Day4.Task4B;
import AoC2021.Day5.Task5A;
import AoC2021.Day5.Task5B;
import AoC2021.Day6.Task6A;
import AoC2021.Day6.Task6B;
import AoC2021.Day7.Task7A;
import AoC2021.Day7.Task7B;
import AoC2021.Day8.Task8A;
import AoC2021.Day8.Task8B;
import AoC2021.Day9.Task9A;
import AoC2021.Day9.Task9B;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static AdventTask selectedTask = new Task18A();

    private static List<AdventTask> allTasks = new ArrayList<>();

    static {
        allTasks.add(new Task1A());
        allTasks.add(new Task1B());

        allTasks.add(new Task2A());
        allTasks.add(new Task2B());

        allTasks.add(new Task3A());
        allTasks.add(new Task3B());

        allTasks.add(new Task4A());
        allTasks.add(new Task4B());

        allTasks.add(new Task5A());
        allTasks.add(new Task5B());

        allTasks.add(new Task6A());
        allTasks.add(new Task6B());

        allTasks.add(new Task7A());
        allTasks.add(new Task7B());

        allTasks.add(new Task8A());
        allTasks.add(new Task8B());

        allTasks.add(new Task9A());
        allTasks.add(new Task9B());

        allTasks.add(new Task10A());
        allTasks.add(new Task10B());

        allTasks.add(new Task11A());
        allTasks.add(new Task11B());

        allTasks.add(new Task12A());
        allTasks.add(new Task12B());

        allTasks.add(new Task13A());
        allTasks.add(new Task13B());

        allTasks.add(new Task14A());
        allTasks.add(new Task14B());

        allTasks.add(new Task15A());
        allTasks.add(new Task15B());

        allTasks.add(new Task16A());
        allTasks.add(new Task16B());

        allTasks.add(new Task17A());
        allTasks.add(new Task17B());

        allTasks.add(new Task18A());
        allTasks.add(new Task18B());

        allTasks.add(new Task19A());
        allTasks.add(new Task19B());
    }

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        System.out.println("Witaj w Advent Of Code 2021 :::");

        long start = System.nanoTime();
        if (selectedTask != null) {
            selectedTask.execute();
        } else {
            for (AdventTask allTask : allTasks) {
                allTask.execute();
            }
        }
        long end = System.nanoTime() - start;
        System.out.println("Time elapsed: " + (end / 1000000) + " ms");
    }
}
