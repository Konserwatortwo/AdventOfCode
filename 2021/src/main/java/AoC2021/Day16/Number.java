package AoC2021.Day16;

import java.math.BigInteger;

public class Number extends Instruction {

    private BigInteger value = BigInteger.ZERO;

    public Number(int version) {
        super(version, Type.NUMBER);
    }

    public void addValue(int value) {
        this.addLength(5);
        this.value = this.value.multiply(BigInteger.valueOf(16)).add(BigInteger.valueOf(value));
    }

    @Override
    public BigInteger retrieveValue() {
        return value;
    }
}
