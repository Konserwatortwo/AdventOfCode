package AoC2022.Day16;

public class InstructionBuilder {

    enum State {
        SIGNATURE_REQUIRED(6),
        NUMBER_REQUIRED(5),
        OPERATOR_TYPE_REQUIRED(1),

        LENGTH_REQUIRED(15),
        SIZE_REQUIRED(11),

        COMPLETED(6);

        private final int commandSize;

        State(int commandSize) {
            this.commandSize = commandSize;
        }

        public int getCommandSize() {
            return commandSize;
        }
    }

    private Instruction processedInstruction;
    private State state = State.SIGNATURE_REQUIRED;

    public State getState() {
        return state;
    }

    public int getNextCommandSize() {
        return state.getCommandSize();
    }

    public void readSignature(int version, int type) {
        if (type == 4) {
            processedInstruction = new Number(version);
            state = State.NUMBER_REQUIRED;
        } else {
            processedInstruction = new Operator(version, type);
            state = State.OPERATOR_TYPE_REQUIRED;
        }
    }

    public void readNumber(boolean isLast, int number) {
        if (isLast) {
            state = State.COMPLETED;
        }
        ((Number) processedInstruction).addValue(number);
    }

    public void readOperatorType(char sign) {
        boolean countSizeAsQuantity = sign == '1';

        if (countSizeAsQuantity) {
            state = State.SIZE_REQUIRED;
        } else {
            state = State.LENGTH_REQUIRED;
        }

        ((Operator) processedInstruction).setCountSizeAsQuantity(countSizeAsQuantity);
    }

    public void readValue(int value) {
        this.state = State.COMPLETED;
        ((Operator) processedInstruction).setSize(value);
    }

    public Instruction buildInstruction() {
        state = State.SIGNATURE_REQUIRED;
        return processedInstruction;
    }
}
