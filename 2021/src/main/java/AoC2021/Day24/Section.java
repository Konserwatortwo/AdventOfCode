package AoC2021.Day24;

import AoC2021.Day24.enums.Symbol;

import java.util.List;
import java.util.stream.Collectors;

public class Section {

    private final Symbol inputSymbol;
    private final List<Instruction> instructions;

    public Section(Symbol inputSymbol, List<String> instructionsForSection) {
        this.inputSymbol = inputSymbol;
        this.instructions = instructionsForSection.stream().map(Instruction::new).collect(Collectors.toList());
    }

    public Register executeInstructions(int value, Register oldRegister) {
        Register newRegister = new Register(oldRegister);
        newRegister.setValueForSymbol(Symbol.A, 1 + newRegister.getValueForSymbol(Symbol.A));
        newRegister.setValueForSymbol(inputSymbol, value);
        instructions.forEach(instruction -> instruction.perform(newRegister));
        return newRegister;
    }
}
