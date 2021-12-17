package AoC2021.Day16;

import java.math.BigInteger;

public abstract class Instruction {

    enum Type {
        NUMBER,
        OPERATOR
    }

    private final int version;
    private final Type type;
    private int length;

    public Instruction(int version, Type type) {
        this.version = version;
        this.type = type;
        length = 6;
    }

    public int getVersion() {
        return version;
    }

    public int getLength() {
        return length;
    }

    public void addLength(int length) {
        this.length += length;
    }

    public abstract BigInteger retrieveValue();
}



