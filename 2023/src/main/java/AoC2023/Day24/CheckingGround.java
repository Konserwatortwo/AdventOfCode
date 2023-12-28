package AoC2023.Day24;

import AoC2023.shared.Coordinates;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CheckingGround {

    List<Line> hailsLines;

    public static CheckingGround of(List<String> inputs) {
        return new CheckingGround(inputs.stream().map(Line::of).toList());
    }

    public long countCollisionIn(long min, long max) {
        long count = 0;
        for (int i = 0; i < hailsLines.size(); i++) {
            for (int j = i + 1; j < hailsLines.size(); j++) {
                if (hailsLines.get(i).willCross(hailsLines.get(j), min, max)) {
                    count++;
                }
            }
        }
        return count;
    }

    public long calculateThrow() {
        double[][] matrix = new double[6][];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            Line first = hailsLines.get(i);
            Line second = hailsLines.get(i + 1);
            matrix[index++] = enterInToMatrix(0, 1, calculateValues(first, second, Coordinates::getX, Coordinates::getY));
            matrix[index++] = enterInToMatrix(1, 2, calculateValues(first, second, Coordinates::getY, Coordinates::getZ));
            matrix[index++] = enterInToMatrix(0, 2, calculateValues(first, second, Coordinates::getX, Coordinates::getZ));
        }
        long[] result = gaussianElimination(matrix);
        return result[0] + result[1] + result[2];
    }

    private double[] enterInToMatrix(int firstIndex, int secondIndex, double[] values) {
        double[] result = new double[7];
        result[firstIndex] = values[0];
        result[secondIndex] = values[1];
        result[firstIndex + 3] = values[2];
        result[secondIndex + 3] = values[3];
        result[6] = values[4];
        return result;
    }

    private double[] calculateValues(
            Line first,
            Line second,
            Function<Coordinates, Long> getFirst,
            Function<Coordinates, Long> getSecond
    ) {
        double[] values = new double[5];
        values[0] = getSecond.apply(second.getVelocities()) - getSecond.apply(first.getVelocities());
        values[1] = getFirst.apply(first.getVelocities()) - getFirst.apply(second.getVelocities());
        values[2] = getSecond.apply(first.getPositions()) - getSecond.apply(second.getPositions());
        values[3] = getFirst.apply(second.getPositions()) - getFirst.apply(first.getPositions());
        values[4] = calculateResultValue(first, second, getFirst, getSecond);
        return values;
    }

    private long calculateResultValue(
            Line first,
            Line second,
            Function<Coordinates, Long> getFirst,
            Function<Coordinates, Long> getSecond
    ) {
        return getFirst.apply(first.getPositions()) * getSecond.apply(first.getVelocities()) * -1
                + getSecond.apply(first.getPositions()) * getFirst.apply(first.getVelocities())
                + getFirst.apply(second.getPositions()) * getSecond.apply(second.getVelocities())
                - getSecond.apply(second.getPositions()) * getFirst.apply(second.getVelocities());
    }

    private static long[] gaussianElimination(double[][] matrix) {
        int size = matrix.length;
        partialPivot(matrix);
        long[] result = new long[size];
        for (int i = size - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < size; j++) {
                sum += matrix[i][j] * result[j];
            }
            result[i] = Math.round((matrix[i][size] - sum) / matrix[i][i]);
        }
        return result;
    }

    private static void partialPivot(double[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            int pivotRow = i;
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivotRow][i])) {
                    pivotRow = j;
                }
            }
            if (pivotRow != i) {
                for (int j = i; j <= size; j++) {
                    double temp = matrix[i][j];
                    matrix[i][j] = matrix[pivotRow][j];
                    matrix[pivotRow][j] = temp;
                }
            }
            for (int j = i + 1; j < size; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k <= size; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
    }
}
