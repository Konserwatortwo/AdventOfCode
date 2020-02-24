package AdventOfCode.Day4;

import AdventOfCode.AdventTask;

import java.util.*;

public class Task4B extends AdventTask {
    @Override
    protected List<String> perform(List<String> input) {
        List<Integer> fulfillingNumbers = new ArrayList<>();
        int lowerBound = Integer.parseInt(input.get(0));
        int upperBound = Integer.parseInt(input.get(1));
        for (int i = lowerBound; i <= upperBound; i++) {
            if (checkNumber(i)) {
                fulfillingNumbers.add(i);
            }
        }
        return Collections.singletonList(fulfillingNumbers.stream().filter(Task4B::anotherCheck).count() + "");
    }

    private static boolean checkNumber(int number) {
        Integer[] digits = splitToDigits(number);
        return isSixDigitNumber(digits) && containsTwoSameDigit(digits) && neverDecrease(digits);
    }

    private static Integer[] splitToDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        collectDigits(number, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }

    private static boolean isSixDigitNumber(Integer[] digits) {
        return digits.length == 6;
    }

    private static boolean containsTwoSameDigit(Integer[] digits) {
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i].equals(digits[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean neverDecrease(Integer[] digits) {
        int highest = 0;
        for (Integer digit : digits) {
            if (highest > digit) {
                return false;
            }
            highest = digit;
        }
        return true;
    }

    static boolean anotherCheck(int number) {
        Integer[] digits = splitToDigits(number);
        Map<Integer, Integer> digitMap = new HashMap<>();
        for (Integer digit : digits) {
            if (digitMap.containsKey(digit)) {
                int values = digitMap.get(digit) + 1;
                digitMap.put(digit, values);
            } else {
                digitMap.put(digit, 1);
            }
        }
        return digitMap.containsValue(2);
    }
}
