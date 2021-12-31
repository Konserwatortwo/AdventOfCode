package AoC2021.Day24;

import AoC2021.Day24.enums.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticLogicUnit {

    private final List<Section> sections;

    public ArithmeticLogicUnit(List<String> instructions) {
        this.sections = retrieveSections(instructions);
    }

    private List<Section> retrieveSections(List<String> instructions) {
        List<SectionCreator> creators = new ArrayList<>();
        SectionCreator sectionCreator = null;

        for (String instruction : instructions) {
            if (instruction.contains("inp")) {
                sectionCreator = new SectionCreator(Symbol.retrieveSymbol(instruction.split(" ")[1]));
                creators.add(sectionCreator);
            } else {
                assert sectionCreator != null;
                sectionCreator.addInstructionsForSection(instruction);
            }
        }

        return creators.stream()
                .map(SectionCreator::retrieveSection)
                .collect(Collectors.toList());
    }

    public boolean checkNumbers(int[] number) {
        Register register = new Register();
        for (int i = 0, sectionsSize = sections.size(); i < sectionsSize; i++) {
            register = sections.get(i).executeInstructions(number[i], register);
            System.out.println(register);
        }
        return register.getValueForSymbol(Symbol.Z) == 0;
    }

    public boolean fastCheck(int[] number) {
        boolean result = number[0] == number[13] - 5;
        result &= number[1] == number[12] - 4;
        result &= number[2] == number[11] + 8;
        result &= number[3] == number[4] - 1;
        result &= number[5] == number[6] + 7;
        result &= number[7] == number[10] + 3;
        result &= number[8] == number[9] + 5;
        return result;
    }

    public List<Long> generateVersions() {
        List<Long> result = new ArrayList<>();
        for (int first = 1; first <= 4; first++) {
            for (int second = 1; second <= 5; second++) {
                for (int fourth = 1; fourth <= 8; fourth++) {
                    for (int sixth = 8; sixth <= 9; sixth++) {
                        for (int eighth = 4; eighth <= 9; eighth++) {
                            for (int ninth = 6; ninth <= 9; ninth++) {
                                result.add(generateVersion(first, second, fourth, sixth, eighth, ninth));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public Long generateVersion(int... vales) {
        StringBuilder builder = new StringBuilder();
        builder.append(vales[0]);
        builder.append(vales[1]);
        builder.append(9);
        builder.append(vales[2]);
        builder.append(vales[2] + 1);
        builder.append(vales[3]);
        builder.append(vales[3] - 7);
        builder.append(vales[4]);
        builder.append(vales[5]);
        builder.append(vales[5] - 5);
        builder.append(vales[4] - 3);
        builder.append(1);
        builder.append(vales[1] + 4);
        builder.append(vales[0] + 5);
        return Long.parseLong(builder.toString());
    }

    static class SectionCreator {
        private final Symbol inputSymbolForSection;
        private final List<String> instructionsForSection;

        public SectionCreator(Symbol inputSymbolForSection) {
            this.inputSymbolForSection = inputSymbolForSection;
            this.instructionsForSection = new ArrayList<>();
        }

        public void addInstructionsForSection(String line) {
            instructionsForSection.add(line);
        }

        public Section retrieveSection() {
            return new Section(inputSymbolForSection, instructionsForSection);
        }
    }
}
