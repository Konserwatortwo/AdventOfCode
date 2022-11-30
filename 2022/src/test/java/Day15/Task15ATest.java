package Day15;

import AoC2022.AdventTask;
import AoC2022.Day15.Task15A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task15ATest {

    private final AdventTask mockedTask = new Task15A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1163751742");
        report.add("1381373672");
        report.add("2136511328");
        report.add("3694931569");
        report.add("7463417111");
        report.add("1319128137");
        report.add("1359912421");
        report.add("3125421639");
        report.add("1293138521");
        report.add("2311944581");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("40", result.get(0));
    }
}
