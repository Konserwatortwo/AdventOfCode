package Day23;

import AoC2021.AdventTask;
import AoC2021.Day22.Task22A;
import AoC2021.Day23.Task23B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task23BTest {

    private final AdventTask mockedTask = new Task23B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("BDDA");
        report.add("CCBD");
        report.add("BBAC");
        report.add("DACA");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("44169", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("CDDD");
        report.add("CCBD");
        report.add("ABAB");
        report.add("BACA");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("50132", result.get(0));
    }
}
