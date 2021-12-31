package AoC2021.Day22;

import AoC2021.Day22.enums.Coordinate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CuboidUtils {

    public static BigInteger completeSetup(List<Cuboid> cuboids) {
        List<Cuboid> alreadyProcessed = new ArrayList<>();
        List<Cuboid> intersections;
        alreadyProcessed.add(cuboids.get(0));

        for (int i = 1; i < cuboids.size(); i++) {
            Cuboid cuboid = cuboids.get(i);
            intersections = new ArrayList<>();
            for (Cuboid existing : alreadyProcessed) {
                Cuboid commonPart = retrieveCommonCuboid(existing, cuboid);
                if (commonPart.isCorrect()) {
                    intersections.add(commonPart);
                }
            }
            intersections = removeDuplicates(intersections);

            if (cuboid.isOn()) {
                intersections.add(cuboid);
            }
            alreadyProcessed.addAll(intersections);
        }

        BigInteger totalSpace = BigInteger.ZERO;
        for (Cuboid cuboid : alreadyProcessed) {
            totalSpace = totalSpace.add(cuboid.getSpace());
        }
        return totalSpace;
    }

    private static Cuboid retrieveCommonCuboid(Cuboid first, Cuboid second) {
        Map<Coordinate, Range> ranges = new HashMap<>();
        for (Coordinate coordinate : Coordinate.values()) {
            ranges.put(coordinate, determineRange(first.getRange(coordinate), second.getRange(coordinate)));
        }
        return new Cuboid(ranges, !first.isOn());
    }

    private static Range determineRange(Range first, Range second) {
        return new Range(Math.max(first.getFrom(), second.getFrom()), Math.min(first.getTo(), second.getTo()));
    }

    private static List<Cuboid> removeDuplicates(List<Cuboid> cuboids) {
        Map<Cuboid, Integer> cuboidCount = new HashMap<>();
        for (Cuboid cuboid : cuboids) {
            if (!cuboidCount.containsKey(cuboid)) {
                cuboidCount.put(cuboid, 0);
            }
            if (cuboid.isOn()) {
                cuboidCount.put(cuboid, cuboidCount.get(cuboid) + 1);
            } else {
                cuboidCount.put(cuboid, cuboidCount.get(cuboid) - 1);
            }
        }

        List<Cuboid> results = new ArrayList<>();
        for (Map.Entry<Cuboid, Integer> entry : cuboidCount.entrySet()) {
            Cuboid basicCuboid = entry.getKey();
            int occurrences = 0;
            if (entry.getValue() > 0) {
                basicCuboid.setOn(true);
                occurrences = entry.getValue();
            }
            if (entry.getValue() < 0) {
                basicCuboid.setOn(false);
                occurrences = entry.getValue() * -1;
            }
            for (int i = 0; i < occurrences; i++) {
                results.add(basicCuboid);
            }
        }

        return results;
    }
}
