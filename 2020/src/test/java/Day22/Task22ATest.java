package Day22;

import AoC2020.AdventTask;
import AoC2020.Day22.Task22A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task22ATest {

    private final AdventTask mockedTask = new Task22A();

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
