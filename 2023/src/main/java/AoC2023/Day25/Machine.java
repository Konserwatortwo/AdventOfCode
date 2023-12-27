package AoC2023.Day25;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

import static AoC2023.AdventTaskUtils.splitOnSeparator;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Machine {

    List<String> nodes;
    List<Tuple2<String, String>> edges;

    public static Machine of(List<String> inputs) {
        Set<String> nodes = new HashSet<>();
        List<Tuple2<String, String>> edges = new ArrayList<>();
        for (String input : inputs) {
            List<String> elements = splitOnSeparator(input, " ", ":");
            nodes.add(elements.get(0));
            for (int i = 1; i < elements.size(); i++) {
                nodes.add(elements.get(i));
                edges.add(Tuple.of(elements.get(0), elements.get(i)));
            }
        }
        return new Machine(new ArrayList<>(nodes), edges);
    }

    public int findThreeSeparators() {
        Map<Tuple2<String, String>, Integer> connectionCounter = new HashMap<>();
        for (String node : nodes.stream().limit(50L).toList()) {
            findAllConnectionsFromNode(node).forEach(connection ->
                    connectionCounter.put(connection, connectionCounter.getOrDefault(connection, 0) + 1)
            );
        }
        connectionCounter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .skip(connectionCounter.size() - 4)
                .forEach(edges::remove);

        int size = findConnectionsFromNode();
        System.out.println(size * (nodes.size() - size));
        return size * (nodes.size() - size);
    }

    private Set<Tuple2<String, String>> findAllConnectionsFromNode(String node) {
        Set<Tuple2<String, String>> result = new HashSet<>();
        Set<String> visitedNodes = new HashSet<>();
        Set<String> connectedNodes = new HashSet<>();
        visitedNodes.add(node);
        connectedNodes.add(node);
        while (!visitedNodes.containsAll(nodes)) {
            Set<String> nextNodes = new HashSet<>();
            for (String connectedNode : connectedNodes) {
                edges.stream()
                        .filter(edge -> edge._1.equals(connectedNode))
                        .filter(edge -> !visitedNodes.contains(edge._2))
                        .filter(result::add)
                        .forEach(connected -> nextNodes.add(connected._2));
                edges.stream()
                        .filter(edge -> edge._2.equals(connectedNode))
                        .filter(edge -> !visitedNodes.contains(edge._1))
                        .filter(result::add)
                        .forEach(connected -> nextNodes.add(connected._1));
            }
            visitedNodes.addAll(nextNodes);
            connectedNodes = nextNodes;
        }
        return result;
    }

    private int findConnectionsFromNode() {
        Set<String> visitedNodes = new HashSet<>();
        Set<String> connectedNodes = new HashSet<>();
        visitedNodes.add(nodes.get(0));
        connectedNodes.add(nodes.get(0));
        while (!connectedNodes.isEmpty()) {
            connectedNodes = connectedNodes.stream()
                    .map(this::findConnectedNodes)
                    .flatMap(Collection::stream)
                    .filter(visitedNodes::add)
                    .collect(Collectors.toSet());
        }
        return visitedNodes.size();
    }

    private Set<String> findConnectedNodes(String node) {
        Set<String> connectedNodes = new HashSet<>();
        for (Tuple2<String, String> edge : edges) {
            if (edge._1.equals(node)) {
                connectedNodes.add(edge._2);
            } else if (edge._2.equals(node)) {
                connectedNodes.add(edge._1);
            }
        }
        return connectedNodes;
    }
}
