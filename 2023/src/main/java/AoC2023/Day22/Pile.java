package AoC2023.Day22;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Pile {

    List<Brick> bricks;

    public static Pile of(List<String> input) {
        return new Pile(input.stream()
                .map(Brick::of)
                .collect(Collectors.toList()));
    }

    public void landBricks() {
        Map<Integer, List<Brick>> bricksForLevel = bricks.stream()
                .collect(Collectors.groupingBy(Brick::getLowestPoint));
        Map<Coordinates, Brick> landedBricks = new HashMap<>();
        List<Integer> levels = new ArrayList<>(bricksForLevel.keySet());
        Collections.sort(levels);
        for (Integer level : levels) {
            for (Brick brick : bricksForLevel.get(level)) {
                List<Coordinates> lowerCoordinates = brick.retrieveLowerCoordinates();
                while (lowerCoordinates.stream().noneMatch(coordinates ->
                        landedBricks.containsKey(coordinates) || coordinates.getZ() == 0)) {
                    brick.moveLower();
                    lowerCoordinates = brick.retrieveLowerCoordinates();
                }
                lowerCoordinates.stream()
                        .map(landedBricks::get)
                        .filter(Objects::nonNull)
                        .forEach(lowerBrick -> {
                            lowerBrick.addOnIt(brick);
                            brick.addBelowIt(lowerBrick);
                        });
                brick.getCoordinates().forEach(coordinates -> landedBricks.put(coordinates, brick));
            }
        }
    }

    public long countAbleToDestroy() {
        return bricks.stream().filter(Brick::isSafeToDestroy).count();
    }

    public long countChainReaction() {
        Map<Brick, Set<Brick>> blocksAbove = new HashMap<>();
        for (Brick brick : bricks) {
            retrieveAllBlocksAbove(brick, blocksAbove);
        }
        Map<Brick, Set<Brick>> blocksAboveWithoutOtherSupport = removeBlocksWithOtherSupport(blocksAbove);
        return blocksAboveWithoutOtherSupport.values().stream().mapToInt(x -> x.size() - 1).sum();
    }

    private Map<Brick, Set<Brick>> removeBlocksWithOtherSupport(Map<Brick, Set<Brick>> blocksAbove) {
        Map<Brick, Set<Brick>> blocksAboveWithoutOtherSupport = new HashMap<>();
        for (Brick brick : blocksAbove.keySet()) {
            Set<Brick> allAbove = new HashSet<>(blocksAbove.get(brick));
            Set<Brick> onItWithoutOtherSupport = new HashSet<>();
            allAbove.remove(brick);
            onItWithoutOtherSupport.add(brick);
            Map<Integer, List<Brick>> groupOnLevel = allAbove.stream()
                    .collect(Collectors.groupingBy(Brick::getLowestPoint));
            List<Integer> levels = new ArrayList<>(groupOnLevel.keySet());
            Collections.sort(levels);
            for (Integer level : levels) {
                for (Brick cachedBrick : groupOnLevel.get(level)) {
                    if (onItWithoutOtherSupport.containsAll(cachedBrick.getBelowIt())) {
                        onItWithoutOtherSupport.add(cachedBrick);
                    }
                }
            }
            blocksAboveWithoutOtherSupport.put(brick, onItWithoutOtherSupport);
        }
        return blocksAboveWithoutOtherSupport;
    }

    private Set<Brick> retrieveAllBlocksAbove(Brick brick, Map<Brick, Set<Brick>> cache) {
        if (!cache.containsKey(brick)) {
            Set<Brick> allBricksAbove = new HashSet<>();
            allBricksAbove.add(brick);
            brick.getOnIt().forEach(onIt -> allBricksAbove.addAll(retrieveAllBlocksAbove(onIt, cache)));
            cache.put(brick, allBricksAbove);
        }
        return cache.get(brick);
    }
}
