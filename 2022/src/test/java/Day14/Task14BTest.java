package Day14;

import AoC2022.Day14.Task14B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task14BTest {

    private final Task14B mockedTask = new Task14B();

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
    public void finalTest() {
        // Arrange
        List<String> report = testedInput();

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2188189693529", result.get(0));
    }
}
