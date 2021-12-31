package Day23;

import AoC2021.AdventTask;
import AoC2021.Day22.Task22A;
import AoC2021.Day23.Task23A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task23ATest {

    private final AdventTask mockedTask = new Task23A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("BA");
        report.add("CD");
        report.add("BC");
        report.add("DA");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("12521", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("CD");
        report.add("CD");
        report.add("AB");
        report.add("BA");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("18282", result.get(0));
    }
}
