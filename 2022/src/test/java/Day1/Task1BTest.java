package Day1;

import AoC2022.AdventTask;
import AoC2022.Day1.Task1B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task1BTest {

    private final AdventTask mockedTask = new Task1B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1000");
        report.add("2000");
        report.add("3000");
        report.add("");
        report.add("4000");
        report.add("");
        report.add("5000");
        report.add("6000");
        report.add("");
        report.add("7000");
        report.add("8000");
        report.add("9000");
        report.add("");
        report.add("10000");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("45000", result.get(0));
    }
}
