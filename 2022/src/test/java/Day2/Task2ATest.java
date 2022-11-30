package Day2;

import AoC2022.AdventTask;
import AoC2022.Day1.Task1A;
import AoC2022.Day2.Task2A;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task2ATest {

    private final AdventTask mockedTask = new Task2A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("150", result.get(0));
    }
}
