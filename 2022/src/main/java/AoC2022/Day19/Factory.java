package AoC2022.Day19;

import java.util.*;
import java.util.stream.Collectors;

public class Factory {
    private static final int SWITCH_METHODOLOGY = 8; // 8 OK 7 NOT
    private final int workingTime;
    private List<Plan> plans;
    private int currentBestValue;

    public Factory(Blueprint blueprint, int workingTime) {
        this.workingTime = workingTime;
        this.plans = new ArrayList<>();
        this.plans.addAll(createNewPlans(new Plan(blueprint)));
    }

    public int retrieveBestPlanValue() {
        return currentBestValue;
    }

    public void run() {
        for (int iterationLeft = workingTime; iterationLeft > 1; iterationLeft--) {
            System.out.println("Iteration: " + (workingTime - iterationLeft) + " plans: " + plans.size() + " best: " + currentBestValue);
            if(iterationLeft == SWITCH_METHODOLOGY) {
                System.out.println("SWITCH_METHODOLOGY");
            }


            if (iterationLeft < SWITCH_METHODOLOGY) {
                runIterationByMemoryMethod();
            } else {
                runIterationByCalculationMethod();
            }
        }
        lastIteration();
    }

    private void runIterationByMemoryMethod() {
        List<Plan> nextIteration = new ArrayList<>();
        Set<String> existingKeys = new HashSet<>();
        for (Plan plan : plans) {
            List<Plan> plansToAdd = runIterationForPlan(plan);

            if (currentBestValue < plan.retrieveNumberOfGeode()) {
                currentBestValue = plan.retrieveNumberOfGeode();
            }

            for (Plan planToAdd : plansToAdd) {
                String planKey = planToAdd.retrieveFullKey();
                if (!existingKeys.contains(planKey)) {
                    existingKeys.add(planKey);
                    nextIteration.add(planToAdd);
                }
            }
        }
        plans = nextIteration;
    }

    private void runIterationByCalculationMethod() {
        HashMap<String, List<Plan>> robotsMap = new HashMap<>();

        for (Plan plan : plans) {
            List<Plan> plansToAdd = runIterationForPlan(plan);
            for (Plan planToAdd : plansToAdd) {
                String planKey = planToAdd.retrieveRobotKey();
                if (robotsMap.containsKey(planKey)) {
                    List<Plan> betterPlans = new ArrayList<>(robotsMap.get(planKey));
                    betterPlans.stream()
                            .filter(planToAdd::haveBetterStorage)
                            .forEach(betterPlan -> robotsMap.get(planKey).remove(betterPlan));
                    if (betterPlans.stream().noneMatch(betterPlan -> betterPlan.haveBetterStorage(planToAdd))) {
                        robotsMap.get(planKey).add(planToAdd);
                    }
                } else {
                    robotsMap.put(planKey, new ArrayList<>());
                    robotsMap.get(planKey).add(planToAdd);
                }
            }
        }
        plans = robotsMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<Plan> runIterationForPlan(Plan plan) {
        boolean canBuildRobot = plan.canBuildPlanedRobot();
        plan.gatherResources();
        if (canBuildRobot) {
            plan.buildPlanedRobot();
            return createNewPlans(plan);
        }
        return List.of(plan);
    }

    private List<Plan> createNewPlans(Plan plan) {
        return plan.retrievePossibleRobotTypes().stream()
                .map(type -> new Plan(plan, type))
                .collect(Collectors.toList());
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
