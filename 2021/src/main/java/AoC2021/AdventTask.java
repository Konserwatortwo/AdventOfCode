package AoC2021;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public abstract class AdventTask {

    private static final String PATH_TO_RESOURCES = "src\\main\\resources";
    private static final String DIRECTORY_SEPARATOR = "\\";
    private static final String INPUT_PREFIX = "INPUT";
    private static final String OUTPUT_PREFIX = "OUTPUT";

    private String daySuffix;
    private String taskSuffix;

    public AdventTask(String daySuffix, String taskSuffix) {
        this.daySuffix = daySuffix;
        this.taskSuffix = taskSuffix;
    }

    public abstract List<String> perform(List<String> input);

    public void execute() {
        System.out.printf("Wywowałno zadanie z dnia %s o nazwie %s %n", daySuffix, taskSuffix);
        List<String> input = readInput();
        List<String> output = perform(input);
        if (null == output) {
            System.out.printf("OUTPUT ERROR: Pusty zapis zadania z dnia %s o nazwie %s %n", daySuffix, taskSuffix);
            output = new ArrayList<>();
            output.add("null");
        }
        saveOutput(output);
    }

    private List<String> readInput() {
        List<String> input = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(retrievePathToResource(INPUT_PREFIX))))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                input.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception exp) {
            System.out.printf("INPUT ERROR: Błąd przy wczytywaniu zadania z dnia %s o nazwie %s %n", daySuffix, taskSuffix);
            System.out.println(exp);
        }
        return input;
    }

    private void saveOutput(List<String> output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(retrievePathToResource(OUTPUT_PREFIX)))) {
            for (String line : output) {
                bufferedWriter.append(line);
            }
        } catch (Exception exp) {
            System.out.printf("OUTPUT ERROR: Błąd przy zapisywaniu zadania z dnia %s o nazwie %s %n", daySuffix, taskSuffix);
            System.out.println(exp);
        }
    }

    private String retrievePathToResource(String resourcePrefix) {
        StringJoiner joiner = new StringJoiner(DIRECTORY_SEPARATOR);
        joiner.add(PATH_TO_RESOURCES);
        joiner.add(resourcePrefix);
        joiner.add(daySuffix);
        joiner.add(retrieveFileName(resourcePrefix));
        return joiner.toString();
    }

    private String retrieveFileName(String resourcePrefix) {
        return resourcePrefix + "_" + taskSuffix;
    }
}
