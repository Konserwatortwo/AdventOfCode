package AoC2021.Day8;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberDetector {

    enum Numbers {
        ZERO(0, Set.of('a', 'b', 'c', 'e', 'f', 'g')),
        ONE(1, Set.of('c', 'f')),
        TWO(2, Set.of('a', 'c', 'd', 'e', 'g')),
        THREE(3, Set.of('a', 'c', 'd', 'f', 'g')),
        FOUR(4, Set.of('b', 'c', 'd', 'f')),
        FIVE(5, Set.of('a', 'b', 'd', 'f', 'g')),
        SIX(6, Set.of('a', 'b', 'd', 'e', 'f', 'g')),
        SEVEN(7, Set.of('a', 'c', 'f')),
        EIGHT(8, Set.of('a', 'b', 'c', 'd', 'e', 'f', 'g')),
        NINE(9, Set.of('a', 'b', 'c', 'd', 'f', 'g'));


        private int value;
        private Set<Character> letters;

        Numbers(int value, Set<Character> letters) {
            this.value = value;
            this.letters = letters;
        }

        public boolean isNumber(Set<Character> numberLetters) {
            return letters.equals(numberLetters);
        }

        public int getValue() {
            return value;
        }
    }

    public static int processLineAsNumber(String line) {
        int number = 0;
        int pow = 1;
        int[] output = processLine(line);

        for (int i = output.length - 1; i >= 0; i--) {
            number += output[i] * pow;
            pow *= 10;
        }

        return number;
    }

    public static int[] processLine(String line) {
        String[] sections = line.split(" \\| ");
        Map<Character, Character> sequences = detectSequences(sections[0].trim());

        int[] output = new int[4];
        String[] inputSequences = sections[1].trim().split(" ");
        for (int i = 0; i < inputSequences.length; i++) {
            output[i] = processInput(inputSequences[i], sequences);
        }
        return output;
    }

    private static Map<Character, Character> detectSequences(String detectorLine) {
        Map<Character, Character> sequences = new HashMap<>();

        String sequenceFor4 = "";
        for (String detector : detectorLine.split(" ")) {
            if (detector.length() == 4) {
                sequenceFor4 = detector;
            }
        }
        Map<Character, Integer> segmentCount = countSegments(detectorLine);

        for (Map.Entry<Character, Integer> entry : segmentCount.entrySet()) {
            sequences.put(entry.getKey(), recognizeCharacter(entry.getValue(), -1 != sequenceFor4.indexOf(entry.getKey())));
        }
        return sequences;
    }

    private static Map<Character, Integer> countSegments(String detectorLine) {
        Map<Character, Integer> segmentCount = new HashMap<>();
        for (char sing = 'a'; sing <= 'g'; sing++) {
            segmentCount.put(sing, StringUtils.countMatches(detectorLine, sing));
        }
        return segmentCount;
    }

    private static Character recognizeCharacter(int occurrences, boolean exitingInFourSequence) {
        switch (occurrences) {
            case 4:
                return 'e';
            case 6:
                return 'b';
            case 9:
                return 'f';
            case 8:
                if (exitingInFourSequence) {
                    return 'c';
                } else {
                    return 'a';
                }
            case 7:
                if (exitingInFourSequence) {
                    return 'd';
                } else {
                    return 'g';
                }
            default:
                throw new IllegalStateException("Other occurrences");
        }
    }

    private static int processInput(String line, Map<Character, Character> sequences) {
        Set<Character> detectedChars = new HashSet<>();
        for (char element : line.toCharArray()) {
            detectedChars.add(sequences.get(element));
        }
        for (Numbers value : Numbers.values()) {
            if (value.isNumber(detectedChars)) {
                return value.getValue();
            }
        }
        return -1;
    }

}
