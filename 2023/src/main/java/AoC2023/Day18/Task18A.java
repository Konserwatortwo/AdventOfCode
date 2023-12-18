package AoC2023.Day18;

import AoC2023.AdventTask;

import java.util.List;

import static AoC2023.AdventTaskUtils.answerAs;

public class Task18A extends AdventTask {

    public Task18A() {
        super("Day18", "Task18A");
    }

    @Override
    public List<String> perform(List<String> input) {
        return answerAs(Dig.of(Instruction.createInstructions(input)).calculateDig());
    }
}
