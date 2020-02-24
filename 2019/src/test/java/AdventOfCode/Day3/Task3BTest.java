package AdventOfCode.Day3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task3BTest {

    @Test
    public void firstTest() {
        // Arrange
        List<String> input = new ArrayList<>();
        input.add("R8,U5,L5,D3");
        input.add("U7,R6,D4,L4");

        // Act
        List<String> output = new Task3B().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("30", output.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> input = new ArrayList<>();
        input.add("R75,D30,R83,U83,L12,D49,R71,U7,L72");
        input.add("U62,R66,U55,R34,D71,R55,D58,R83");

        // Act
        List<String> output = new Task3B().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("610", output.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> input = new ArrayList<>();
        input.add("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
        input.add("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");

        // Act
        List<String> output = new Task3B().perform(input);

        // Assert
        assertEquals(1, output.size());
        assertEquals("410", output.get(0));
    }
}