package AoC2021.Day16;

import AoC2021.AdventTask;

import java.util.List;

public class Task16A extends AdventTask {

    public Task16A() {
        super("Day16", "Task16A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Instruction> instructions = InstructionReader.readInstructions(input.get(0));
        return List.of(instructions.stream().mapToInt(Instruction::getVersion).sum() + "");
    }
}
