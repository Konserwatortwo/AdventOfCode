package Day2;

import AoC2022.AdventTask;
import AoC2022.Day2.Task2A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task2ATest {

    private final AdventTask mockedTask = new Task2A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("A Y");
        report.add("B X");
        report.add("C Z");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("15", result.get(0));
    }
}
