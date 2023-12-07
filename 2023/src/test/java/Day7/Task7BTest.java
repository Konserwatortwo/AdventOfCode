package Day7;

import AoC2023.AdventTask;
import AoC2023.Day7.Task7B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task7BTest {

    private final AdventTask mockedTask = new Task7B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("32T3K 765");
        report.add("T55J5 684");
        report.add("KK677 28");
        report.add("KTJJT 220");
        report.add("QQQJA 483");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5905", result.get(0));
    }


    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("JJJJJ 765");
        report.add("JJJKK 684");
        report.add("QQJJQ 28");
        report.add("TTTTT 220");
        report.add("5JJ55 483");
        report.add("66666 483");
        report.add("7J777 483");
        report.add("888J8 483");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("12591", result.get(0));
    }


    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("AJJA1 765");
        report.add("KJKK1 684");
        report.add("QQQQ1 28");
        report.add("TTJJ1 220");
        report.add("55555 483");
        report.add("66666 483");
        report.add("77JJ7 483");
        report.add("8J888 483");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("17946", result.get(0));
    }
}
