package Day11;

import AoC2023.AdventTask;
import AoC2023.Day11.Task11A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task11ATest {

    private final AdventTask mockedTask = new Task11A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...#......");
        report.add(".......#..");
        report.add("#.........");
        report.add("..........");
        report.add("......#...");
        report.add(".#........");
        report.add(".........#");
        report.add("..........");
        report.add(".......#..");
        report.add("#...#.....");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("374", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...#......");
        report.add(".......#..");
        report.add("#.........");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("28", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("#.........");
        report.add("..........");
        report.add("......#...");
        report.add(".#........");
        report.add(".........#");
        report.add("..........");
        report.add(".......#..");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("112", result.get(0));
    }
}
