package Day8;

import AoC2023.AdventTask;
import AoC2023.Day8.Task8B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task8BTest {

    private final AdventTask mockedTask = new Task8B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("LR");
        report.add("");
        report.add("11A = (11B, XXX)");
        report.add("11B = (XXX, 11Z)");
        report.add("11Z = (11B, XXX)");
        report.add("22A = (22B, XXX)");
        report.add("22B = (22C, 22C)");
        report.add("22C = (22Z, 22Z)");
        report.add("22Z = (22B, 22B)");
        report.add("XXX = (XXX, XXX)");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("6", result.get(0));
    }
}
