package Day7;

import AoC2023.AdventTask;
import AoC2023.Day7.Task7A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task7ATest {

    private final AdventTask mockedTask = new Task7A();

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
        Assert.assertEquals("6440", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("AAAAA 765");
        report.add("KKKKK 684");
        report.add("QQQQQ 28");
        report.add("TTTTT 220");
        report.add("55555 483");
        report.add("66666 483");
        report.add("77777 483");
        report.add("88888 483");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("17006", result.get(0));
    }


    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("AAAA1 765");
        report.add("KKKK1 684");
        report.add("QQQQ1 28");
        report.add("TTTT1 220");
        report.add("55555 483");
        report.add("66666 483");
        report.add("77777 483");
        report.add("88888 483");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("17946", result.get(0));
    }
}
