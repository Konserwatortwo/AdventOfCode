package AoC2022.Day13;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task13B extends AdventTask {

    public Task13B() {
        super("Day13", "Task13B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<List<String>> data = readData(input);
        Sheet sheet = new Sheet(data.get(0));
        for (String foldCommand : data.get(1)) {
            sheet.fold(foldCommand);
        }
        return sheet.printBoardPretty();
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
