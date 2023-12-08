package AoC2023.Day8;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
class Journey {

    int nextPointer;
    @Getter
    long distance;
    final List<Integer> cyclesDistances;

    public Journey(int achievedCyclePointer, List<Integer> distances) {
        this.nextPointer = 0;
        this.distance = distances.subList(0, achievedCyclePointer).stream()
                .mapToInt(x -> x)
                .sum();
        this.cyclesDistances = distances.subList(achievedCyclePointer, distances.size());
    }

    public static Journey of(Node startingNode, Instruction instruction) {
        List<String> keys = new ArrayList<>();
        List<Integer> distancesToEndNodes = new ArrayList<>();
        int achievedCyclePointer = -1;
        Node currentNode = startingNode;
        while (achievedCyclePointer == -1) {
            Tuple2<Node, Integer> result = moveToNextEndNode(currentNode, instruction);
            currentNode = result._1;
            String key = currentNode.getName() + "-" + instruction.getNextPointer();
            if (keys.contains(key)) {
                achievedCyclePointer = keys.indexOf(key);
            } else {
                keys.add(key);
                distancesToEndNodes.add(result._2);
            }
        }
        return new Journey(achievedCyclePointer, distancesToEndNodes);
    }

    private static Tuple2<Node, Integer> moveToNextEndNode(Node currentNode, Instruction instruction) {
        int steps = 0;
        do {
            steps++;
            currentNode = currentNode.choseNode(instruction.retrieveNextInstruction());
        } while (!currentNode.isEndingNode());
        return Tuple.of(currentNode, steps);
    }

    public long calculateDistanceToNextEndNode() {
        if (nextPointer == cyclesDistances.size()) {
            nextPointer = 0;
        }
        distance += cyclesDistances.get(nextPointer++);
        return distance;
    }
}
