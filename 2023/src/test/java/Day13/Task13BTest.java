package Day13;

import AoC2023.AdventTask;
import AoC2023.Day13.Task13B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task13BTest {

    private final AdventTask mockedTask = new Task13B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("#.##..##.");
        report.add("..#.##.#.");
        report.add("##......#");
        report.add("##......#");
        report.add("..#.##.#.");
        report.add("..##..##.");
        report.add("#.#.##.#.");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("300", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("#...##..#");
        report.add("#....#..#");
        report.add("..##..###");
        report.add("#####.##.");
        report.add("#####.##.");
        report.add("..##..###");
        report.add("#....#..#");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("100", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("#.##..##.");
        report.add("..#.##.#.");
        report.add("##......#");
        report.add("##......#");
        report.add("..#.##.#.");
        report.add("..##..##.");
        report.add("#.#.##.#.");
        report.add("");
        report.add("#...##..#");
        report.add("#....#..#");
        report.add("..##..###");
        report.add("#####.##.");
        report.add("#####.##.");
        report.add("..##..###");
        report.add("#....#..#");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("400", result.get(0));
    }
}
