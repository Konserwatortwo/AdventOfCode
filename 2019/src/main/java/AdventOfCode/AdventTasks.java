package AdventOfCode;

import AdventOfCode.Day1.Task1A;
import AdventOfCode.Day1.Task1B;
import AdventOfCode.Day2.Task2A;
import AdventOfCode.Day2.Task2B;
import AdventOfCode.Day3.Task3A;
import AdventOfCode.Day3.Task3B;
import AdventOfCode.Day4.Task4A;
import AdventOfCode.Day4.Task4B;

public enum AdventTasks {

    ALL_TASK("All Task", null),

    TASK_1A("1A", new Task1A()),
    TASK_1B("1B", new Task1B()),
    TASK_2A("2A", new Task2A()),
    TASK_2B("2B", new Task2B()),

    TASK_3A("3A", new Task3A()),
    TASK_3B("3B", new Task3B()),
    TASK_4A("4A", new Task4A()),
    TASK_4B("4B", new Task4B()),

    TASK_5A("5A", null),
    TASK_5B("5B", null),
    TASK_6A("6A", null),
    TASK_6B("6B", null),

    TASK_7A("7A", null),
    TASK_7B("7B", null),
    TASK_8A("8A", null),
    TASK_8B("8B", null),

    TASK_9A("9A", null),
    TASK_9B("9B", null),
    TASK_10A("10A", null),
    TASK_10B("10B", null),

    TASK_11A("11A", null),
    TASK_11B("11B", null),
    TASK_12A("12A", null),
    TASK_12B("12B", null),

    TASK_13A("13A", null),
    TASK_13B("13B", null),
    TASK_14A("14A", null),
    TASK_14B("14B", null),

    TASK_15A("15A", null),
    TASK_15B("15B", null),
    TASK_16A("16A", null),
    TASK_16B("16B", null),

    TASK_17A("17A", null),
    TASK_17B("17B", null),
    TASK_18A("18A", null),
    TASK_18B("18B", null),

    TASK_19A("19A", null),
    TASK_19B("19B", null),
    TASK_20A("20A", null),
    TASK_20B("20B", null),

    TASK_21A("21A", null),
    TASK_21B("21B", null),
    TASK_22A("22A", null),
    TASK_22B("22B", null),

    TASK_23A("23A", null),
    TASK_23B("23B", null),
    TASK_24A("24A", null),
    TASK_24B("24B", null),

    TASK_25A("25A", null),
    TASK_25B("25B", null),
    ;

    private String name;
    private AdventTask adventTask;

    AdventTasks(String name, AdventTask adventTaskClass) {
        this.name = name;
        if (adventTaskClass != null) {
            this.adventTask = adventTaskClass;
            this.adventTask.setFileNameSuffix(name);
        }
    }

    public boolean isSelected(String selection) {
        return name().equals(selection.trim()) || name.equals(selection.trim());
    }

    public AdventTask getAdventTask() {
        return adventTask;
    }
}
