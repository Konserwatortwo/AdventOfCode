package AoC2022.Day19;

import java.util.*;
import java.util.stream.Collectors;

public class Factory {
    private static final int SWITCH_METHODOLOGY = 8;
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
            if (iterationLeft == SWITCH_METHODOLOGY) {
                System.out.println("SWITCH_METHODOLOGY");
            }
            if (iterationLeft <= SWITCH_METHODOLOGY) {
                runIterationByMemoryMethod(iterationLeft);
            } else {
                runIterationByCalculationMethod();
            }
            System.out.println("Iteration: " + (workingTime - iterationLeft) + " plans: " + plans.size() + " best: " + currentBestValue);
        }
        lastIteration();
    }

    private void runIterationByMemoryMethod(int iterationLeft) {
        List<Plan> nextIteration = new ArrayList<>();
        Set<String> existingKeys = new HashSet<>();
        int nextBestValue = currentBestValue;
        for (Plan plan : plans) {
            if (plan.canBeatCurrentBest(currentBestValue, iterationLeft)) {
                List<Plan> plansToAdd = runIterationForPlan(plan);

                nextBestValue = Math.max(nextBestValue, plan.retrieveNumberOfGeode());
                for (Plan planToAdd : plansToAdd) {
                    String planKey = planToAdd.retrieveFullKey();
                    if (!existingKeys.contains(planKey)) {
                        existingKeys.add(planKey);
                        nextIteration.add(planToAdd);
                    }
                }
            }
        }
        plans = nextIteration;
        currentBestValue = nextBestValue;
    }

    private void runIterationByCalculationMethod() {
        HashMap<String, List<Plan>> cacheRobotsMap = new HashMap<>();
        for (Plan plan : plans) {
            List<Plan> plansToAdd = runIterationForPlan(plan);

            for (Plan planToAdd : plansToAdd) {
                checkCache(planToAdd, cacheRobotsMap);
            }
        }
        plans = cacheRobotsMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private void checkCache(Plan planToAdd, HashMap<String, List<Plan>> cacheRobotsMap) {
        String planKey = planToAdd.retrieveRobotKey();
        if (cacheRobotsMap.containsKey(planKey)) {
            List<Plan> betterPlans = new ArrayList<>(cacheRobotsMap.get(planKey));
            betterPlans.stream()
                    .filter(planToAdd::haveBetterStorage)
                    .forEach(betterPlan -> cacheRobotsMap.get(planKey).remove(betterPlan));
            if (cacheRobotsMap.get(planKey).stream().noneMatch(betterPlan -> betterPlan.haveBetterStorage(planToAdd))) {
                cacheRobotsMap.get(planKey).add(planToAdd);
            }
        } else {
            cacheRobotsMap.put(planKey, new ArrayList<>());
            cacheRobotsMap.get(planKey).add(planToAdd);
        }
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
