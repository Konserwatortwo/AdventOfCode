package Day11;

import AoC2022.AdventTask;
import AoC2022.Day11.Task11A;
import AoC2022.Day11.Task11B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Day11.MonkeyData.*;
import static Day11.MonkeyData.THIRD_MONKEY;

public class Task11BTest {

    private final Task11B mockedTask = new Task11B();

    @Test
    public void stateAfter1Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 1);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("24", result.get(0));
    }

    @Test
    public void stateAfter20Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 20);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("10197", result.get(0));
    }

    @Test
    public void stateAfter1000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 1000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("27019168", result.get(0));
    }

    @Test
    public void stateAfter2000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 2000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("108263829", result.get(0));
    }

    @Test
    public void stateAfter3000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 3000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("243843334", result.get(0));
    }

    @Test
    public void stateAfter4000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 4000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("433783826", result.get(0));
    }

    @Test
    public void stateAfter5000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 5000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("677950000", result.get(0));
    }

    @Test
    public void stateAfter6000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 6000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("976497976", result.get(0));
    }

    @Test
    public void stateAfter7000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 7000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1328891200", result.get(0));
    }

    @Test
    public void stateAfter8000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 8000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1736135168", result.get(0));
    }

    @Test
    public void stateAfter9000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 9000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2197354615", result.get(0));
    }

    @Test
    public void stateAfter10000Iterations() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report, 10000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2713310158", result.get(0));
    }
}
