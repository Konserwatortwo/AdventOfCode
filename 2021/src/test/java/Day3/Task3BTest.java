package Day3;

import AoC2021.AdventTask;
import AoC2021.Day3.Task3B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task3BTest {

    private final AdventTask mockedTask = new Task3B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("230", result.get(0));
    }
}
