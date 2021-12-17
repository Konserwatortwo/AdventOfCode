package Day16;

import AoC2021.AdventTask;
import AoC2021.Day16.Task16A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task16ATest {

    private final AdventTask mockedTask = new Task16A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("D2FE28");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("6", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("38006F45291200");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("9", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("EE00D40C823060");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("14", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("8A004A801A8002F478");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("16", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("620080001611562C8802118E34");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("12", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("C0015000016115A2E0802F182340");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("23", result.get(0));
    }

    @Test
    public void seventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("A0016C880162017C3686B18A3D4780");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("31", result.get(0));
    }
}
