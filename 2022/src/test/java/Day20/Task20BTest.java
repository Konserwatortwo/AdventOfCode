package Day20;

import AoC2022.AdventTask;
import AoC2022.Day20.Task20B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task20BTest {

    private final AdventTask mockedTask = new Task20B();

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
        Assert.assertEquals("1623178306", result.get(0));
    }
}
