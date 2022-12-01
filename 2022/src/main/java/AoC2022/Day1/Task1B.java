package AoC2022.Day1;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1B extends AdventTask {

    public Task1B() {
        super("Day1", "Task1B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Integer> array =  new ArrayList<>();
        int sum = 0;
        for (String line : input) {
            if (line.isBlank()) {
                array.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }
        array.add(sum);
        array.sort(Integer::compareTo);
        Collections.reverse(array);
        return List.of(array.get(0) + array.get(1)  + array.get(2)  + "");
    }

}
