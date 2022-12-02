package AoC2022.Day2;

import AoC2022.AdventTask;

import java.util.List;

public class Task2A extends AdventTask {

    enum OpponentTactic {
        A(3, 6, 0),
        B(0, 3, 6),
        C(6, 0, 3);

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
                case "X" -> 1 + pointsForX;
                case "Y" -> 2 + pointsForY;
                case "Z" -> 3 + pointsForZ;
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

    public Task2A() {
        super("Day2", "Task2A");
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
