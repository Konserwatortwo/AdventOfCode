package AoC2023.Day11;


import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Grid {

    List<Tuple2<Integer, Integer>> galaxiesPositions;
    boolean[] verticalSpace;
    boolean[] horizontalSpace;

    public static Grid of(List<String> inputValue) {
        assert inputValue.size() > 1;
        List<Tuple2<Integer, Integer>> galaxiesPositions = new ArrayList<>();
        boolean[] verticalSpace = new boolean[inputValue.get(0).length()];
        boolean[] horizontalSpace = new boolean[inputValue.size()];
        Arrays.fill(verticalSpace, true);
        for (int y = 0; y < inputValue.size(); y++) {
            String line = inputValue.get(y);
            if (line.contains("#")) {
                char[] charArray = line.toCharArray();
                for (int x = 0; x < charArray.length; x++) {
                    if (charArray[x] == '#') {
                        verticalSpace[x] = false;
                        galaxiesPositions.add(Tuple.of(x, y));
                    }
                }
            } else {
                horizontalSpace[y] = true;
            }
        }
        return new Grid(galaxiesPositions, verticalSpace, horizontalSpace);
    }

    public long calculateDistanceBetweenGalaxies(int spaceValue) {
        long sumOfDistances = 0;
        for (int i = 0; i < galaxiesPositions.size(); i++) {
            for (int j = i + 1; j < galaxiesPositions.size(); j++) {
                sumOfDistances += calculateDistanceBetweenGalaxies(
                        galaxiesPositions.get(i),
                        galaxiesPositions.get(j),
                        spaceValue
                );
            }
        }
        return sumOfDistances;
    }

    private long calculateDistanceBetweenGalaxies(
            Tuple2<Integer, Integer> first,
            Tuple2<Integer, Integer> second,
            int spaceValue
    ) {
        return calculateDistanceBetweenCoordinates(first._1, second._1, verticalSpace, spaceValue)
                + calculateDistanceBetweenCoordinates(first._2, second._2, horizontalSpace, spaceValue);
    }

    private long calculateDistanceBetweenCoordinates(
            int firstCoordinate,
            int secondCoordinate,
            boolean[] axisSpace,
            int spaceValue
    ) {
        return ((firstCoordinate < secondCoordinate)
                ? IntStream.range(firstCoordinate, secondCoordinate)
                : IntStream.range(secondCoordinate, firstCoordinate))
                .map(i -> axisSpace[i] ? spaceValue : 1)
                .sum();
    }
}
