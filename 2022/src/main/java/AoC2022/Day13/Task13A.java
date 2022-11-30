package AoC2022.Day13;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task13A extends AdventTask {

    public Task13A() {
        super("Day13", "Task13A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<List<String>> data = readData(input);
        Sheet sheet = new Sheet(data.get(0));
        sheet.fold(data.get(1).get(0));
        return List.of(sheet.getDotsNumber() + "");
    }

    private List<List<String>> readData(List<String> input) {
        List<String> dotsData = new ArrayList<>();
        List<String> foldsData = new ArrayList<>();

        boolean readingDots = true;
        for (String line : input) {
            if (line.isEmpty()) {
                readingDots = false;
                continue;
            }
            if (readingDots) {
                dotsData.add(line);
            } else {
                foldsData.add(line.replace("fold along ", ""));
            }
        }

        return List.of(dotsData, foldsData);
    }

}
