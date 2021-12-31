package AoC2021.Day19;

import AoC2021.AdventTask;
import AoC2021.Day19.dto.Scanner;
import AoC2021.Day19.enums.Coordinate;

import java.util.List;

import static AoC2021.Day19.TaskUtils.determineScannersRelativePosition;
import static AoC2021.Day19.TaskUtils.readData;

public class Task19B extends AdventTask {

    public Task19B() {
        super("Day19", "Task19B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Scanner> scanners = readData(input);
        determineScannersRelativePosition(scanners);

        int largestDistance = Integer.MIN_VALUE;
        for (int i = 1, scannersSize = scanners.size(); i < scannersSize; i++) {
            for (int j = 1; j < scannersSize; j++) {
                largestDistance = Math.max(largestDistance, distanceBetweenScanners(scanners.get(i), scanners.get(j)));
            }
        }
        return List.of(largestDistance + "");
    }

    private static int distanceBetweenScanners(Scanner first, Scanner second) {
        int x = Math.abs(first.getCoordinate(Coordinate.X) - second.getCoordinate(Coordinate.X));
        int y = Math.abs(first.getCoordinate(Coordinate.Y) - second.getCoordinate(Coordinate.Y));
        int z = Math.abs(first.getCoordinate(Coordinate.Z) - second.getCoordinate(Coordinate.Z));
        return x + y + z;
    }
}
