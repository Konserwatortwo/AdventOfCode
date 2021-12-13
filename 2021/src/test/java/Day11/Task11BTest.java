package Day11;

import AoC2021.AdventTask;
import AoC2021.Day11.Task11B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task11BTest {

    private final AdventTask mockedTask = new Task11B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("5483143223");
        report.add("2745854711");
        report.add("5264556173");
        report.add("6141336146");
        report.add("6357385478");
        report.add("4167524645");
        report.add("2176841721");
        report.add("6882881134");
        report.add("4846848554");
        report.add("5283751526");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("195", result.get(0));
    }
}
