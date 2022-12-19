package AoC2022.Day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factory {
    private static final int PRECISION = 10;
    private final Blueprint blueprint;
    private final int workingTime;

    private List<Plan> plans;
    private int currentBestValue;

    public Factory(Blueprint blueprint, int workingTime) {
        this.blueprint = blueprint;
        this.workingTime = workingTime;
        this.plans = new ArrayList<>();
    }

    public int retrieveBestPlanValue() {
        return currentBestValue;
    }

    public void run() {
        plans.addAll(createNewPlans());
        for (int i = workingTime; i > 1; i--) {
            runIteration(i);
        }
        lastIteration();
    }

    private List<Plan> createNewPlans() {
        return createNewPlans(new Plan(), Type.values());
    }

    private List<Plan> createNewPlans(Plan createdFrom, Type... types) {
        return Arrays.stream(types)
                .filter(type -> createdFrom.numberOfRobots(type) < blueprint.retrieveMaxRobotPossible(type))
                .map(type -> new Plan(createdFrom, type, blueprint.getRobotCost(type)))
                .collect(Collectors.toList());
    }

    private void runIteration(int iterationLeft) {
        List<Plan> nextIteration = new ArrayList<>();
        for (Plan plan : plans) {
            boolean canBuildRobot = plan.canBuildPlanedRobot();
            plan.gatherResources();

            if (currentBestValue < plan.retrieveNumberOfGeode()) {
                currentBestValue = plan.retrieveNumberOfGeode();
            }

            if (canBuildRobot) {
                plan.buildPlanedRobot();
                if (iterationLeft < PRECISION) {
                    nextIteration.addAll(createNewPlans(plan, Type.OBSIDIAN, Type.GEODE));
                } else {
                    nextIteration.addAll(createNewPlans(plan, Type.values()));
                }
            } else {
                nextIteration.add(plan);
            }
        }
        plans = nextIteration;
    }

    private void lastIteration() {
        for (Plan plan : plans) {
            plan.gatherResources();
            if (currentBestValue < plan.retrieveNumberOfGeode()) {
                currentBestValue = plan.retrieveNumberOfGeode();
            }
        }
    }
}
