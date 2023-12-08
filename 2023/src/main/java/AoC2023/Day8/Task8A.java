package AoC2023.Day8;

import AoC2023.AdventTask;
import AoC2023.AdventTaskUtils;

import java.util.Collection;
import java.util.List;

public class Task8A extends AdventTask {

    public Task8A() {
        super("Day8", "Task8A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Instruction instruction = new Instruction(input.get(0));
        Collection<Node> nodes = Node.createAndAssignNodes(input.subList(2, input.size()));
        Node currentNode = nodes.stream()
                .filter(x -> "AAA".equals(x.getName()))
                .findAny()
                .orElseThrow(IllegalStateException::new);
        int steps = 0;
        while (!"ZZZ".equals(currentNode.getName())) {
            steps++;
            currentNode = currentNode.choseNode(instruction.retrieveNextInstruction());
        }
        return AdventTaskUtils.answerAs(steps);
    }
}
