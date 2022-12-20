package AoC2022.Day20;

import java.util.ArrayList;
import java.util.List;

public class Mixer {

    public static List<Number> mixNumbers(List<Number> originalList, int times) {
        List<Number> result = new ArrayList<>(originalList);
        for (int i = 0; i < times; i++) {
            for (Number currentNumber : originalList) {
                int index = result.indexOf(currentNumber);
                int newPlace = calculatePositionInList(index, currentNumber.getValue(), originalList.size());
                result.remove(currentNumber);
                result.add(newPlace, currentNumber);
            }
        }
        return result;
    }

    private static int calculatePositionInList(long index, long change, long listSize) {
        long possiblePositions = listSize - 1;
        long newPosition = index + change;
        if (newPosition < 0) {
            newPosition = possiblePositions - (newPosition * (-1) % possiblePositions);
        }
        return (int) (newPosition % possiblePositions);
    }

    public static Long calculateCoordinates(List<Number> mixedList) {
        long sum = 0;
        sum += getNumberAfterZero(mixedList, 1000).getValue();
        sum += getNumberAfterZero(mixedList, 2000).getValue();
        sum += getNumberAfterZero(mixedList, 3000).getValue();
        return sum;
    }

    private static Number getNumberAfterZero(List<Number> mixedList, int positionsAfterZero) {
        int indexOfZero = retrieveZeroPosition(mixedList);
        int positionOfNumber = (indexOfZero + positionsAfterZero) % mixedList.size();
        return mixedList.get(positionOfNumber);
    }

    private static int retrieveZeroPosition(List<Number> mixedList) {
        return mixedList.stream()
                .filter(number -> number.getValue() == 0)
                .map(mixedList::indexOf)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
