package Day6;

import AoC2022.AdventTask;
import AoC2022.Day6.Task6B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task6BTest {

    private final AdventTask mockedTask = new Task6B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("bvwbjplbgvbhsrlpgdmjqwftvncz");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("23", result.get(0));
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
        Assert.assertEquals("23", result.get(0));
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
        Assert.assertEquals("29", result.get(0));
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
        Assert.assertEquals("26", result.get(0));
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
        Assert.assertEquals("19", result.get(0));
    }
}
