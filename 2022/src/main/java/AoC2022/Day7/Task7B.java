package AoC2022.Day7;

import AoC2022.AdventTask;

import java.util.List;

public class Task7B extends AdventTask {

    private static final Integer TOTAL_SPACE = 70000000;
    private static final Integer SPACE_REQUIRED = 30000000;

    public Task7B() {
        super("Day7", "Task7B");
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

        int freeSpace = TOTAL_SPACE - root.getSize();
        int spaceNeeded = SPACE_REQUIRED - freeSpace;

        Integer sum = root.getDirectoryChildren().stream()
                .filter(dir -> dir.getSize() >= spaceNeeded)
                .mapToInt(Directory::getSize)
                .min()
                .orElseThrow(IllegalArgumentException::new);
        return List.of(sum+"");
    }
}

