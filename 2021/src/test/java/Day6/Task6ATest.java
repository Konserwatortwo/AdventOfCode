package Day6;

import AoC2021.AdventTask;
import AoC2021.Day2.Task2A;
import AoC2021.Day6.Task6A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task6ATest {

    private final AdventTask mockedTask = new Task6A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("3,4,3,1,2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5934", result.get(0));
    }
}
