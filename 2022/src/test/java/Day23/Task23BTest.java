package Day23;

import AoC2022.AdventTask;
import AoC2022.Day23.Task23B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task23BTest {

    private final AdventTask mockedTask = new Task23B();

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

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = List.of("item1", "item2", "item3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }
}
