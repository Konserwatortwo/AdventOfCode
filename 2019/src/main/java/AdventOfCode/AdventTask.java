package AdventOfCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AdventTask {

    private static final String PATH_TO_INPUT_DIR = "P:\\AdventOfCode\\2019\\src\\main\\resources\\input\\";
    private static final String INPUT_PREFIX = "INPUT_";
    private static final String PATH_TO_OUTPUT_DIR = "P:\\AdventOfCode\\2019\\src\\main\\resources\\output\\";
    private static final String OUTPUT_PREFIX = "OUTPUT_";

    private String fileNameSuffix;

    protected abstract List<String> perform(List<String> input);

    void execute() {
        System.out.println("Wywowałno : " + this.getClass().getCanonicalName());
        List<String> input = readInput();
        List<String> output = perform(input);
        saveOutput(output);
    }

    private List<String> readInput() {
        List<String> input = new ArrayList<String>();
        try {
            File file = new File(PATH_TO_INPUT_DIR + INPUT_PREFIX + fileNameSuffix);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                input.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
        return input;
    }

    private void saveOutput(List<String> output) {
        try {
            File file = new File(PATH_TO_OUTPUT_DIR + OUTPUT_PREFIX + fileNameSuffix);
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String line : output) {
                bufferedWriter.append(line);
            }
            bufferedWriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    void setFileNameSuffix(String fileNameSuffix) {
        this.fileNameSuffix = fileNameSuffix;
    }
}
