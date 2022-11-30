package Day7;

import AoC2022.AdventTask;
import AoC2022.Day2.Task2A;
import AoC2022.Day7.Task7A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task7ATest {

    private final AdventTask mockedTask = new Task7A();

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
        Assert.assertEquals("37", result.get(0));
    }
}
