package AoC2022.Day14;

import AoC2022.AdventTask;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class Task14A extends AdventTask {

    public Task14A() {
        super("Day14", "Task14A");
    }

    @Override
    public List<String> perform(List<String> input) {
        String sequence = performTask(input, 10);

        int mostCommonElementOccurrence = Integer.MIN_VALUE;
        int leastCommonElementOccurrence = Integer.MAX_VALUE;
        for (char elem = 'A'; elem <= 'Z'; elem++) {
            int charOccurrence = StringUtils.countMatches(sequence, elem);
            mostCommonElementOccurrence = Math.max(mostCommonElementOccurrence, charOccurrence);
            leastCommonElementOccurrence = charOccurrence > 0 && leastCommonElementOccurrence > charOccurrence ? charOccurrence : leastCommonElementOccurrence;
        }

        return List.of(mostCommonElementOccurrence - leastCommonElementOccurrence + "");
    }

    public String performTask(List<String> input, int steps) {
        String sequence = input.get(0);
        HashMap<String, Character> templates = retrieveTemplates(input.subList(2, input.size()));

        for (int step = 0; step < steps; step++) {
            StringBuilder newSequence = new StringBuilder();
            String subsequence = "";
            for (int i = 1; i < sequence.length(); i++) {
                subsequence = sequence.substring(i - 1, i + 1);
                char middleElement = templates.get(subsequence);
                newSequence.append(subsequence.charAt(0)).append(middleElement);
            }
            newSequence.append(subsequence.charAt(1));
            sequence = newSequence.toString();
        }

        return sequence;
    }


    private HashMap<String, Character> retrieveTemplates(List<String> input) {
        HashMap<String, Character> templates = new HashMap<>();
        for (String line : input) {
            String[] element = line.split(" -> ");
            templates.put(element[0], element[1].charAt(0));
        }
        return templates;
    }
}
