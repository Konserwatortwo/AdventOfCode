package Day1;

import AoC2020.AdventTask;
import AoC2020.Day1.Task1B;
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
        report.add("1721");
        report.add("979");
        report.add("366");
        report.add("299");
        report.add("675");
        report.add("1456");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("241861950", result.get(0));
    }
}
