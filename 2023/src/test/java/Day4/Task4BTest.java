package Day4;

import AoC2023.AdventTask;
import AoC2023.Day4.Task4B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task4BTest {

    private final AdventTask mockedTask = new Task4B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        report.add("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");

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
        report.add("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        report.add("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");
        report.add("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1");
        report.add("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83");
        report.add("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36");
        report.add("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("30", result.get(0));
    }
}
