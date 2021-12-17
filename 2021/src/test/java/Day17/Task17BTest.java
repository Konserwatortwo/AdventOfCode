package Day17;

import AoC2021.AdventTask;
import AoC2021.Day17.Task17B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task17BTest {

    private final AdventTask mockedTask = new Task17B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("target area: x=20..30, y=-10..-5");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("112", result.get(0));
    }
}
