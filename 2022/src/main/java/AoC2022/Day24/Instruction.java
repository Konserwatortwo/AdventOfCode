package AoC2022.Day24;


import AoC2022.Day24.enums.Operation;
import AoC2022.Day24.enums.Symbol;

import java.util.regex.Pattern;

public class Instruction {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    private final Operation operation;

    private final Symbol firstArgument;

    private final String secondArgument;

    public Instruction(String line) {
        String[] elements = line.split(" ");
        this.operation = Operation.retrieveOperation(elements[0]);
        this.firstArgument = Symbol.retrieveSymbol(elements[1]);
        this.secondArgument = elements[2];
    }

    public void perform(Register register) {
        long firstValue = register.getValueForSymbol(firstArgument);
        long secondValue;
        if (isSecondArgumentNumber()) {
            secondValue = Integer.parseInt(secondArgument);
        } else {
            secondValue = register.getValueForSymbol(Symbol.retrieveSymbol(secondArgument));
        }
        register.setValueForSymbol(firstArgument, performOperation(firstValue, secondValue));
    }

    private boolean isSecondArgumentNumber() {
        return NUMBER_PATTERN.matcher(secondArgument).matches();
    }

    private long performOperation(long first, long second) {
        return switch (operation) {
            case ADD -> first + second;
            case MUL -> first * second;
            case DIV -> first / second;
            case MOD -> first % second;
            case EQL -> first == second ? 1 : 0;
        };
    }

    @Override
    public String toString() {
        return operation + " " + firstArgument + " " + secondArgument;
    }
}
