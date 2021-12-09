package Day7;

import AoC2021.AdventTask;
import AoC2021.Day7.Task7B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task7BTest {

    private final AdventTask mockedTask = new Task7B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("16,1,2,0,4,2,7,1,2,14");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("168", result.get(0));
    }

    @Test
    public void nextTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("6");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("0", result.get(0));
    }

    @Test
    public void anotherTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("0,6");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("12", result.get(0));
    }
}
