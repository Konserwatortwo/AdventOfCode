package Day22;

import AoC2022.Day22.Task22B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task22BTest {

    private final Task22B mockedTask = new Task22B();

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
        List<String> result = mockedTask.perform(report, 4);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5031", result.get(0));
    }
}
