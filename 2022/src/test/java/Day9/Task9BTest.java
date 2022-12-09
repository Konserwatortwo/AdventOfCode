package Day9;

import AoC2022.AdventTask;
import AoC2022.Day9.Task9B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task9BTest {

    private final AdventTask mockedTask = new Task9B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("R 4");
        report.add("U 4");
        report.add("L 3");
        report.add("D 1");
        report.add("R 4");
        report.add("D 1");
        report.add("L 5");
        report.add("R 2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("R 5");
        report.add("U 8");
        report.add("L 8");
        report.add("D 3");
        report.add("R 17");
        report.add("D 10");
        report.add("L 25");
        report.add("U 20");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("36", result.get(0));
    }
}
