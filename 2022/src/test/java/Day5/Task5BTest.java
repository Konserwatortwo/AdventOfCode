package Day5;

import AoC2022.AdventTask;
import AoC2022.Day5.Task5B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task5BTest {

    private final AdventTask mockedTask = new Task5B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("    [D]    ");
        report.add("[N] [C]    ");
        report.add("[Z] [M] [P]");
        report.add(" 1   2   3 ");
        report.add("");
        report.add("move 1 from 2 to 1");
        report.add("move 3 from 1 to 3");
        report.add("move 2 from 2 to 1");
        report.add("move 1 from 1 to 2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("MCD", result.get(0));
    }
}
