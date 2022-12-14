package Day14;

import AoC2022.Day14.Task14A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task14ATest {

    private final Task14A mockedTask = new Task14A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("498,4 -> 498,6 -> 496,6");
        report.add("503,4 -> 502,4 -> 502,9 -> 494,9");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("24", result.get(0));
    }
}
