package AoC2021.Day19.dto;

import java.util.ArrayList;
import java.util.List;

public class Scanner extends Position {

    private final String name;
    private final List<Beacon> beacons;
    private final List<Distance> distances;

    public Scanner(List<String> input) {
        this.name = input.get(0).replace("-", "").trim();
        this.beacons = new ArrayList<>();
        for (int i = 1, inputSize = input.size(); i < inputSize; i++) {
            beacons.add(new Beacon(input.get(i)));
        }

        distances = new ArrayList<>();
        for (int i = 0, beaconsSize = beacons.size(); i < beaconsSize - 1; i++) {
            for (int j = i + 1; j < beaconsSize; j++) {
                distances.add(new Distance(beacons.get(i), beacons.get(j)));
            }
        }
    }

    @Override
    public String toString() {
        return name + " " + super.toString();
    }

    public List<Beacon> getBeacons() {
        return beacons;
    }

    public List<Distance> getDistances() {
        return distances;
    }
}
