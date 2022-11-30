package AoC2022.Day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InstructionReader {

    public static List<Instruction> readInstructions(String message) {
        List<Instruction> instructions = new ArrayList<>();
        InstructionBuilder builder = new InstructionBuilder();
        Stack<Operator> effectiveOperators = new Stack<>();
        StringBuilder previousSings = new StringBuilder();
        boolean meaninglessZeros = false;
        int counter = builder.getNextCommandSize();

        for (char letter : message.toCharArray()) {
            meaninglessZeros &= letter == '0';
            if (meaninglessZeros) {
                continue;
            }
            previousSings.append(hexToBin(letter));

            if (previousSings.length() >= counter) {
                readInstructionField(previousSings.substring(0, counter), builder);
                previousSings = new StringBuilder(previousSings.substring(counter));
                counter = builder.getNextCommandSize();
                if (builder.getState() == InstructionBuilder.State.COMPLETED) {
                    Instruction builtInstruction = builder.buildInstruction();
                    instructions.add(builtInstruction);
                    if (!effectiveOperators.isEmpty()) {
                        effectiveOperators.peek().addInstructions(builtInstruction);
                        while (!effectiveOperators.isEmpty() && !effectiveOperators.peek().requiredMoreSubpackages()) {
                            effectiveOperators.pop();
                        }
                    }
                    if (builtInstruction instanceof Operator) {
                        effectiveOperators.push((Operator) builtInstruction);
                    }
                    if (effectiveOperators.isEmpty()) {
                        meaninglessZeros = true;
                        previousSings = new StringBuilder();
                    }
                }
            }
        }

        return instructions;
    }

    private static String hexToBin(char sign) {
        return switch (sign) {
            case '0' -> "0000";
            case '1' -> "0001";
            case '2' -> "0010";
            case '3' -> "0011";
            case '4' -> "0100";
            case '5' -> "0101";
            case '6' -> "0110";
            case '7' -> "0111";
            case '8' -> "1000";
            case '9' -> "1001";
            case 'A' -> "1010";
            case 'B' -> "1011";
            case 'C' -> "1100";
            case 'D' -> "1101";
            case 'E' -> "1110";
            case 'F' -> "1111";
            default -> throw new IllegalStateException("Not recognizable Hexagonal");
        };
    }

    private static void readInstructionField(String previousSings, InstructionBuilder currentlyProcessed) {
        switch (currentlyProcessed.getState()) {
            case SIGNATURE_REQUIRED -> currentlyProcessed.readSignature(binToDec(previousSings.substring(0, 3)), binToDec(previousSings.substring(3)));
            case NUMBER_REQUIRED -> currentlyProcessed.readNumber(previousSings.charAt(0) == '0', binToDec(previousSings.substring(1)));
            case OPERATOR_TYPE_REQUIRED -> currentlyProcessed.readOperatorType(previousSings.charAt(0));
            case SIZE_REQUIRED, LENGTH_REQUIRED -> currentlyProcessed.readValue(binToDec(previousSings));
        }
    }

    private static int binToDec(String binary) {
        return Integer.parseInt(binary, 2);
    }
}

