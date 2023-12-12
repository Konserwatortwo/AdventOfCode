package Day12;

import AoC2023.AdventTask;
import AoC2023.Day12.Task12A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task12ATest {

    private final AdventTask mockedTask = new Task12A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("???.### 1,1,3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add(".??..??...?##. 1,1,3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("?#?#?#?#?#?#?#? 1,3,1,6");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("????.#...#... 4,1,1");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("????.######..#####. 1,6,5");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("?###???????? 3,2,1");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("10", result.get(0));
    }

    @Test
    public void seventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("???.### 1,1,3");
        report.add(".??..??...?##. 1,1,3");
        report.add("?#?#?#?#?#?#?#? 1,3,1,6");
        report.add("????.#...#... 4,1,1");
        report.add("????.######..#####. 1,6,5");
        report.add("?###???????? 3,2,1");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("21", result.get(0));
    }

    @Test
    public void eightTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add(".##????.?.#.????? 4,1,1,3,1");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2", result.get(0));
    }
}
