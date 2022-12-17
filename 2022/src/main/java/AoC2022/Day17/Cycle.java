package AoC2022.Day17;

import java.util.Arrays;

public class Cycle {

    private RockType type;
    private String instruction;
    private long[] peaks;

    public Cycle(RockType type, String instruction, long[] peaks) {
        this.type = type;
        this.instruction = instruction;
        this.peaks = normalizePeaks(peaks);
    }

    public boolean haveSamePattern(long[] currentPeaks) {
        return Arrays.equals(peaks, normalizePeaks(currentPeaks));
    }

    private long[] normalizePeaks(long[] peaks) {
        long minValue = Arrays.stream(peaks).min().getAsLong();
        return copyArrayWithChangedValue(peaks, minValue * (-1));
    }

    private long[] copyArrayWithChangedValue(long[] peaks, long valueChange) {
        long[] result = new long[peaks.length];
        for (int i = 0; i < peaks.length; i++) {
            result[i] = peaks[i] + valueChange;

        }
        return result;
    }

    public boolean haveSameInstruction(String currentInstruction, int pointer) {
        String nextInstruction = currentInstruction.substring(pointer, pointer + getInstructionLength());
        return instruction.equals(nextInstruction);
    }

    public int getInstructionLength() {
        return instruction.length();
    }

    public long[] retrieveNewPeaks(int lowestPeak) {
        return copyArrayWithChangedValue(peaks, lowestPeak);
    }
}
