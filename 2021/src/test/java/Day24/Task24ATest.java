package Day24;

import AoC2021.AdventTask;
import AoC2021.Day23.Task23A;
import AoC2021.Day24.ArithmeticLogicUnit;
import AoC2021.Day24.Task24A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task24ATest {

    private final AdventTask mockedTask = new Task24A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> instructions = new ArrayList<>();
        instructions.add("inp z");
        instructions.add("inp x");
        instructions.add("mul z 3");
        instructions.add("eql z x");
        int[] inputNumbers = {1, 3};

        // Act
        ArithmeticLogicUnit logicUnit = new ArithmeticLogicUnit(instructions);
        boolean value = logicUnit.checkNumbers(inputNumbers);

        // Assert
        Assert.assertFalse(value);
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> instructions = new ArrayList<>();
        instructions.add("inp z");
        instructions.add("inp x");
        instructions.add("mul z 3");
        instructions.add("eql z x");
        int[] inputNumbers = {1, 4};

        // Act
        ArithmeticLogicUnit logicUnit = new ArithmeticLogicUnit(instructions);
        boolean value = logicUnit.checkNumbers(inputNumbers);

        // Assert
        Assert.assertTrue(value);
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> instructions = new ArrayList<>();
        instructions.add("inp w");
        instructions.add("add z w");
        instructions.add("mod z 2");
        instructions.add("div w 2");
        instructions.add("add y w");
        instructions.add("mod y 2");
        instructions.add("div w 2");
        instructions.add("add x w");
        instructions.add("mod x 2");
        instructions.add("div w 2");
        instructions.add("mod w 2");
        int[] inputNumbers = {1};

        // Act
        ArithmeticLogicUnit logicUnit = new ArithmeticLogicUnit(instructions);
        boolean value = logicUnit.checkNumbers(inputNumbers);

        // Assert
        Assert.assertFalse(value);
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> instructions = new ArrayList<>();
        instructions.add("inp w");
        instructions.add("add z w");
        instructions.add("mod z 2");
        instructions.add("div w 2");
        instructions.add("add y w");
        instructions.add("mod y 2");
        instructions.add("div w 2");
        instructions.add("add x w");
        instructions.add("mod x 2");
        instructions.add("div w 2");
        instructions.add("mod w 2");
        int[] inputNumbers = {2};

        // Act
        ArithmeticLogicUnit logicUnit = new ArithmeticLogicUnit(instructions);
        boolean value = logicUnit.checkNumbers(inputNumbers);

        // Assert
        Assert.assertTrue(value);
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> instructions = new ArrayList<>();
        instructions.add("inp w");
        instructions.add("add z w");
        instructions.add("mod z 2");
        instructions.add("div w 2");
        instructions.add("add y w");
        instructions.add("mod y 2");
        instructions.add("div w 2");
        instructions.add("add x w");
        instructions.add("mod x 2");
        instructions.add("div w 2");
        instructions.add("mod w 2");
        int[] inputNumbers = {100, 6, 7};

        // Act
        ArithmeticLogicUnit logicUnit = new ArithmeticLogicUnit(instructions);
        boolean value = logicUnit.checkNumbers(inputNumbers);

        // Assert
        Assert.assertTrue(value);
    }
}
