package Day23;

import AoC2022.AdventTask;
import AoC2022.Day23.Task23A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task23ATest {

    private final AdventTask mockedTask = new Task23A();

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
        Assert.assertEquals("25", result.get(0));
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
        Assert.assertEquals("110", result.get(0));
    }
}
