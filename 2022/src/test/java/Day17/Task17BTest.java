package Day17;

import AoC2022.AdventTask;
import AoC2022.Day17.Task17B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task17BTest {

    private final AdventTask mockedTask = new Task17B();

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