package Day9;

import AoC2022.AdventTask;
import AoC2022.Day2.Task2A;
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
        report.add("2199943210");
        report.add("3987894921");
        report.add("9856789892");
        report.add("8767896789");
        report.add("9899965678");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1134", result.get(0));
    }
}
