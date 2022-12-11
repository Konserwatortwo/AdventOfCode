package Day10;

import AoC2022.AdventTask;
import AoC2022.Day10.Task10A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Day10.InstructionData.*;

public class Task10ATest {


    private final AdventTask mockedTask = new Task10A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("420", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);
        report.addAll(TO_SECOND_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1560", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);
        report.addAll(TO_SECOND_CHECK);
        report.addAll(TO_THIRD_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3360", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);
        report.addAll(TO_SECOND_CHECK);
        report.addAll(TO_THIRD_CHECK);
        report.addAll(TO_FORTH_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("6300", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);
        report.addAll(TO_SECOND_CHECK);
        report.addAll(TO_THIRD_CHECK);
        report.addAll(TO_FORTH_CHECK);
        report.addAll(TO_FIFTH_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("9180", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);
        report.addAll(TO_SECOND_CHECK);
        report.addAll(TO_THIRD_CHECK);
        report.addAll(TO_FORTH_CHECK);
        report.addAll(TO_FIFTH_CHECK);
        report.addAll(TO_SIXTH_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("13140", result.get(0));
    }
}
