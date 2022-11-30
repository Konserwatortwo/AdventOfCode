package AoC2022.Day15;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task15B extends AdventTask {

    public static final int REPETITION_SIZE = 5;
    private Point[][] board;
    private int size;

    public Task15B() {
        super("Day15", "Task15B");
    }

    @Override
    public List<String> perform(List<String> input) {
        initializeData(input);
        discoverCostToAchievePoints();
        return List.of(board[0][0].getPreviousPointsCost() + "");
    }


    private void initializeData(List<String> input) {
        int initialSize = input.size();
        size = initialSize * REPETITION_SIZE;
        board = new Point[size][size];

        for (int k = 0; k < REPETITION_SIZE * 2; k++) {
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < 5 && j < REPETITION_SIZE) {
                    for (int y = 0; y < initialSize; y++) {
                        char[] line = input.get(y).toCharArray();
                        for (int x = 0; x < initialSize; x++) {
                            board[x + i * initialSize][y + j * initialSize] = new Point(line[x], k);
                        }
                    }
                }
            }
        }


        Point destination = board[--size][size];
        destination.process();
        destination.setCost(destination.getValue());
    }

    private void discoverCostToAchievePoints() {
        for (int k = size * 2; k >= 0; k--) {
            for (int y = 0; y <= k; y++) {
                int x = k - y;
                if (x <= size && y <= size) {
                    Point point = board[x][y];
                    if (!point.isProcessed()) {
                        point.process();
                        List<Point> pointsToAssignCost = new ArrayList<>();
                        if (x < size) {
                            pointsToAssignCost.add(board[x + 1][y]);
                        }
                        if (y < size) {
                            pointsToAssignCost.add(board[x][y + 1]);
                        }
                        point.assignCost(pointsToAssignCost);

                    }
                }
            }
        }
    }

    static class Point {
        private final int value;

        private int cost;
        private final List<Point> relatedPoints;
        private boolean processed;

        public Point(char value, int multiplier) {
            int tempValue = Integer.parseInt(value + "") + multiplier;
            if (tempValue > 9) {
                tempValue -= 9;
            }
            this.value = tempValue;
            this.relatedPoints = new ArrayList<>();
        }

        public boolean isProcessed() {
            return processed;
        }

        public void process() {
            this.processed = true;
        }

        public int getValue() {
            return value;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        public void addRelated(Point related) {
            this.relatedPoints.add(related);
        }

        public int getPreviousPointsCost() {
            return cost - value;
        }

        public void assignCost(List<Point> pointsToAssignCost) {
            int lowestCost = Integer.MAX_VALUE;
            Point relatedPoint = null;
            for (Point point : pointsToAssignCost) {
                if (point.getCost() < lowestCost) {
                    lowestCost = point.getCost();
                    relatedPoint = point;
                }
            }

            cost = lowestCost + getValue();
            relatedPoint.addRelated(this);

            for (Point point : pointsToAssignCost) {
                if (point.getPreviousPointsCost() > cost) {
                    point.changeCost(point.getPreviousPointsCost() - cost);
                }
            }
        }

        public void changeCost(int difference) {
            cost -= difference;
            relatedPoints.forEach(point -> point.changeCost(difference));
        }
    }
}
