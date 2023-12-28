package AoC2023.Day22;

import AoC2023.AdventTaskUtils;
import AoC2023.shared.Coordinates;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Brick {

    private static int id = 1;

    int name;
    @NonFinal
    List<Coordinates> coordinates;
    Set<Brick> onIt;
    Set<Brick> belowIt;

    public Brick(List<Coordinates> coordinates) {
        this.name = id++;
        this.coordinates = coordinates;
        this.onIt = new HashSet<>();
        this.belowIt = new HashSet<>();
    }

    public static Brick of(String input) {
        List<String> elements = AdventTaskUtils.splitOnSeparator(input, "~");
        List<Integer> from = AdventTaskUtils.splitAndParseToInt(elements.get(0), ",");
        List<Integer> to = AdventTaskUtils.splitAndParseToInt(elements.get(1), ",");
        List<Coordinates> coordinates = new ArrayList<>();
        for (int x = Math.min(from.get(0), to.get(0)); x <= Math.max(from.get(0), to.get(0)); x++) {
            for (int y = Math.min(from.get(1), to.get(1)); y <= Math.max(from.get(1), to.get(1)); y++) {
                for (int z = Math.min(from.get(2), to.get(2)); z <= Math.max(from.get(2), to.get(2)); z++) {
                    coordinates.add(Coordinates.of(x, y, z));
                }
            }
        }
        return new Brick(coordinates);
    }

    public int getLowestPoint() {
        return coordinates.stream()
                .mapToLong(Coordinates::getZ)
                .mapToInt(x -> (int) x)
                .min()
                .orElseThrow();
    }

    public List<Coordinates> retrieveLowerCoordinates() {
        return coordinates.stream()
                .map(coordinates -> Coordinates.of(coordinates.getX(), coordinates.getY(), coordinates.getZ() - 1))
                .collect(Collectors.toList());
    }

    public void moveLower() {
        coordinates = retrieveLowerCoordinates();
    }

    public void addOnIt(Brick brickOn) {
        this.onIt.add(brickOn);
    }

    public void addBelowIt(Brick brickBelow) {
        this.belowIt.add(brickBelow);
    }

    public boolean isSafeToDestroy() {
        return onIt.isEmpty() || onIt.stream().allMatch(onIt -> onIt.getBelowIt().size() > 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brick brick = (Brick) o;
        return Objects.equals(name, brick.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
