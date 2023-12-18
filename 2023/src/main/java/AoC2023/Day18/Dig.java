package AoC2023.Day18;

import AoC2023.Day18.Range.PointPosition;
import AoC2023.shared.Position;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static AoC2023.Day18.Range.PointPosition.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Dig {

    List<Range> rangesX;
    List<Range> rangesY;

    public static Dig of(List<Instruction> instructions) {
        List<Range> rangesX = new ArrayList<>();
        List<Range> rangesY = new ArrayList<>();
        Position currentPosition = Position.of(0, 0);
        for (Instruction instruction : instructions) {
            int change = instruction.getLength();
            switch (instruction.getDirection()) {
                case NORTH -> {
                    change *= -1;
                    rangesY.add(Range.ofY(currentPosition, -instruction.getLength()));
                    currentPosition = movePosition(currentPosition, 0, change);
                }
                case EAST -> {
                    rangesX.add(Range.ofX(currentPosition, instruction.getLength()));
                    currentPosition = movePosition(currentPosition, change, 0);
                }
                case SOUTH -> {
                    rangesY.add(Range.ofY(currentPosition, instruction.getLength()));
                    currentPosition = movePosition(currentPosition, 0, change);
                }
                case WEST -> {
                    change *= -1;
                    rangesX.add(Range.ofX(currentPosition, -instruction.getLength()));
                    currentPosition = movePosition(currentPosition, change, 0);
                }
            }
        }
        Collections.sort(rangesX);
        Collections.sort(rangesY);
        return new Dig(rangesX, rangesY);
    }

    private static Position movePosition(Position position, int changeInX, int changeInY) {
        return Position.of(position.getX() + changeInX, position.getY() + changeInY);
    }

    public long calculateDig() {
        List<Integer> importantRows = rangesX.stream()
                .map(Range::getConstant)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long previousRow = sumForRow(importantRows.get(0));
        long sum = previousRow;
        for (int i = 1; i < importantRows.size() - 1; i++) {
            sum += (importantRows.get(i) - importantRows.get(i - 1) - 1) * previousRow;
            sum += sumForRow(importantRows.get(i));
            previousRow = sumForRow(importantRows.get(i) + 1);
        }
        sum += (importantRows.get(importantRows.size() - 1) - importantRows.get(importantRows.size() - 2)) * previousRow;
        return sum;
    }

    private long sumForRow(int rowNumber) {
        List<Tuple2<Integer, PointPosition>> valuesForRange = rangesY.stream()
                .map(rangeY -> Tuple.of(rangeY.getConstant(), rangeY.pointPosition(rowNumber)))
                .filter(tuple -> tuple._2 != OUTSIDE)
                .collect(Collectors.toList());
        long sumForRow = valuesForRange.size();
        boolean isGlobalTake = valuesForRange.get(0)._2 == INSIDE;
        boolean isLocalTake = false;
        for (int i = 1; i < valuesForRange.size(); i++) {
            Tuple2<Integer, PointPosition> from = valuesForRange.get(i - 1);
            Tuple2<Integer, PointPosition> to = valuesForRange.get(i);
            if (from._2 != INSIDE) {
                isLocalTake = !isLocalTake;
            }
            sumForRow += (isGlobalTake || isLocalTake) ? to._1 - from._1 - 1 : 0;
            boolean isChange = (from._2 == BEGIN && to._2 == END) || (from._2 == END && to._2 == BEGIN);
            if (to._2 == INSIDE || (isChange && isLocalTake)) {
                isGlobalTake = !isGlobalTake;
            }
        }
        return sumForRow;
    }
}
