package Day6;

import AoC2022.AdventTask;
import AoC2022.Day6.Task6A;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task6ATest {

    private final AdventTask mockedTask = new Task6A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("bvwbjplbgvbhsrlpgdmjqwftvncz");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = List.of("nppdvjthqldpwncqszvftbrmjlhg");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("6", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = List.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("10", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = List.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("11", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = List.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("7", result.get(0));
    }
}
