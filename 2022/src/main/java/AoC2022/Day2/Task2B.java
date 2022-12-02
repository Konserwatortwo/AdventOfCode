package AoC2022.Day2;

import AoC2022.AdventTask;

import java.util.List;

public class Task2B extends AdventTask {

    enum OpponentTactic {
        A(3, 4, 8),
        B(1, 5, 9),
        C(2, 6, 7);

        private final int pointsForX;
        private final int pointsForY;
        private final int pointsForZ;

        OpponentTactic(int pointsForX, int pointsForY, int pointsForZ) {
            this.pointsForX = pointsForX;
            this.pointsForY = pointsForY;
            this.pointsForZ = pointsForZ;
        }

        public int pointsFor(String strategy) {
            return switch (strategy) {
                case "X" -> pointsForX;
                case "Y" -> pointsForY;
                case "Z" -> pointsForZ;
                default -> throw new IllegalStateException("Unexpected value: " + strategy);
            };
        }

        public static OpponentTactic choseOpponentTactic(String tactic) {
            return switch (tactic) {
                case "A" -> OpponentTactic.A;
                case "B" -> OpponentTactic.B;
                case "C" -> OpponentTactic.C;
                default -> throw new IllegalStateException("Unexpected value");
            };
        }
    }

    public Task2B() {
        super("Day2", "Task2B");
    }

    @Override
    public List<String> perform(List<String> input) {
        int value = 0;
        for (String line : input) {
            String[] elements = line.split(" ");
            value += OpponentTactic.choseOpponentTactic(elements[0]).pointsFor(elements[1]);
        }
        return List.of(value + "");
    }
}
