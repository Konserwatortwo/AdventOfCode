package Day21;

import AoC2020.AdventTask;
import AoC2020.Day21.Task21A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task21ATest {

    private final AdventTask mockedTask = new Task21A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1000");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("24000", result.get(0));
    }
}
