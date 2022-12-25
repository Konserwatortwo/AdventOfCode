package Day25;

import AoC2022.AdventTask;
import AoC2022.Day25.Task25A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task25ATest {

    private final AdventTask mockedTask = new Task25A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("1-0");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1-0", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = List.of("1=11-2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1=11-2", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = List.of("1-0---0");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1-0---0", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = List.of("1121-1110-1=0");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1121-1110-1=0", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = List.of("20", "1=0", "1-0");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2-0", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1=-0-2");
        report.add("12111");
        report.add("2=0=");
        report.add("21");
        report.add("2=01");
        report.add("111");
        report.add("20012");
        report.add("112");
        report.add("1=-1=");
        report.add("1-12");
        report.add("12");
        report.add("1=");
        report.add("122");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2=-1=0", result.get(0));
    }
}
