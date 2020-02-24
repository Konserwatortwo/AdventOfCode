package AdventOfCode.Day2;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task2ATest {

    @Test
    public void firstTest() {
        // Arrange
        List<String> input = Collections.singletonList("1,9,10,3,2,3,11,0,99,30,40,50");

        // Act
        List<String> output = new Task2A().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("3500", output.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> input = Collections.singletonList("1,0,0,0,99");

        // Act
        List<String> output = new Task2A().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("2", output.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> input = Collections.singletonList("2,3,0,3,99");

        // Act
        List<String> output = new Task2A().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("2", output.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> input = Collections.singletonList("2,4,4,5,99,0");

        // Act
        List<String> output = new Task2A().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("2", output.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> input = Collections.singletonList("1,1,1,4,99,5,6,0,99");

        // Act
        List<String> output = new Task2A().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("30", output.get(0));
    }
}