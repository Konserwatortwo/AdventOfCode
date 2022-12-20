package Day20;

import AoC2022.AdventTask;
import AoC2022.Day20.Task20A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task20ATest {

    private final AdventTask mockedTask = new Task20A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1");
        report.add("2");
        report.add("-3");
        report.add("3");
        report.add("-2");
        report.add("0");
        report.add("4");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("7");
        report.add("14");
        report.add("-21");
        report.add("21");
        report.add("-14");
        report.add("0");
        report.add("28");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("21", result.get(0));
    }
}
