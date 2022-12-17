package AoC2022.Day16;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Room {

    private final String name;
    private final int flowRate;

    private final List<String> namesOfAdjacentRooms;

    private final List<Room> adjacentRooms;

    private final List<Path> pathsToOtherValves;

    public Room(String line) {
        this.name = StringUtils.substringBetween(line, "Valve ", " has");
        this.flowRate = Integer.parseInt(StringUtils.substringBetween(line, "=", ";"));
        String valves;
        if (line.contains("valves")) {
            valves = StringUtils.substringAfter(line, "tunnels lead to valves ");
        } else {
            valves = StringUtils.substringAfter(line, "tunnel leads to valve ");
        }
        namesOfAdjacentRooms = Arrays.asList(valves.split(", "));
        adjacentRooms = new ArrayList<>();
        pathsToOtherValves = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getFlowRate() {
        return flowRate;
    }

    public List<Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void assignRooms(Map<String, Room> roomMap) {
        namesOfAdjacentRooms.forEach(name -> adjacentRooms.add(roomMap.get(name)));
    }

    public List<Path> getPathsToOtherValves() {
        return pathsToOtherValves;
    }

    public void assignPathToValve(Path path) {
        pathsToOtherValves.add(path);
    }

    public boolean isWorthOpening() {
        return flowRate > 0;
    }

    @Override
    public String toString() {
        return name + "(" + flowRate + ")";
    }
}
