package Day10;

import AoC2023.AdventTask;
import AoC2023.Day10.Task10B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task10BTest {

    private final AdventTask mockedTask = new Task10B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".S-------7.");
        report.add(".|F-----7|.");
        report.add(".||.....||.");
        report.add(".||.....||.");
        report.add(".|L-7.F-J|.");
        report.add(".|..|.|..|.");
        report.add(".L--J.L--J.");
        report.add("...........");

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
        report.add("..........");
        report.add(".S------7.");
        report.add(".|F----7|.");
        report.add(".||....||.");
        report.add(".||....||.");
        report.add(".|L-7F-J|.");
        report.add(".|..||..|.");
        report.add(".L--JL--J.");
        report.add("..........");

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
        report.add(".F----7F7F7F7F-7....");
        report.add(".|F--7||||||||FJ....");
        report.add(".||.FJ||||||||L7....");
        report.add("FJL7L7LJLJ||LJ.L-7..");
        report.add("L--J.L7...LJS7F-7L7.");
        report.add("....F-J..F7FJ|L7L7L7");
        report.add("....L7.F7||L7|.L7L7|");
        report.add(".....|FJLJ|FJ|F7|.LJ");
        report.add("....FJL-7.||.||||...");
        report.add("....L---J.LJ.LJLJ...");

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
        report.add("FF7FSF7F7F7F7F7F---7");
        report.add("L|LJ||||||||||||F--J");
        report.add("FL-7LJLJ||||||LJL-77");
        report.add("F--JF--7||LJLJ7F7FJ-");
        report.add("L---JF-JLJ.||-FJLJJ7");
        report.add("|F|F-JF---7F7-L7L|7|");
        report.add("|FFJF7L7F-JF7|JL---7");
        report.add("7-L-JL7||F7|L7F-7F7|");
        report.add("L.L7LFJ|||||FJL7||LJ");
        report.add("L7JLJL-JLJLJL--JLJ.L");
        
        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("10", result.get(0));
    }
}
