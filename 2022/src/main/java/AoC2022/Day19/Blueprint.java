package AoC2022.Day19;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Blueprint {
    private final Integer id;
    private final Map<Type, Cost> robotCost;

    public Blueprint(String line) {
        this.id = Integer.parseInt(StringUtils.substringBetween(line, "Blueprint ", ":"));
        String[] elements = StringUtils.substringAfter(line, ":").split("\\.");
        this.robotCost = new HashMap<>();
        this.robotCost.put(Type.ORE, new Cost(StringUtils.substringBetween(elements[0], "costs ", " ore")));
        this.robotCost.put(Type.CLAY, new Cost(StringUtils.substringBetween(elements[1], "costs ", " ore")));
        this.robotCost.put(Type.OBSIDIAN, new Cost(StringUtils.substringBetween(elements[2], "costs ", " ore")));
        this.robotCost.get(Type.OBSIDIAN).addComponent(Type.CLAY, StringUtils.substringBetween(elements[2], "and ", " clay"));
        this.robotCost.put(Type.GEODE, new Cost(StringUtils.substringBetween(elements[3], "costs ", " ore")));
        this.robotCost.get(Type.GEODE).addComponent(Type.OBSIDIAN, StringUtils.substringBetween(elements[3], "and ", " obsidian"));
    }

    public Integer getId() {
        return id;
    }

    public Cost getRobotCost(Type robotType) {
        return robotCost.get(robotType);
    }

    public int retrieveMaxRobotPossible(Type type) {
        return robotCost.values().stream()
                .filter(cost -> cost.containsComponent(type))
                .mapToInt(cost -> cost.getComponent(type))
                .max()
                .orElse(Integer.MAX_VALUE);
    }
}
