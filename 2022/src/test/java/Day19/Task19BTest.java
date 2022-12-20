package Day19;

import AoC2022.AdventTask;
import AoC2022.Day19.Task19B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task19BTest {

    private final AdventTask mockedTask = new Task19B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Blueprint 1: Each ore robot costs 4 ore. " +
                "Each clay robot costs 2 ore. " +
                "Each obsidian robot costs 3 ore and 14 clay. " +
                "Each geode robot costs 2 ore and 7 obsidian.\n");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("56", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Blueprint 2: Each ore robot costs 2 ore. " +
                "Each clay robot costs 3 ore. " +
                "Each obsidian robot costs 3 ore and 8 clay. " +
                "Each geode robot costs 3 ore and 12 obsidian.\n");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("62", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Blueprint 1: Each ore robot costs 4 ore. " +
                "Each clay robot costs 4 ore. " +
                "Each obsidian robot costs 4 ore and 14 clay. " +
                "Each geode robot costs 3 ore and 16 obsidian.\n");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("11", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Blueprint 2: Each ore robot costs 4 ore. " +
                "Each clay robot costs 3 ore. " +
                "Each obsidian robot costs 3 ore and 11 clay. " +
                "Each geode robot costs 4 ore and 7 obsidian.\n");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("49", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Blueprint 3: Each ore robot costs 4 ore. " +
                "Each clay robot costs 4 ore. " +
                "Each obsidian robot costs 3 ore and 14 clay. " +
                "Each geode robot costs 3 ore and 8 obsidian.\n");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("25", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Blueprint 1: Each ore robot costs 4 ore. " +
                "Each clay robot costs 4 ore. " +
                "Each obsidian robot costs 4 ore and 14 clay. " +
                "Each geode robot costs 3 ore and 16 obsidian.\n");
        report.add("Blueprint 2: Each ore robot costs 4 ore. " +
                "Each clay robot costs 3 ore. " +
                "Each obsidian robot costs 3 ore and 11 clay. " +
                "Each geode robot costs 4 ore and 7 obsidian.\n");
        report.add("Blueprint 3: Each ore robot costs 4 ore. " +
                "Each clay robot costs 4 ore. " +
                "Each obsidian robot costs 3 ore and 14 clay. " +
                "Each geode robot costs 3 ore and 8 obsidian.\n");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("13475", result.get(0));
    }
}
