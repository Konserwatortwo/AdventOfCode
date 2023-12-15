package AoC2023.Day15;


import lombok.Value;

@Value
class Sequence {

    String label;
    boolean isRemoving;
    int boxNumber;
    int focalLength;
    int hash;

    public Sequence(String inputValue) {
        int length = inputValue.length();
        this.isRemoving = inputValue.contains("-");
        this.label = inputValue.substring(0, length - (isRemoving ? 1 : 2));
        this.boxNumber = calculateHash(label);
        this.focalLength = isRemoving ? 0 : Integer.parseInt(inputValue.substring(length - 1));
        this.hash = calculateHash(inputValue);
    }

    private static int calculateHash(String inputValue) {
        int hash = 0;
        for (char sign : inputValue.toCharArray()) {
            hash += sign;
            hash *= 17;
            hash %= 256;
        }
        return hash;
    }
}
