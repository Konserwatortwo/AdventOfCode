package Day2;

import AoC2020.AdventTask;
import AoC2020.Day2.Task2B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task2BTest {

    private final AdventTask mockedTask = new Task2B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1-3 a: abcde");
        report.add("1-3 b: cdefg");
        report.add("2-9 c: ccccccccc");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }
}
