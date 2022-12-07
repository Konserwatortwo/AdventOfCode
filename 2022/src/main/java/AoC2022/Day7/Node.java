package AoC2022.Day7;

import java.util.Objects;

public abstract class Node {

    private final Directory parent;

    private final String name;

    public Node(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();

    public static Node createNode(String line, Directory parent) {
        Node createdNode;
        String[] elements = line.split(" ");

        if (Objects.equals(elements[0], "dir")) {
            createdNode = new Directory(parent, elements[1]);
        } else {
            createdNode = new File(parent, elements[1], Integer.parseInt(elements[0]));
        }

        return createdNode;
    }
}
