package Day21;

import AoC2023.AdventTask;
import AoC2023.Day21.Task21A;
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
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("42", result.get(0));
    }
}
