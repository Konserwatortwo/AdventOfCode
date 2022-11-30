package AoC2022.Day16;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operator extends Instruction {

    enum Operation {
        SUM,
        PRODUCT,
        MINIMUM,
        MAXIMUM,
        GREATER_THAN,
        LESS_THAN,
        EQUAL_TO
    }

    private final Operation operation;
    private boolean countSizeAsQuantity;
    private int size;
    private final List<Instruction> relatedInstructions;

    public Operator(int version, int id) {
        super(version, Type.OPERATOR);
        operation = Operation.values()[id < 4 ? id : id - 1];
        relatedInstructions = new ArrayList<>();
    }

    public void setCountSizeAsQuantity(boolean countSizeAsQuantity) {
        this.addLength(1);
        this.countSizeAsQuantity = countSizeAsQuantity;
    }

    public void setSize(int size) {
        this.size = size;
        if (countSizeAsQuantity) {
            this.addLength(11);
        } else {
            this.addLength(15);
            this.size += super.getLength();
        }
    }

    public boolean requiredMoreSubpackages() {
        return countSizeAsQuantity ? size > relatedInstructions.size() : size > getLength();
    }

    public void addInstructions(Instruction instruction) {
        relatedInstructions.add(instruction);
    }

    @Override
    public int getLength() {
        return super.getLength() + relatedInstructions.stream().mapToInt(Instruction::getLength).sum();
    }

    @Override
    public BigInteger retrieveValue() {
        List<BigInteger> numbers = new ArrayList<>();
        for (Instruction relatedInstruction : relatedInstructions) {
            numbers.add(relatedInstruction.retrieveValue());
        }

        BigInteger alfa = switch (operation) {
            case SUM -> numbers.stream().reduce(BigInteger.ZERO, BigInteger::add);
            case PRODUCT -> numbers.stream().reduce(BigInteger.ONE, BigInteger::multiply);
            case MINIMUM -> Collections.min(numbers);
            case MAXIMUM -> Collections.max(numbers);
            case GREATER_THAN -> numbers.get(0).compareTo(numbers.get(1)) > 0 ? BigInteger.ONE : BigInteger.ZERO;
            case LESS_THAN -> numbers.get(0).compareTo(numbers.get(1)) < 0 ? BigInteger.ONE : BigInteger.ZERO;
            case EQUAL_TO -> numbers.get(0).compareTo(numbers.get(1)) == 0 ? BigInteger.ONE : BigInteger.ZERO;
        };
        return alfa;
    }
}
