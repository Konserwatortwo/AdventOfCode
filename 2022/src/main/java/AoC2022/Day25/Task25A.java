package AoC2022.Day25;

import AoC2022.AdventTask;

import java.util.List;

public class Task25A extends AdventTask {

    public Task25A() {
        super("Day25", "Task25A");
    }

    @Override
    public List<String> perform(List<String> input) {
        long sum = input.stream().mapToLong(this::decryptSNAFUNumber).sum();
        return List.of(encryptSNAFUNumber(sum) + "");
    }

    private long decryptSNAFUNumber(String line) {
        long result = 0;
        long multiplier = 1;
        char[] charArray = line.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            int positionNumber = switch (charArray[i]) {
                case '0' -> 0;
                case '1' -> 1;
                case '2' -> 2;
                case '-' -> -1;
                case '=' -> -2;
                default -> throw new IllegalStateException("Unexpected value: " + charArray[i]);
            };
            result += positionNumber * multiplier;
            multiplier *= 5;
        }
        return result;
    }

    private String encryptSNAFUNumber(long number) {
        long multiplier = 1;
        while (multiplier <= number) {
            number += multiplier * 2;
            multiplier *= 5;
        }
        StringBuilder builder = new StringBuilder();
        while (multiplier > 1) {
            multiplier /= 5;
            int dived = (int) (number / multiplier);
            builder.append(switch (dived) {
                case 0 -> '=';
                case 1 -> '-';
                case 2 -> '0';
                case 3 -> '1';
                case 4 -> '2';
                default -> throw new IllegalStateException("Unexpected value");
            });
            number = number % multiplier;
        }
        return builder.toString();
    }
}
