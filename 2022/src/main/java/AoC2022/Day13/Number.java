package AoC2022.Day13;

public class Number extends Element {

    int value;

    public Number(String line) {
        this.value = Integer.parseInt(line);
    }

    @Override
    public int compareTo(Element other) {
        if (other instanceof Number) {
            return Integer.compare(value, ((Number) other).value);
        }
        return new Packet(this).compareTo(other);
    }
}
