package AoC2022.Day18;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Counter {

    public static int calculateTotalSurfaceArea(List<String> input) {
        Set<Coordinate> cubeCoordinates = parseCubes(input);
        return countEmptyNearbyCoordinates(cubeCoordinates);
    }

    private static Set<Coordinate> parseCubes(List<String> input) {
        return input.stream()
                .map(Coordinate::of)
                .collect(Collectors.toSet());
    }

    private static int countEmptyNearbyCoordinates(Set<Coordinate> cubeCoordinates) {
        return cubeCoordinates.stream()
                .mapToInt(coordinate -> (int) (6 - coordinate.retrieveNearby().stream()
                        .filter(cubeCoordinates::contains)
                        .count()))
                .sum();
    }

    public static int calculateExteriorSurfaceArea(List<String> input) {
        Set<Coordinate> cubeCoordinates = parseCubes(input);
        Set<Coordinate> emptyCoordinates = retrieveEmptyNearbyCoordinates(cubeCoordinates);
        Set<Coordinate> exteriorGroup = retrieveExteriorGroup(emptyCoordinates);
        return (int) countExteriorGroup(exteriorGroup, cubeCoordinates);
    }


    private static Set<Coordinate> retrieveEmptyNearbyCoordinates(Set<Coordinate> cubeCoordinates) {
        return cubeCoordinates.stream()
                .map(Coordinate::retrieveNearby)
                .flatMap(List::stream)
                .map(Coordinate::retrieveNearbyAndItself)
                .flatMap(List::stream)
                .filter(Predicate.not(cubeCoordinates::contains))
                .collect(Collectors.toSet());
    }

    public static Set<Coordinate> retrieveExteriorGroup(Set<Coordinate> emptyCoordinates) {
        Queue<Coordinate> queue = new LinkedList<>(emptyCoordinates);
        Set<Coordinate> exteriorGroup = new HashSet<>();
        while (!queue.isEmpty()) {
            Set<Coordinate> group = groupCoordinate(queue.remove(), queue);
            if (exteriorGroup.size() < group.size()) {
                exteriorGroup = group;
            }
        }
        return exteriorGroup;
    }

    private static Set<Coordinate> groupCoordinate(Coordinate coordinate, Queue<Coordinate> emptyCoordinates) {
        Set<Coordinate> coordinatesInGroup = new HashSet<>();
        coordinatesInGroup.add(coordinate);
        emptyCoordinates.remove(coordinate);
        for (Coordinate nearbyCoordinate : coordinate.retrieveNearby()) {
            if (emptyCoordinates.contains(nearbyCoordinate)) {
                coordinatesInGroup.addAll(groupCoordinate(nearbyCoordinate, emptyCoordinates));
            }
        }
        return coordinatesInGroup;
    }

    public static long countExteriorGroup(Set<Coordinate> exteriorGroup, Set<Coordinate> cubeCoordinates) {
        return exteriorGroup.stream()
                .map(Coordinate::retrieveNearby)
                .flatMap(List::stream)
                .filter(cubeCoordinates::contains)
                .count();
    }
}
