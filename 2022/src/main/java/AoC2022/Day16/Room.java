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
    private final List<Cost> costToOtherValves;

    public Room(String line) {
        this.name = StringUtils.substringBetween(line, "Valve ", " has");
        this.flowRate = Integer.parseInt(StringUtils.substringBetween(line, "=", ";"));
        String valves;
        if (line.contains("valves")) {
            valves = StringUtils.substringAfter(line, "tunnels lead to valves ");
        } else {
            valves = StringUtils.substringAfter(line, "tunnel leads to valve ");
        }
        this.namesOfAdjacentRooms = Arrays.asList(valves.split(", "));
        this.adjacentRooms = new ArrayList<>();
        this.costToOtherValves = new ArrayList<>();
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

    public List<Cost> getCostsToOtherValves() {
        return costToOtherValves;
    }

    public void assignCostToValve(Cost cost) {
        costToOtherValves.add(cost);
    }

    public boolean isWorthOpening() {
        return flowRate > 0;
    }
}
