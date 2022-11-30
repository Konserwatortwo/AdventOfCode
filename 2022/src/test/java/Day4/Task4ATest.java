package Day4;

import AoC2022.AdventTask;
import AoC2022.Day2.Task2A;
import AoC2022.Day4.Task4A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task4ATest {

    private final AdventTask mockedTask = new Task4A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
        report.add(" ");
        report.add("22 13 17 11  0");
        report.add(" 8  2 23  4 24");
        report.add("21  9 14 16  7");
        report.add(" 6 10  3 18  5");
        report.add(" 1 12 20 15 19");
        report.add(" ");
        report.add(" 3 15  0  2 22");
        report.add(" 9 18 13 17  5");
        report.add("19  8  7 25 23");
        report.add("20 11 10 24  4");
        report.add("14 21 16 12  6");
        report.add("");
        report.add("14 21 17 24  4");
        report.add("10 16 15  9 19");
        report.add("18  8 23 26 20");
        report.add("22 11 13  6  5");
        report.add(" 2  0 12  3  7");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4512", result.get(0));
    }
}
