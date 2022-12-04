package AoC2022.Day4;

import AoC2022.AdventTask;

import java.util.List;

public class Task4A extends AdventTask {

    public Task4A() {
        super("Day4", "Task4A");
    }

    @Override
    public List<String> perform(List<String> input) {
        int counter = 0;
        for (String line : input) {
            if (overlappingLine(line)) {
                counter++;
            }
        }
        return List.of(counter + "");
    }

    private boolean overlappingLine(String line) {
        String[] elements = line.split(",");
        Integer[] firstPair = decodeLine(elements[0]);
        Integer[] secondPair = decodeLine(elements[1]);
        return isOverlapping(firstPair, secondPair) || isOverlapping(secondPair, firstPair);
    }


    private Integer[] decodeLine(String line) {
        String[] elements = line.split("-");
        Integer[] value = new Integer[2];
        value[0] = Integer.parseInt(elements[0]);
        value[1] = Integer.parseInt(elements[1]);
        return value;
    }

    private boolean isOverlapping(Integer[] overlapping, Integer[] overlapped) {
        return overlapping[0] <= overlapped[0] && overlapping[1] >= overlapped[1];
    }
}
