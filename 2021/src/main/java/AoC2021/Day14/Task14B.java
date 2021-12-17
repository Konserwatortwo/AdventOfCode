package AoC2021.Day14;

import AoC2021.AdventTask;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task14B extends AdventTask {

    public Task14B() {
        super("Day14", "Task14B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Map<String, Sequence> sequences = performTask(input, 40);

        Map<Character, BigInteger> countCharacters = new HashMap<>();
        for (Sequence sequence : sequences.values()) {
            char lastElementOfSequence = sequence.getSequence().charAt(1);
            if (countCharacters.containsKey(lastElementOfSequence)) {
                countCharacters.put(lastElementOfSequence, countCharacters.get(lastElementOfSequence).add(sequence.getOccurrences()));
            } else {
                countCharacters.put(lastElementOfSequence, sequence.getOccurrences());
            }
        }

        char firstElementOfStartingSequence = input.get(0).charAt(0);
        countCharacters.put(firstElementOfStartingSequence, countCharacters.get(firstElementOfStartingSequence).add(BigInteger.ONE));

        BigInteger mostCommonElementOccurrence = BigInteger.ZERO;
        BigInteger leastCommonElementOccurrence = null;
        for (BigInteger value : countCharacters.values()) {
            if (0 > mostCommonElementOccurrence.compareTo(value)) {
                mostCommonElementOccurrence = value;
            } else if (null == leastCommonElementOccurrence || 0 < leastCommonElementOccurrence.compareTo(value)) {
                leastCommonElementOccurrence = value;
            }
        }

        return List.of(mostCommonElementOccurrence.subtract(leastCommonElementOccurrence) + "");
    }

    public Map<String, Sequence> performTask(List<String> input, int steps) {
        Map<String, Character> templates = retrieveTemplates(input.subList(2, input.size()));
        Map<String, Sequence> sequences = retrieveStartingSequences(input.get(0), templates);

        for (int i = 0; i < steps; i++) {
            Map<String, Sequence> newSequences = new HashMap<>();
            for (Map.Entry<String, Sequence> sequenceEntry : sequences.entrySet()) {
                Sequence sequence = sequenceEntry.getValue();
                BigInteger numberOfOccurrence = sequence.getOccurrences();
                for (String nextSequence : sequence.getNextSequence()) {
                    newSequences.computeIfAbsent(nextSequence, key -> new Sequence(key, templates.get(key))).addOccurrences(numberOfOccurrence);
                }
            }
            sequences = newSequences;
        }

        return sequences;
    }

    private Map<String, Character> retrieveTemplates(List<String> input) {
        Map<String, Character> templates = new HashMap<>();
        for (String line : input) {
            String[] element = line.split(" -> ");
            templates.put(element[0], element[1].charAt(0));
        }
        return templates;
    }

    private Map<String, Sequence> retrieveStartingSequences(String sequence, Map<String, Character> templates) {
        Map<String, Sequence> sequences = new HashMap<>();
        for (int i = 1; i < sequence.length(); i++) {
            String subsequence = sequence.substring(i - 1, i + 1);
            sequences.put(subsequence, new Sequence(subsequence, templates.get(subsequence), BigInteger.ONE));
        }
        return sequences;
    }

    static class Sequence {
        private final String sequence;
        private final String[] nextSequences = new String[2];
        private BigInteger numberOfOccurrence = BigInteger.ZERO;

        public Sequence(String sequence, Character middleElement) {
            this.sequence = sequence;
            this.nextSequences[0] = String.valueOf(sequence.charAt(0)) + middleElement;
            this.nextSequences[1] = String.valueOf(middleElement) + sequence.charAt(1);
        }

        public Sequence(String sequence, Character middleElement, BigInteger numberOfOccurrence) {
            this(sequence, middleElement);
            this.numberOfOccurrence = numberOfOccurrence;
        }

        public String getSequence() {
            return sequence;
        }

        public BigInteger getOccurrences() {
            return numberOfOccurrence;
        }

        public void addOccurrences(BigInteger occurrence) {
            numberOfOccurrence = numberOfOccurrence.add(occurrence);
        }

        public String[] getNextSequence() {
            return nextSequences;
        }
    }
}
