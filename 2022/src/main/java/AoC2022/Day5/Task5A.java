package AoC2022.Day5;

import AoC2022.AdventTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task5A extends AdventTask {

    public Task5A() {
        super("Day5", "Task5A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<String> stackInstructions = new ArrayList<>();
        List<Instruction> instructions = new ArrayList<>();
        boolean areInstructionStarted = false;
        for (String line : input) {
            if (line.isBlank()) {
                areInstructionStarted = true;
            } else if (areInstructionStarted) {
                instructions.add(new Instruction(line));
            } else {
                stackInstructions.add(line);
            }
        }
        List<Stack<Character>> stacks = readInitialStacks(stackInstructions);

        for (Instruction instruction : instructions) {
            performInstruction(instruction, stacks);
        }

        return List.of(retrieveTop(stacks));
    }

    private List<Stack<Character>> readInitialStacks(List<String> lines) {
        List<Stack<Character>> stacks = new ArrayList<>();
        char[] charArray = lines.get(lines.size() - 1).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                Stack<Character> stack = new Stack<>();
                for (int j = lines.size() - 1; j >= 0; j--) {
                    char character = lines.get(j).charAt(i);
                    if (character != ' ') {
                        stack.add(character);
                    }
                }
                stacks.add(stack);
            }
        }
        return stacks;
    }

    private void performInstruction(Instruction instruction, List<Stack<Character>> stacks) {
        Stack<Character> from = stacks.get(instruction.getFrom() - 1);
        Stack<Character> to = stacks.get(instruction.getTo() - 1);
        for (int i = 0; i < instruction.getTimes(); i++) {
            Character character = from.pop();
            to.push(character);
        }
    }

    private String retrieveTop(List<Stack<Character>> stacks) {
        StringBuilder builder = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            builder.append(stack.peek());
        }
        return builder.toString();
    }
}
