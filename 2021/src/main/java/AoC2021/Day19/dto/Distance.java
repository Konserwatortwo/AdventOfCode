package AoC2021.Day19.dto;

import AoC2021.Day19.enums.Coordinate;
import AoC2021.Day19.enums.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Distance {

    private final Beacon firstBeacon;
    private final Beacon secondBeacon;
    private Map<Coordinate, Integer> distances;

    public Distance(Beacon firstBeacon, Beacon secondBeacon) {
        this.firstBeacon = firstBeacon;
        this.secondBeacon = secondBeacon;
        this.distances = new HashMap<>();
        for (Coordinate coordinate : Coordinate.values()) {
            this.distances.put(coordinate, calculateDistance(coordinate));
        }
    }

    private int calculateDistance(Coordinate coordinate) {
        return Math.abs(firstBeacon.getCoordinate(coordinate) - secondBeacon.getCoordinate(coordinate));
    }

    public boolean compareInOrder(Distance otherDistance, Order order) {
        return compareDistancesForCoordinate(Coordinate.X, otherDistance, order)
                && compareDistancesForCoordinate(Coordinate.Y, otherDistance, order)
                && compareDistancesForCoordinate(Coordinate.Z, otherDistance, order);
    }

    private boolean compareDistancesForCoordinate(Coordinate coordinate, Distance otherDistance, Order order) {
        return Objects.equals(distances.get(coordinate), otherDistance.distances.get(order.getMappedCoordinate(coordinate)));
    }

    public List<Beacon> getBeacons() {
        return List.of(firstBeacon, secondBeacon);
    }

    public void normalize(Order order) {
        Map<Coordinate, Integer> newDistances = new HashMap<>();
        for (Coordinate coordinate : Coordinate.values()) {
            newDistances.put(coordinate, distances.get(order.getMappedCoordinate(coordinate)));
        }
        this.distances = newDistances;
    }
}
