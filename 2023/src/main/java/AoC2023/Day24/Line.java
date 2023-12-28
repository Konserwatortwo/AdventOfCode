package AoC2023.Day24;

import AoC2023.shared.Coordinates;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static AoC2023.AdventTaskUtils.splitAndParseToLong;
import static AoC2023.AdventTaskUtils.splitOnSeparator;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
public class Line {

    Coordinates positions;
    Coordinates velocities;

    public static Line of(String input) {
        List<String> elements = splitOnSeparator(input, "@");
        return new Line(
                Coordinates.of(splitAndParseToLong(elements.get(0), ",")),
                Coordinates.of(splitAndParseToLong(elements.get(1), ","))
        );
    }

    public boolean willCross(Line other, long min, long max) {
        double[] coefficients = calculateCoefficients();
        double[] otherCoefficients = other.calculateCoefficients();
        if (coefficients[0] == otherCoefficients[0]) {
            return false;
        }
        double diffA = coefficients[0] - otherCoefficients[0];
        double crossX = (otherCoefficients[1] - coefficients[1]) / diffA;
        double crossY = (otherCoefficients[1] * coefficients[0] - coefficients[1] * otherCoefficients[0]) / diffA;
        return isPointInLimit(crossX, min, max)
                && isPointInLimit(crossY, min, max)
                && isPointInFuture(crossX)
                && other.isPointInFuture(crossX);
    }

    private double[] calculateCoefficients() {
        double a = ((double) velocities.getY()) / velocities.getX();
        double b = positions.getY() - a * positions.getX();
        return new double[]{a, b};
    }

    private boolean isPointInLimit(double point, long min, long max) {
        return point >= min && point <= max;
    }

    private boolean isPointInFuture(double crossX) {
        return positions.getX() <= crossX == velocities.getX() > 0;
    }
}
