package AdventOfCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private static AdventTasks selectedTask = AdventTasks.TASK_4B;

    public static void main(String[] args) throws IOException {
        System.out.println("Witaj w Advent Of Code 2019");

        if (selectedTask != null) {
            if (selectedTask == AdventTasks.ALL_TASK) {
                for (AdventTasks value : AdventTasks.values()) {
                    value.getAdventTask().execute();
                }
            } else {
                selectedTask.getAdventTask().execute();
            }
        } else {
            System.out.println("Wybierz zadanie :");
            boolean isCorrectChoice = false;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String choice = reader.readLine();
            for (AdventTasks value : AdventTasks.values()) {
                if (value.isSelected(choice)) {
                    value.getAdventTask().execute();
                    isCorrectChoice = true;
                }
            }
            if (!isCorrectChoice) {
                System.out.println("Błedny wybór");
            }
        }
    }
}
