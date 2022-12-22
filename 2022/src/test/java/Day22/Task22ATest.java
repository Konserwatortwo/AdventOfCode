package Day22;

import AoC2022.AdventTask;
import AoC2022.Day22.Task22A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task22ATest {

    private final AdventTask mockedTask = new Task22A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("        ...#");
        report.add("        .#..");
        report.add("        #...");
        report.add("        ....");
        report.add("...#.......#");
        report.add("........#...");
        report.add("..#....#....");
        report.add("..........#.");
        report.add("        ...#....");
        report.add("        .....#..");
        report.add("        .#......");
        report.add("        ......#.");
        report.add("");
        report.add("10R5L5R10L4R5L5");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("6032", result.get(0));
    }
}
