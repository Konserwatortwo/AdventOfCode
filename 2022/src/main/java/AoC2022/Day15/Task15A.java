package AoC2022.Day15;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;

public class Task15A extends AdventTask {

    private Point[][] board;
    private int size;

    public Task15A() {
        super("Day15", "Task15A");
    }

    @Override
    public List<String> perform(List<String> input) {
        initializeData(input);
        discoverCostToAchievePoints();
        return List.of(board[0][0].getPreviousPointsCost() + "");
    }

    private void initializeData(List<String> input) {
        size = input.size();
        board = new Point[size][size];

        for (int y = 0; y < size; y++) {
            char[] line = input.get(y).toCharArray();
            for (int x = 0; x < size; x++) {
                board[x][y] = new Point(line[x]);
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

        public Point(char value) {
            this.value = Integer.parseInt(value + "");
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
