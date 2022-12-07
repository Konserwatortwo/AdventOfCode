package AoC2022.Day7;

import AoC2022.AdventTask;

import java.util.List;

public class Task7A extends AdventTask {

    public Task7A() {
        super("Day7", "Task7A");
    }

    @Override
    public List<String> perform(List<String> input) {
        Directory root = new Directory(null, "/");
        Directory currentDirectory = null;

        for (String line : input) {
            if (line.startsWith("$")) {
                String[] elements = line.split(" ");
                if (elements[1].equals("cd")) {
                    currentDirectory = switch (elements[2]) {
                        case "/" -> root;
                        case ".." -> currentDirectory.getParent();
                        default -> currentDirectory.getChildAsDirectory(elements[2]);
                    };
                }
            } else {
                Node.createNode(line, currentDirectory);
            }
        }

        Integer sum = root.getDirectoryChildren().stream()
                .filter(dir -> dir.getSize() < 100000)
                .mapToInt(Directory::getSize)
                .sum();
        return List.of(sum+"");
    }
}
