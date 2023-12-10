package Day10;

import AoC2023.AdventTask;
import AoC2023.Day10.Task10A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task10ATest {


    private final AdventTask mockedTask = new Task10A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add(".....");
        report.add(".S-7.");
        report.add(".|.|.");
        report.add(".L-J.");
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
        report.add("-L|F7");
        report.add("7S-7|");
        report.add("L|7||");
        report.add("-L-J|");
        report.add("L|-JF");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("..F7.");
        report.add(".FJ|.");
        report.add("SJ.L7");
        report.add("|F--J");
        report.add("LJ...");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("8", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("7-F7-");
        report.add(".FJ|7");
        report.add("SJLL7");
        report.add("|F--J");
        report.add("LJ.LJ");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("8", result.get(0));
    }
}
