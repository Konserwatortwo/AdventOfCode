package Day12;

import AoC2022.AdventTask;
import AoC2022.Day12.Task12B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task12BTest {

    private final AdventTask mockedTask = new Task12B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Sabqponm");
        report.add("abcryxxl");
        report.add("accszExk");
        report.add("acctuvwj");
        report.add("abdefghi");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("29", result.get(0));
    }
}
