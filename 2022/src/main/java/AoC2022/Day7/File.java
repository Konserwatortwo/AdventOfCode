package AoC2022.Day7;

public class File extends Node {

    private final int size;

    public File(Directory parent, String name, int size) {
        super(parent, name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
