package Day13;

import AoC2022.AdventTask;
import AoC2022.Day13.Task13A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task13ATest {

    private final AdventTask mockedTask = new Task13A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("6,10");
        report.add("0,14");
        report.add("9,10");
        report.add("0,3");
        report.add("10,4");
        report.add("4,11");
        report.add("6,0");
        report.add("6,12");
        report.add("4,1");
        report.add("0,13");
        report.add("10,12");
        report.add("3,4");
        report.add("3,0");
        report.add("8,4");
        report.add("1,10");
        report.add("2,14");
        report.add("8,10");
        report.add("9,0");
        report.add("");
        report.add("fold along y=7");
        report.add("fold along x=5");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("17", result.get(0));
    }
}
