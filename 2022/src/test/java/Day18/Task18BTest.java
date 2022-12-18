package Day18;

import AoC2022.AdventTask;
import AoC2022.Day18.Task18B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task18BTest {

    private final AdventTask mockedTask = new Task18B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1,1,1");
        report.add("2,1,1");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("10", result.get(0));

    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("2,2,2");
        report.add("1,2,2");
        report.add("3,2,2");
        report.add("2,1,2");
        report.add("2,3,2");
        report.add("2,2,1");
        report.add("2,2,3");
        report.add("2,2,4");
        report.add("2,2,6");
        report.add("1,2,5");
        report.add("3,2,5");
        report.add("2,1,5");
        report.add("2,3,5");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("58", result.get(0));
    }
}
