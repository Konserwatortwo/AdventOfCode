package AoC2022.Day7;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Node {

    private final List<Node> children;

    public Directory(Directory parent, String name) {
        super(parent, name);
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public Directory getChildAsDirectory(String line) {
        return children.stream()
                .filter(children -> children.getName().equals(line))
                .map(node -> (Directory) node)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Directory> getDirectoryChildren() {
        List<Directory> result = new ArrayList<>();
        result.add(this);
        children.stream()
                .filter(node -> node instanceof Directory)
                .map(node -> (Directory) node)
                .forEach(dir -> result.addAll(dir.getDirectoryChildren()));
        return result;
    }

    @Override
    public int getSize() {
        return children.stream().mapToInt(Node::getSize).sum();
    }
}
