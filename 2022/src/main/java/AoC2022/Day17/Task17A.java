package AoC2022.Day17;

import AoC2022.AdventTask;

import java.util.List;

public class Task17A extends AdventTask {

    public Task17A() {
        super("Day17", "Task17A");
    }

    @Override
    public List<String> perform(List<String> input) {
        TargetArea targetArea = new TargetArea(input.get(0));
        int highestPointAchieved = 0;
        int maxVelY = calculateNumberOfStepsToBeBetween(targetArea.getMaxY(), targetArea.getMinY());

        for (int velX = calculateNumberOfStepsToAchieve(targetArea.getMinX()); velX <= targetArea.getMaxX(); velX++) {
            for (int velY = targetArea.getMinY(); velY <= maxVelY; velY++) {
                Probe probe = new Probe(velX, velY);
                int highestProbePoint = 0;
                while (!targetArea.probeBeyondTargetArea(probe)) {
                    probe.calculateNextStep();
                    highestProbePoint = Math.max(highestProbePoint, probe.getY());
                    if (targetArea.probeInTargetArea(probe)) {
                        highestPointAchieved = Math.max(highestPointAchieved, highestProbePoint);
                        break;
                    }
                }
            }
        }
        return List.of(highestPointAchieved + "");
    }

    private int calculateNumberOfStepsToAchieve(int numberToAchieve) {
        int stepNumber = 0;
        int sum = 0;
        while (numberToAchieve > sum) {
            stepNumber++;
            sum += stepNumber;
        }
        return stepNumber;
    }

    private int calculateNumberOfStepsToBeBetween(int max, int min) {
        int stepNumber = 1000;
        int tempNumber;
        int sum = Integer.MIN_VALUE;

        while (sum < min) {
            stepNumber--;
            sum = 0;
            tempNumber = stepNumber;
            while (sum > max) {
                tempNumber--;
                sum += tempNumber;
            }
        }
        return stepNumber;
    }
}
