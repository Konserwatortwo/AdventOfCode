package Day11;

import AoC2022.AdventTask;
import AoC2022.Day11.Task11B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task11BTest {

    private final AdventTask mockedTask = new Task11B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of("item1", "item2", "item3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }
}
