package AoC2022.Day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Plan {
    private final Map<Type, Integer> storage;
    private final Map<Type, Integer> robots;

    private Type robotToBuild;

    private Cost costOfRobotToBuild;

    public Plan() {
        this.storage = new HashMap<>();
        this.robots = new HashMap<>();
        for (Type type : Type.values()) {
            this.storage.put(type, 0);
            this.robots.put(type, 0);
        }
        robots.put(Type.ORE, robots.get(Type.ORE) + 1);
    }

    public Plan(Plan createdFrom, Type robotToBuild, Cost costOfRobotToBuild) {
        this.storage = new HashMap<>(createdFrom.storage);
        this.robots = new HashMap<>(createdFrom.robots);
        this.robotToBuild = robotToBuild;
        this.costOfRobotToBuild = costOfRobotToBuild;
    }

    public void gatherResources() {
        for (Type type : Type.values()) {
            storage.put(type, storage.get(type) + robots.get(type));
        }
    }

    public boolean canBuildPlanedRobot() {
        return costOfRobotToBuild.getComponents().entrySet().stream()
                .allMatch(entry -> storage.get(entry.getKey()) >= entry.getValue());
    }

    public void buildPlanedRobot() {
        costOfRobotToBuild.getComponents().forEach(this::subtractNumberOfMinerals);
        robots.put(robotToBuild, robots.get(robotToBuild) + 1);
    }

    private void subtractNumberOfMinerals(Type typeOfRMineral, int subtract) {
        storage.put(typeOfRMineral, storage.get(typeOfRMineral) - subtract);
    }

    public int retrieveNumberOfGeode() {
        return storage.get(Type.GEODE);
    }

    public int numberOfRobots(Type robotType) {
        return robots.get(robotType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(storage, plan.storage)
                && Objects.equals(robots, plan.robots)
                && robotToBuild == plan.robotToBuild
                && Objects.equals(costOfRobotToBuild, plan.costOfRobotToBuild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage, robots, robotToBuild, costOfRobotToBuild);
    }
}
