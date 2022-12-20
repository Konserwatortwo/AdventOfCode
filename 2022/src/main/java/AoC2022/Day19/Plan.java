package AoC2022.Day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Plan {
    private final Blueprint blueprint;
    private final Map<Type, Integer> storage;
    private final Map<Type, Integer> robots;

    private final Type planedRobotType;

    private List<String> journal;

    public Plan(Blueprint blueprint) {
        this.blueprint = blueprint;
        this.storage = new HashMap<>();
        this.robots = new HashMap<>();
        for (Type type : Type.values()) {
            this.storage.put(type, 0);
            this.robots.put(type, 0);
        }
        addRobot(Type.ORE);
        this.planedRobotType = null;
        journal = new ArrayList<>();
    }

    public Plan(Plan createdFrom, Type planedRobotType) {
        this.blueprint = createdFrom.blueprint;
        this.storage = new HashMap<>(createdFrom.storage);
        this.robots = new HashMap<>(createdFrom.robots);
        this.planedRobotType = planedRobotType;
        journal = new ArrayList<>(createdFrom.journal);
    }

    public void gatherResources() {
        journal.add(retrieveFullKey());
        for (Type type : Type.values()) {
            storage.put(type, storage.get(type) + robots.get(type));
        }
    }

    public boolean canBuildPlanedRobot() {
        return blueprint.getRobotCost(planedRobotType).getComponents().entrySet().stream()
                .allMatch(entry -> storage.get(entry.getKey()) >= entry.getValue());
    }

    public void buildPlanedRobot() {
        blueprint.getRobotCost(planedRobotType).getComponents()
                .forEach(this::subtractMineralsToBuildRobot);
        addRobot(planedRobotType);
    }

    private void subtractMineralsToBuildRobot(Type typeOfRMineral, int subtract) {
        storage.put(typeOfRMineral, storage.get(typeOfRMineral) - subtract);
    }

    private void addRobot(Type robotType) {
        robots.put(robotType, robots.get(robotType) + 1);
    }

    public List<Type> retrievePossibleRobotTypes() {
        List<Type> types = Stream.of(Type.ORE, Type.CLAY)
                .filter(this::canPlanRobot)
                .collect(Collectors.toList());

        if (containsRobot(Type.CLAY) && canPlanRobot(Type.OBSIDIAN)) {
            types.add(Type.OBSIDIAN);
        }
        if (containsRobot(Type.OBSIDIAN)) {
            types.add(Type.GEODE);
        }
        return types;
    }

    private boolean canPlanRobot(Type robotType) {
        return robots.get(robotType) < blueprint.retrieveMaxRobotPossible(robotType);
    }

    private boolean containsRobot(Type robotType) {
        return robots.get(robotType) > 0;
    }

    public int retrieveNumberOfGeode() {
        return storage.get(Type.GEODE);
    }

    public String retrieveFullKey() {
        return retrieveRobotKey() + ":" + storage;
    }

    public String retrieveRobotKey() {
        return robots + "-" + planedRobotType;
    }

    public boolean haveBetterStorage(Plan other) {
        return Stream.of(Type.values()).allMatch(type -> storage.get(type) >= other.storage.get(type));
    }
}
