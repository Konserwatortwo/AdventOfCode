package Day11;

import AoC2023.Day11.Task11B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task11BTest {

    private final Task11B mockedTask = new Task11B();

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
        Assert.assertEquals("82000210", result.get(0));
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
        Assert.assertEquals("10000008", result.get(0));
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
        Assert.assertEquals("36000040", result.get(0));
    }
}
