package Day1;

import AoC2023.AdventTask;
import AoC2023.Day1.Task1B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task1BTest {

    private final AdventTask mockedTask = new Task1B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("two1nine");
        report.add("eightwothree");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("112", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("two1nine");
        report.add("eightwothree");
        report.add("abcone2threexyz");
        report.add("xtwone3four");
        report.add("4nineeightseven2");
        report.add("zoneight234");
        report.add("7pqrstsixteen");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("281", result.get(0));
    }
}
