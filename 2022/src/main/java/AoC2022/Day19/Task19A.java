package AoC2022.Day19;

import AoC2022.AdventTask;
import AoC2022.Day19.dto.Beacon;
import AoC2022.Day19.dto.Scanner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static AoC2022.Day19.TaskUtils.*;

public class Task19A extends AdventTask {

    public Task19A() {
        super("Day19", "Task19A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Scanner> scanners = readData(input);
        determineScannersRelativePosition(scanners);
        scanners.forEach(System.out::println);
        Set<String> uniquePositions = uniqueBeaconsPositions(scanners);
        return List.of(uniquePositions.size() +"");
    }

    private static Set<String> uniqueBeaconsPositions(List<Scanner> scanners) {
        Set<String> uniquePositions = new HashSet<>();
        for (Scanner scanner : scanners) {
            for (Beacon beacon : scanner.getBeacons()) {
                uniquePositions.add(beacon.getPosition());
            }
        }
        return uniquePositions;
    }
}
