package AoC2022.Day16;

import java.util.Set;

public class Path implements Comparable<Path> {
    private final int value;
    private final Set<Room> rooms;

    public Path(int value, Set<Room> rooms) {
        this.value = value;
        this.rooms = rooms;
    }

    public int getValue() {
        return value;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public boolean containsSameRoom(Path other) {
        return other.getRooms().stream().noneMatch(rooms::contains);
    }

    @Override
    public int compareTo(Path other) {
        return value - other.value;
    }
}
