package AdventOfCode.Day4;

import AdventOfCode.AdventTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4A extends AdventTask {
    @Override
    protected List<String> perform(List<String> input) {
        int count = 0;
        int lowerBound = Integer.parseInt(input.get(0));
        int upperBound = Integer.parseInt(input.get(1));
        for (int i = lowerBound; i <= upperBound; i++) {
            if (checkNumber(i)) {
                count++;
            }
        }
        return Collections.singletonList(count + "");
    }

    static boolean checkNumber(int number) {
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
}
