package AoC2023.Day17;

import AoC2023.shared.Direction;
import AoC2023.shared.Position;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class Solution {

    int maxLength;
    int minLength;
    Direction currentDirection;
    @Getter
    Position currentPosition;
    @Getter
    int currentStraightLine;
    @Getter
    @NonFinal
    int currentHeatLoss;

    public static Solution of(Direction startingDirection, Position startingPosition, int maxLength, int minLength) {
        return new Solution(maxLength, minLength, startingDirection, startingPosition, 0, 0);
    }

    public List<Solution> generateNextSolutions() {
        List<Solution> result = new ArrayList<>();
        if (currentStraightLine < maxLength) {
            result.add(generateSolutionInDirection(currentDirection, currentStraightLine + 1));
        }
        if (canTurn()) {
            result.add(generateSolutionInDirection(currentDirection.goRight(), 0));
            result.add(generateSolutionInDirection(currentDirection.goLeft(), 0));
        }
        return result;
    }

    public boolean canTurn() {
        return currentStraightLine >= minLength;
    }

    private Solution generateSolutionInDirection(
            Direction direction,
            int straightLine
    ) {
        return new Solution(
                maxLength,
                minLength,
                direction,
                direction.determineNextPosition(currentPosition),
                straightLine,
                currentHeatLoss
        );
    }

    public void heatLoss(int heatLossForPosition) {
        currentHeatLoss += heatLossForPosition;
    }

    public String getKey() {
        return currentDirection + ":" + currentPosition + ":" + currentStraightLine;
    }

    public boolean canBeBetter(Solution other) {
        return currentHeatLoss < other.currentHeatLoss;
    }
}
