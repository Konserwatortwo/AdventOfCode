package Day16;

import AoC2022.AdventTask;
import AoC2022.Day16.Task16B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task16BTest {

    private final AdventTask mockedTask = new Task16B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("C200B40A82");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("04005AC33890");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("54", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("880086C3E88112");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("7", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("CE00C43D881120");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("9", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("D8005AC2A8F0");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("F600BC2D8F");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("0", result.get(0));
    }

    @Test
    public void seventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("9C005AC2F8F0");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("0", result.get(0));
    }

    @Test
    public void eighthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("9C0141080250320F1802104A08");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }
}
