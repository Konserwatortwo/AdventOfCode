package Day3;

import AoC2023.AdventTask;
import AoC2023.Day3.Task3B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task3BTest {

    private final AdventTask mockedTask = new Task3B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("R8,U5,L5,D3");
        report.add("U7,R6,D4,L4");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("30", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("R75,D30,R83,U83,L12,D49,R71,U7,L72");
        report.add("U62,R66,U55,R34,D71,R55,D58,R83");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("610", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
        report.add("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("410", result.get(0));
    }
}
