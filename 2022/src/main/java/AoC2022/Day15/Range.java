package AoC2022.Day15;

public class Range implements Comparable<Range> {

    private int max;
    private int min;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public boolean isRangeOverlapping(Range other) {
        return other.min <= max && other.max >= min;
    }

    public void extendRange(Range other) {
        if (other.min < min) {
            min = other.min;
        }
        if (other.max > max) {
            max = other.max;
        }
    }

    public boolean isRangeOutOfLimit(int limit) {
        return max < 0 && min > limit;
    }

    public void cutToLimit(int limit) {
        if (min < 0) {
            min = 0;
        }
        if (max > limit) {
            max = limit;
        }
    }

    public int distance() {
        return max - min + 1;
    }

    @Override
    public int compareTo(Range other) {
        return min - other.min;
    }
}
