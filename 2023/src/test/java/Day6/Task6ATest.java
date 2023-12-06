package Day6;

import AoC2023.AdventTask;
import AoC2023.Day6.Task6A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task6ATest {

    private final AdventTask mockedTask = new Task6A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Time:      7  15   30");
        report.add("Distance:  9  40  200");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("288", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Time:        48     98     90     83");
        report.add("Distance:   390   1103   1112   1360");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4568778", result.get(0));
    }
}
