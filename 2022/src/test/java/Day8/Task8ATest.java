package Day8;

import AoC2022.AdventTask;
import AoC2022.Day8.Task8A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task8ATest {

    private final AdventTask mockedTask = new Task8A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("30373");
        report.add("25512");
        report.add("65332");
        report.add("33549");
        report.add("35390");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("21", result.get(0));
    }
}
