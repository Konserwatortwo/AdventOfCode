package Day15;

import AoC2021.AdventTask;
import AoC2021.Day15.Task15B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task15BTest {

    private final AdventTask mockedTask = new Task15B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("0,9 -> 5,9");
        report.add("8,0 -> 0,8");
        report.add("9,4 -> 3,4");
        report.add("2,2 -> 2,1");
        report.add("7,0 -> 7,4");
        report.add("6,4 -> 2,0");
        report.add("0,9 -> 2,9");
        report.add("3,4 -> 1,4");
        report.add("0,0 -> 8,8");
        report.add("5,5 -> 8,2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("150", result.get(0));
    }
}
