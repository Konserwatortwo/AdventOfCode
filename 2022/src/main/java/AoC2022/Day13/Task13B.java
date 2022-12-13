package AoC2022.Day13;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task13B extends AdventTask {

    public Task13B() {
        super("Day13", "Task13B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Packet firstSeparator = new Packet("[[2]]");
        Packet secondSeparator = new Packet("[[6]]");
        List<Packet> allPackets = new ArrayList<>();
        allPackets.add(firstSeparator);
        allPackets.add(secondSeparator);
        for (String line : input) {
            if (!line.isEmpty()) {
                allPackets.add(new Packet(line));
            }
        }
        Collections.sort(allPackets);
        return List.of((allPackets.indexOf(firstSeparator) + 1) * (allPackets.indexOf(secondSeparator) + 1) + "");
    }
}
