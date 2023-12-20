package Day20;

import AoC2023.AdventTask;
import AoC2023.Day20.Task20A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task20ATest {

    private final AdventTask mockedTask = new Task20A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("broadcaster -> a, b, c");
        report.add("%a -> b");
        report.add("%b -> c");
        report.add("%c -> inv");
        report.add("&inv -> a");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("32000000", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("broadcaster -> a");
        report.add("%a -> inv, con");
        report.add("&inv -> b");
        report.add("%b -> con");
        report.add("&con -> output");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("11687500", result.get(0));
    }
}
