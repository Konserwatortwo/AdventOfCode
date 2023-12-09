package Day9;

import AoC2023.AdventTask;
import AoC2023.Day9.Task9A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task9ATest {

    private final AdventTask mockedTask = new Task9A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("0 3 6 9 12 15");
        report.add("1 3 6 10 15 21");
        report.add("10 13 16 21 30 45");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("114", result.get(0));
    }
}
