package AoC2023.Day23;

import AoC2023.shared.Grid;
import AoC2023.shared.Position;

import java.util.*;
import java.util.stream.Collectors;

public class Forest extends Grid {


    private Forest(List<String> inputValue) {
        super(inputValue);
    }

    public static Forest of(List<String> inputValue) {
        return new Forest(inputValue);
    }

    public long findLongestRoute() {
        long longestRoute = 0;
        Position finalPosition = Position.of(maxX - 2, maxY - 1);
        Set<Journey> activeJourneys = new HashSet<>();
        activeJourneys.add(Journey.of());

        while (!activeJourneys.isEmpty()) {
            activeJourneys = activeJourneys.stream()
                    .map(journey -> journey.retrieveNextJourneys(valueAt(journey.getCurrentPosition())))
                    .flatMap(Collection::stream)
                    .filter(journey -> isInGrid(journey.getCurrentPosition()))
                    .filter(journey -> valueAt(journey.getCurrentPosition()) != '#')
                    .collect(Collectors.toSet());
            Set<Journey> finishedJourneys = activeJourneys.stream()
                    .filter(journey -> journey.getCurrentPosition().equals(finalPosition))
                    .collect(Collectors.toSet());
            OptionalInt longestRouteInIteration = finishedJourneys.stream()
                    .mapToInt(journey -> journey.getVisitedPositions().size())
                    .max();
            if (longestRouteInIteration.isPresent()) {
                System.out.println(longestRouteInIteration);
                longestRoute = Math.max(longestRoute, longestRouteInIteration.getAsInt());
            }
            activeJourneys.removeAll(finishedJourneys);
        }

        return longestRoute;
    }

}
