package Day4;

import AoC2022.AdventTask;
import AoC2022.Day4.Task4B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task4BTest {

    private final AdventTask mockedTask = new Task4B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("2-4,6-8");
        report.add("2-3,4-5");
        report.add("5-7,7-9");
        report.add("2-8,3-7");
        report.add("6-6,4-6");
        report.add("2-6,4-8");


        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4", result.get(0));
    }
}
