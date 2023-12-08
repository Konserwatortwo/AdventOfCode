package AoC2023.Day8;

import AoC2023.AdventTaskUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
class Node {

    final String name;
    final String leftName;
    final String rightName;
    Node left;
    Node right;

    private Node(String inputValue) {
        List<String> elements = AdventTaskUtils.splitOnSeparator(inputValue, null, "=", "(", ",", ")");
        this.name = elements.get(0);
        this.leftName = elements.get(1);
        this.rightName = elements.get(2);
    }

    public static Collection<Node> createAndAssignNodes(List<String> inputValue) {
        Map<String, Node> nodesMap = inputValue.stream()
                .map(Node::new)
                .collect(Collectors.toMap(Node::getName, Function.identity()));
        nodesMap.values().forEach(node -> node.assignNodes(nodesMap));
        return nodesMap.values();
    }

    private void assignNodes(Map<String, Node> nodesMap) {
        left = nodesMap.get(leftName);
        right = nodesMap.get(rightName);
    }

    public String getName() {
        return name;
    }

    public Node choseNode(char instruction) {
        if (instruction == 'L') {
            return left;
        }
        if (instruction == 'R') {
            return right;
        }
        throw new IllegalStateException("Wrong instruction");
    }

    public boolean isStartingNode() {
        return name.charAt(2) == 'A';
    }

    public boolean isEndingNode() {
        return name.charAt(2) == 'Z';
    }

    @Override
    public String toString() {
        return "Node{" + name + " = " + leftName + " - " + rightName + "}";
    }
}
