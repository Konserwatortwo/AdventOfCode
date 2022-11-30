package Day6;

import AoC2022.AdventTask;
import AoC2022.Day6.Task6A;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task6ATest {

    private final AdventTask mockedTask = new Task6A();

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
