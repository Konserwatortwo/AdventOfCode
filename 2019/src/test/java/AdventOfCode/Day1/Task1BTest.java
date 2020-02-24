package AdventOfCode.Day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task1BTest {

    @Test
    public void firstTest() {
        // Arrange
        List<String> input = Collections.singletonList("14");

        // Act
        List<String> output = new Task1B().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("2", output.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> input = Collections.singletonList("1969");

        // Act
        List<String> output = new Task1B().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("966", output.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> input = Collections.singletonList("100756");

        // Act
        List<String> output = new Task1B().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("50346", output.get(0));
    }
}