package AoC2023.Day8;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task8B extends AdventTask {

    public Task8B() {
        super("Day8", "Task8B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Instruction instruction = new Instruction(input.get(0));
        Collection<Node> nodes = Node.createAndAssignNodes(input.subList(2, input.size()));
        List<Journey> journeys = nodes.stream()
                .filter(Node::isStartingNode)
                .map(x -> Journey.of(x, instruction))
                .collect(Collectors.toList());
        long longestDistance = journeys.get(0).calculateDistanceToNextEndNode();
        do {
            for (Journey journey : journeys) {
                while (longestDistance > journey.getDistance()) {
                    journey.calculateDistanceToNextEndNode();
                }
                longestDistance = Math.max(longestDistance, journey.getDistance());
            }
        } while (longestDistance != journeys.get(0).getDistance());
        return AdventTaskUtils.answerAs(longestDistance);
    }
}
