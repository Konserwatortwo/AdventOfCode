package AoC2023.Day16;

import AoC2023.shared.Direction;
import AoC2023.shared.Grid;
import AoC2023.shared.Position;

import java.util.*;
import java.util.stream.Collectors;

public class Contraption extends Grid {

    private Contraption(List<String> inputValue) {
        super(inputValue);
    }

    public static Contraption of(List<String> inputValue) {
        return new Contraption(inputValue);
    }

    public int checkEnergyLevel() {
        return enterLightAndCheckEnergyLevel(Beam.of(Position.of(0, 0), Direction.EAST));
    }

    public int findBestLightAngle() {
        int maxValue = 0;
        for (int x = 0; x < maxX; x++) {
            maxValue = Math.max(maxValue, enterLightAndCheckEnergyLevel(Beam.of(Position.of(x, 0), Direction.SOUTH)));
            maxValue = Math.max(maxValue, enterLightAndCheckEnergyLevel(Beam.of(Position.of(x, maxY - 1), Direction.NORTH)));
        }
        for (int y = 0; y < maxY; y++) {
            maxValue = Math.max(maxValue, enterLightAndCheckEnergyLevel(Beam.of(Position.of(0, y), Direction.EAST)));
            maxValue = Math.max(maxValue, enterLightAndCheckEnergyLevel(Beam.of(Position.of(maxX - 1, y), Direction.WEST)));
        }
        return maxValue;
    }

    private int enterLightAndCheckEnergyLevel(Beam startingBeam) {
        Set<Beam> energizedBeam = new HashSet<>();
        List<Beam> beams = new ArrayList<>();
        beams.add(startingBeam);
        while (!beams.isEmpty()) {
            energizedBeam.addAll(beams);
            beams = beams.stream()
                    .map(beam -> beam.moveToNextPosition(valueAt(beam.getPosition())))
                    .flatMap(Collection::stream)
                    .filter(beam -> isInGrid(beam.getPosition()))
                    .filter(beam -> !energizedBeam.contains(beam))
                    .collect(Collectors.toList());
        }
        return energizedBeam.stream()
                .map(Beam::getPosition)
                .collect(Collectors.toSet()).size();
    }
}
