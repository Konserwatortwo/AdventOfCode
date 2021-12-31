package AoC2021.Day19;

import AoC2021.Day19.dto.Beacon;
import AoC2021.Day19.dto.Distance;
import AoC2021.Day19.dto.Scanner;
import AoC2021.Day19.enums.Coordinate;
import AoC2021.Day19.enums.Order;

import java.util.*;

public class PositionFinder {

    private final Scanner positionedScanner;
    private final Scanner developedScanner;
    private final List<Coordinate> changeSingForCoordinates;

    private Order detectedMostPossibleOrder;
    private Set<Pair<Beacon>> detectedSimilarBeacons;

    private PositionFinder(Scanner positionedScanner, Scanner developedScanner) {
        this.positionedScanner = positionedScanner;
        this.developedScanner = developedScanner;
        this.changeSingForCoordinates = new ArrayList<>();
    }

    public static boolean determineRelativePosition(Scanner positionedScanner, Scanner developedScanner) {
        PositionFinder positionFinder = new PositionFinder(positionedScanner, developedScanner);
        if (!positionFinder.foundedEnoughSimilarBeacons()) {
            return false;
        }
        positionFinder.determineBestPossiblePosition();
        positionFinder.normalizeScanner();
        return true;
    }

    private boolean foundedEnoughSimilarBeacons() {
        Map<Order, List<Pair<Distance>>> orderList = findScannersSimilarDistances();
        if (orderList.isEmpty()) {
            return false;
        }
        detectedMostPossibleOrder = Collections.max(orderList.entrySet(), Comparator.comparingInt(entry -> entry.getValue().size())).getKey();
        detectedSimilarBeacons = findScannersSimilarBeacons(orderList.get(detectedMostPossibleOrder));
        return detectedSimilarBeacons.size() > 11;
    }

    private Map<Order, List<Pair<Distance>>> findScannersSimilarDistances() {
        Map<Order, List<Pair<Distance>>> orderList = new HashMap<>();
        for (Order order : Order.values()) {
            for (Distance positionedDistance : positionedScanner.getDistances()) {
                for (Distance distance : developedScanner.getDistances()) {
                    if (positionedDistance.compareInOrder(distance, order)) {
                        orderList.computeIfAbsent(order, key -> new ArrayList<>()).add(new Pair<>(positionedDistance, distance));
                    }
                }
            }
        }
        return orderList;
    }

    private Set<Pair<Beacon>> findScannersSimilarBeacons(List<Pair<Distance>> pairDistances) {
        Map<Pair<Beacon>, Integer> countOccurrences = new HashMap<>();
        for (Pair<Distance> pairDistance : pairDistances) {
            for (Beacon first : pairDistance.getFirst().getBeacons()) {
                for (Beacon second : pairDistance.getSecond().getBeacons()) {
                    countOccurrences.merge(new Pair<>(first, second), 1, Integer::sum);
                }
            }
        }
        countOccurrences.values().removeAll(List.of(1));
        return countOccurrences.keySet();
    }

    private void determineBestPossiblePosition() {
        Map<Coordinate, Integer> bestPossibleCoordinates = new HashMap<>();
        for (Coordinate coordinate : Coordinate.values()) {
            Integer foundValue = determineBestPossiblePointForCoordinate(coordinate, -1);
            if (null == foundValue) {
                changeSingForCoordinates.add(coordinate);
                foundValue = determineBestPossiblePointForCoordinate(coordinate, 1);
            }
            bestPossibleCoordinates.put(coordinate, foundValue);
        }
        developedScanner.setPosition(bestPossibleCoordinates);
    }


    private Integer determineBestPossiblePointForCoordinate(Coordinate coordinate, int multiple) {
        List<Integer> possibleValues = new ArrayList<>();
        for (Pair<Beacon> similarBeacon : detectedSimilarBeacons) {
            possibleValues.add(similarBeacon.getFirst().getCoordinate(coordinate)
                    + multiple * similarBeacon.getSecond().getCoordinate(detectedMostPossibleOrder.getMappedCoordinate(coordinate)));
        }
        return checkIfAllValuesSame(possibleValues);
    }

    private static Integer checkIfAllValuesSame(List<Integer> possibleValue) {
        return !possibleValue.isEmpty() && Collections.frequency(possibleValue, possibleValue.get(0)) == possibleValue.size() ? possibleValue.get(0) : null;
    }

    private void normalizeScanner() {
        developedScanner.getDistances().forEach(distance -> distance.normalize(detectedMostPossibleOrder));
        developedScanner.getBeacons().forEach(this::normalizeBeacon);
    }

    private void normalizeBeacon(Beacon beaconToNormalize) {
        Map<Coordinate, Integer> normalizedCoordinates = new HashMap<>();
        for (Coordinate coordinate : Coordinate.values()) {
            int reverse = changeSingForCoordinates.contains(coordinate) ? -1 : 1;
            normalizedCoordinates.put(coordinate, developedScanner.getCoordinate(coordinate)
                    + reverse * beaconToNormalize.getCoordinate(detectedMostPossibleOrder.getMappedCoordinate(coordinate)));
        }
        beaconToNormalize.setPosition(normalizedCoordinates);
    }

    private static class Pair<T> {
        private final T first;
        private final T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?> pair = (Pair<?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
