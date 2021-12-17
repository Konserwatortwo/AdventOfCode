package AoC2021.Day16;

import AoC2021.AdventTask;

import java.util.List;

public class Task16B extends AdventTask {

    public Task16B() {
        super("Day16", "Task16B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Instruction> instructions = InstructionReader.readInstructions(input.get(0));
        return List.of(instructions.get(0).retrieveValue() + "");
    }
}
