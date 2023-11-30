package AoC2022;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public abstract class AdventTask {

    private static final String PATH_TO_RESOURCES = "src\\main\\resources";
    private static final String DIRECTORY_SEPARATOR = "\\";
    private static final String INPUT_PREFIX = "INPUT";
    private static final String OUTPUT_PREFIX = "OUTPUT";

    private final String daySuffix;
    private final String taskSuffix;

    public AdventTask(String daySuffix, String taskSuffix) {
        this.daySuffix = daySuffix;
        this.taskSuffix = taskSuffix;
    }

    public abstract List<String> perform(List<String> input);

    public void execute() {
        System.out.printf("Invoked task process for %s and name %s %n", daySuffix, taskSuffix);
        List<String> input = readInput();
        List<String> output = perform(input);
        if (null == output) {
            System.out.printf("OUTPUT WARNING: Empty task output for %s and name %s %n", daySuffix, taskSuffix);
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
            System.out.printf("INPUT ERROR: Error during reading task from input file for %s and name %s %n", daySuffix, taskSuffix);
            System.out.println(exp);
        }
        return input;
    }

    private void saveOutput(List<String> output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(retrievePathToResource(OUTPUT_PREFIX)))) {
            for (String line : output) {
                bufferedWriter.append(line).append("\n");
            }
        } catch (Exception exp) {
            System.out.printf("OUTPUT ERROR: Error during writing task to output file for %s and name %s %n", daySuffix, taskSuffix);
            System.out.println(exp);
        }
    }

    private String retrievePathToResource(String resourcePrefix) {
        StringJoiner joiner = new StringJoiner(DIRECTORY_SEPARATOR);
        joiner.add(Application.YEAR);
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
