package Day8;

import AoC2023.AdventTask;
import AoC2023.Day8.Task8A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task8ATest {

    private final AdventTask mockedTask = new Task8A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("RL");
        report.add("");
        report.add("AAA = (BBB, CCC)");
        report.add("BBB = (DDD, EEE)");
        report.add("CCC = (ZZZ, GGG)");
        report.add("DDD = (DDD, DDD)");
        report.add("EEE = (EEE, EEE)");
        report.add("GGG = (GGG, GGG)");
        report.add("ZZZ = (ZZZ, ZZZ)");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("LLR");
        report.add("");
        report.add("AAA = (BBB, BBB)");
        report.add("BBB = (AAA, ZZZ)");
        report.add("ZZZ = (ZZZ, ZZZ)");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("6", result.get(0));
    }
}
