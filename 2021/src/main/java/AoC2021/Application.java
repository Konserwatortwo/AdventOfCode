package AoC2021;

import AoC2021.Day1.*;
import AoC2021.Day2.*;
import AoC2021.Day3.*;
import AoC2021.Day4.*;
import AoC2021.Day5.*;
import AoC2021.Day6.*;
import AoC2021.Day7.*;
import AoC2021.Day8.*;
import AoC2021.Day9.*;
import AoC2021.Day10.*;
import AoC2021.Day11.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static AdventTask selectedTask = new Task10A();

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
    }

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        System.out.println("Witaj w Advent Of Code 2021 :::");

        if (selectedTask != null) {
            selectedTask.execute();
        } else {
            for (AdventTask allTask : allTasks) {
                allTask.execute();
            }
        }
    }
}
