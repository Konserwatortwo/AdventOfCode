package AoC2021.Day3;

import AoC2021.AdventTask;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Task3B extends AdventTask {

    public Task3B() {
        super("Day3", "Task3B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Pair<List<String>, List<String>> firstPair = divideForLeading(input, 0);
        List<String> oxygenGeneratorRatingList = firstPair.getKey();
        List<String> scrubberCO2RatingList = firstPair.getValue();

        for (int i = 1; i < input.get(0).length(); i++) {
            if (oxygenGeneratorRatingList.size() > 1) {
                oxygenGeneratorRatingList = divideForLeading(oxygenGeneratorRatingList, i).getKey();
            }
            if (scrubberCO2RatingList.size() > 1) {
                scrubberCO2RatingList = divideForLeading(scrubberCO2RatingList, i).getValue();
            }
        }
        return List.of(Integer.parseInt(oxygenGeneratorRatingList.get(0), 2) * Integer.parseInt(scrubberCO2RatingList.get(0), 2) + "");
    }

    private Pair<List<String>, List<String>> divideForLeading(List<String> list, int position) {
        int lead = 0;
        List<String> zeroLead = new ArrayList<>();
        List<String> oneLead = new ArrayList<>();
        for (String line : list) {
            char signal = line.charAt(position);
            if (signal == '0') {
                zeroLead.add(line);
                lead--;
            } else {
                oneLead.add(line);
                lead++;
            }
        }
        return lead < 0 ? Pair.of(zeroLead, oneLead) : Pair.of(oneLead, zeroLead);
    }
}
