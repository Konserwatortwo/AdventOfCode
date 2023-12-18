package Day18;

import AoC2023.AdventTask;
import AoC2023.Day18.Task18B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task18BTest {

    private final AdventTask mockedTask = new Task18B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("R 6 (#70c710)");
        report.add("D 5 (#0dc571)");
        report.add("L 2 (#5713f0)");
        report.add("D 2 (#d2c081)");
        report.add("R 2 (#59c680)");
        report.add("D 2 (#411b91)");
        report.add("L 5 (#8ceee2)");
        report.add("U 2 (#caa173)");
        report.add("L 1 (#1b58a2)");
        report.add("U 2 (#caa171)");
        report.add("R 2 (#7807d2)");
        report.add("U 3 (#a77fa3)");
        report.add("L 2 (#015232)");
        report.add("U 2 (#7a21e3)");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("952408144115", result.get(0));
    }
}
