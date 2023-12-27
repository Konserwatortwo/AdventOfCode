package AoC2023.Day23;

import AoC2023.shared.Direction;
import AoC2023.shared.Grid;
import AoC2023.shared.Position;
import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.util.*;
import java.util.stream.Collectors;

class Forest extends Grid {

    private static final Map<Character, Direction> ALLOWED_MOVES = Map.of(
            '^', Direction.NORTH,
            'v', Direction.SOUTH,
            '<', Direction.WEST,
            '>', Direction.EAST
    );

    private final List<Node> nodes;

    public static Forest of(List<String> inputValue) {
        return new Forest(inputValue);
    }

    private Forest(List<String> inputValue) {
        super(inputValue);
        this.nodes = findNodes();
    }

    private List<Node> findNodes() {
        Set<Position> startingPositions = new HashSet<>();
        startingPositions.add(Position.of(1, 0));
        Set<Position> visitedPositions = new HashSet<>();
        visitedPositions.add(Position.of(maxX - 2, maxY - 1));
        List<Node> nodes = new ArrayList<>();
        while (!startingPositions.isEmpty()) {
            startingPositions = startingPositions.stream()
                    .map(this::findNode)
                    .filter(nodes::add)
                    .map(Node::getLast)
                    .filter(visitedPositions::add)
                    .map(this::handleCrossroads)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        }
        return nodes;
    }

    private Node findNode(Position startingPosition) {
        Position first = Optional.ofNullable(ALLOWED_MOVES.get(valueAt(startingPosition)))
                .map(Direction::opposite)
                .map(x -> x.determineNextPosition(startingPosition))
                .orElse(startingPosition);
        Set<Position> visitedPositions = new HashSet<>();
        visitedPositions.add(first);
        visitedPositions.add(startingPosition);
        Position currentPosition = startingPosition;
        do {
            currentPosition = currentPosition.nearbyPositions()
                    .stream()
                    .filter(this::isInGrid)
                    .filter(position -> valueAt(position) != '#')
                    .filter(visitedPositions::add)
                    .findFirst()
                    .orElseThrow();
        } while (valueAt(currentPosition) == '.' && !Position.of(maxX - 2, maxY - 1).equals(currentPosition));
        Position previousPosition = currentPosition;
        Position last = Optional.ofNullable(ALLOWED_MOVES.get(valueAt(previousPosition)))
                .map(x -> x.determineNextPosition(previousPosition))
                .orElse(previousPosition);
        return Node.of(first, last, visitedPositions.size());
    }

    private List<Position> handleCrossroads(Position endingPosition) {
        return ALLOWED_MOVES.entrySet().stream()
                .map(entry -> Tuple.of(entry.getKey(), entry.getValue().determineNextPosition(endingPosition)))
                .filter(tuple -> tuple._1 == valueAt(tuple._2))
                .map(Tuple2::_2)
                .collect(Collectors.toList());
    }

    public int findLongestDirectionalRoute() {
        return findLongestRoute(
                Position.of(1, 0),
                new HashSet<>(),
                nodes.stream().collect(Collectors.groupingBy(Node::getFirst))
        );
    }

    public int findLongestBiDirectionalRoute() {
        return findLongestRoute(Position.of(1, 0), new HashSet<>(), createBiDirectionalMap());
    }

    private Map<Position, List<Node>> createBiDirectionalMap() {
        Set<Position> edgePositions = nodes.stream()
                .map(Node::getFirst)
                .collect(Collectors.toSet());
        Map<Position, List<Node>> result = new HashMap<>();
        for (Position edgePosition : edgePositions) {
            List<Node> positionNodes = nodes.stream()
                    .filter(node -> node.getFirst().equals(edgePosition))
                    .collect(Collectors.toList());
            positionNodes.addAll(nodes.stream()
                    .filter(node -> node.getLast().equals(edgePosition))
                    .toList());
            result.put(edgePosition, positionNodes);
        }
        return result;
    }

    private int findLongestRoute(
            Position currentPosition,
            Set<Position> visitedPositions,
            Map<Position, List<Node>> nodesMap
    ) {
        if (Position.of(maxX - 2, maxY - 1).equals(currentPosition)) {
            return -1;
        }
        int longestRoute = 0;
        for (Node node : nodesMap.get(currentPosition).stream().toList()) {
            Position nextPosition = node.getOtherPosition(currentPosition);
            if (!visitedPositions.contains(nextPosition)) {
                visitedPositions.add(nextPosition);
                longestRoute = Math.max(longestRoute, node.getSize() + findLongestRoute(nextPosition, visitedPositions, nodesMap));
                visitedPositions.remove(nextPosition);
            }
        }
        return longestRoute;
    }
}
