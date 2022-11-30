package Day14;

import AoC2022.Day14.Task14A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task14ATest {

    private final Task14A mockedTask = new Task14A();

    private List<String> testedInput() {
        List<String> report = new ArrayList<>();
        report.add("NNCB");
        report.add("");
        report.add("CH -> B");
        report.add("HH -> N");
        report.add("CB -> H");
        report.add("NH -> C");
        report.add("HB -> C");
        report.add("HC -> B");
        report.add("HN -> C");
        report.add("NN -> C");
        report.add("BH -> H");
        report.add("NC -> B");
        report.add("NB -> B");
        report.add("BN -> B");
        report.add("BB -> N");
        report.add("BC -> B");
        report.add("CC -> N");
        report.add("CN -> C");
        return report;
    }

    @Test
    public void oneStepTest() {
        // Arrange
        List<String> report = testedInput();

        // Act
        String result = mockedTask.performTask(report, 1);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(7, result.length());
        Assert.assertEquals("NCNBCHB", result);
    }

    @Test
    public void twoStepsTest() {
        // Arrange
        List<String> report = testedInput();

        // Act
        String result = mockedTask.performTask(report, 2);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(13, result.length());
        Assert.assertEquals("NBCCNBBBCBHCB", result);
    }

    @Test
    public void threeStepsTest() {
        // Arrange
        List<String> report = testedInput();

        // Act
        String result = mockedTask.performTask(report, 3);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(25, result.length());
        Assert.assertEquals("NBBBCNCCNBBNBNBBCHBHHBCHB", result);
    }

    @Test
    public void fourStepsTest() {
        // Arrange
        List<String> report = testedInput();

        // Act
        String result = mockedTask.performTask(report, 4);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(49, result.length());
        Assert.assertEquals("NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB", result);
    }

    @Test
    public void finalTest() {
        // Arrange
        List<String> report = testedInput();

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1588", result.get(0));
    }


}
