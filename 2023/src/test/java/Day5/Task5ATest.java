package Day5;

import AoC2023.AdventTask;
import AoC2023.Day5.Task5A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task5ATest {

    private final AdventTask mockedTask = new Task5A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("seeds: 79");
        report.add("");
        report.add("seed-to-soil map:");
        report.add("50 98 2");
        report.add("52 50 48");
        report.add("");
        report.add("soil-to-fertilizer map:");
        report.add("0 15 37");
        report.add("37 52 2");
        report.add("39 0 15");
        report.add("");
        report.add("fertilizer-to-water map:");
        report.add("49 53 8");
        report.add("0 11 42");
        report.add("42 0 7");
        report.add("57 7 4");
        report.add("");
        report.add("water-to-light map:");
        report.add("88 18 7");
        report.add("18 25 70");
        report.add("");
        report.add("light-to-temperature map:");
        report.add("45 77 23");
        report.add("81 45 19");
        report.add("68 64 13");
        report.add("");
        report.add("temperature-to-humidity map:");
        report.add("0 69 1");
        report.add("1 0 69");
        report.add("");
        report.add("humidity-to-location map:");
        report.add("60 56 37");
        report.add("56 93 4");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("82", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("seeds: 79 14");
        report.add("");
        report.add("seed-to-soil map:");
        report.add("50 98 2");
        report.add("52 50 48");
        report.add("");
        report.add("soil-to-fertilizer map:");
        report.add("0 15 37");
        report.add("37 52 2");
        report.add("39 0 15");
        report.add("");
        report.add("fertilizer-to-water map:");
        report.add("49 53 8");
        report.add("0 11 42");
        report.add("42 0 7");
        report.add("57 7 4");
        report.add("");
        report.add("water-to-light map:");
        report.add("88 18 7");
        report.add("18 25 70");
        report.add("");
        report.add("light-to-temperature map:");
        report.add("45 77 23");
        report.add("81 45 19");
        report.add("68 64 13");
        report.add("");
        report.add("temperature-to-humidity map:");
        report.add("0 69 1");
        report.add("1 0 69");
        report.add("");
        report.add("humidity-to-location map:");
        report.add("60 56 37");
        report.add("56 93 4");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("43", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("seeds: 79 14 55 13");
        report.add("");
        report.add("seed-to-soil map:");
        report.add("50 98 2");
        report.add("52 50 48");
        report.add("");
        report.add("soil-to-fertilizer map:");
        report.add("0 15 37");
        report.add("37 52 2");
        report.add("39 0 15");
        report.add("");
        report.add("fertilizer-to-water map:");
        report.add("49 53 8");
        report.add("0 11 42");
        report.add("42 0 7");
        report.add("57 7 4");
        report.add("");
        report.add("water-to-light map:");
        report.add("88 18 7");
        report.add("18 25 70");
        report.add("");
        report.add("light-to-temperature map:");
        report.add("45 77 23");
        report.add("81 45 19");
        report.add("68 64 13");
        report.add("");
        report.add("temperature-to-humidity map:");
        report.add("0 69 1");
        report.add("1 0 69");
        report.add("");
        report.add("humidity-to-location map:");
        report.add("60 56 37");
        report.add("56 93 4");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("35", result.get(0));
    }
}
