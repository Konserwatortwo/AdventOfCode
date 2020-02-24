package AdventOfCode.Day4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task4ATest {

    @Test
    public void firstTest() {
        // Arrange
        int input = 111111;

        // Act
        boolean output = Task4A.checkNumber(input);

        // Assert
        assertTrue(output);
    }

    @Test
    public void secondTest() {
        // Arrange
        int input = 223450;

        // Act
        boolean output = Task4A.checkNumber(input);

        // Assert
        assertFalse(output);
    }

    @Test
    public void thirdTest() {
        // Arrange
        int input = 123789;

        // Act
        boolean output = Task4A.checkNumber(input);

        // Assert
        assertFalse(output);
    }
}