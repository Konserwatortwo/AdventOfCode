package AoC2021.Day18;

import AoC2021.Day18.SailfishNumber.Position;

public class SailfishNumberUtils {

    public static String[] splitSailfishNumberToElements(String inputLine) {
        int depthOfElements = 0;
        String[] elements = new String[2];
        StringBuilder builder = new StringBuilder();

        char[] charArray = inputLine.toCharArray();
        for (int i = 1; i < charArray.length - 1; i++) {
            char sign = charArray[i];
            if (sign == ',' && depthOfElements == 0) {
                elements[0] = builder.toString();
                builder = new StringBuilder();
            } else {
                if (sign == '[') {
                    depthOfElements++;
                } else if (sign == ']') {
                    depthOfElements--;
                }
                builder.append(sign);
            }
        }
        elements[1] = builder.toString();
        return elements;
    }

    public static void performSplit(SailfishNumber number, Position position) {
        int splitNumber = number.getValueFromPosition(position);
        int ceilDiv = Math.floorDiv(splitNumber, 2) + (splitNumber % 2 == 0 ? 0 : 1);
        SailfishNumber newSailfishNumber = new SailfishNumber(number, position, Math.floorDiv(splitNumber, 2), ceilDiv);
        number.setSailfishNumberOnPosition(newSailfishNumber, position);
    }

    public static void performExplosion(SailfishNumber number) {
        addValueToPositionInOrder(number, Position.LEFT);
        addValueToPositionInOrder(number, Position.RIGHT);
        number.getParent().setValueOnPosition(0, number.getPosition());
    }

    private static void addValueToPositionInOrder(SailfishNumber number, Position position) {
        SailfishNumber currentInOrder = number;
        SailfishNumber previousInOrder = number.getParent();
        int value = number.getValueFromPosition(position);
        Position oppositePosition = getOppositePosition(position);

        while (null != previousInOrder && currentInOrder.isPosition(position)) {
            currentInOrder = previousInOrder;
            previousInOrder = currentInOrder.getParent();
        }

        if (null != previousInOrder) {
            if (previousInOrder.isValueOnPosition(position)) {
                previousInOrder.addValueOnPosition(value, position);
            } else {
                currentInOrder = previousInOrder.getSailfishNumberFromPosition(position);
                while (!currentInOrder.isValueOnPosition(oppositePosition)) {
                    currentInOrder = currentInOrder.getSailfishNumberFromPosition(oppositePosition);
                }
                currentInOrder.addValueOnPosition(value, oppositePosition);
            }
        }
    }

    private static Position getOppositePosition(Position position) {
        return switch (position) {
            case NONE -> Position.NONE;
            case LEFT -> Position.RIGHT;
            case RIGHT -> Position.LEFT;
        };
    }

    public static SailfishNumber addSailfishNumbers(SailfishNumber firstNumber, SailfishNumber secondNumber) {
        SailfishNumber result = new SailfishNumber(firstNumber, secondNumber);
        result.reduce();
        return result;
    }
}
