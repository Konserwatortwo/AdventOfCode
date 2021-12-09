package Day1;

import AoC2021.AdventTask;
import AoC2021.Day1.Task1A;
import AoC2021.Day1.Task1B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task1BTest {

    private final AdventTask mockedTask = new Task1B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("199", "200", "208", "210", "200", "207", "240", "269", "260", "263");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5", result.get(0));
    }
}
