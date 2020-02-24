package AdventOfCode.Day4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task4BTest {

    @Test
    public void firstTest() {
        // Arrange
        int input = 112233;

        // Act
        boolean output = Task4B.anotherCheck(input);

        // Assert
        assertTrue(output);
    }

    @Test
    public void secondTest() {
        // Arrange
        int input = 123444;

        // Act
        boolean output = Task4B.anotherCheck(input);

        // Assert
        assertFalse(output);
    }

    @Test
    public void thirdTest() {
        // Arrange
        int input = 111122;

        // Act
        boolean output = Task4B.anotherCheck(input);

        // Assert
        assertTrue(output);
    }
}