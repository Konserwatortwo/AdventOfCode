package Day23;

import AoC2022.AdventTask;
import AoC2022.Day23.Task23B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task23BTest {

    private final AdventTask mockedTask = new Task23B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add(".....");
        report.add("..##.");
        report.add("..#..");
        report.add(".....");
        report.add("..##.");
        report.add(".....");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("....#..");
        report.add("..###.#");
        report.add("#...#.#");
        report.add(".#...##");
        report.add("#.###..");
        report.add("##.#.##");
        report.add(".#..#..");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("20", result.get(0));
    }
}
