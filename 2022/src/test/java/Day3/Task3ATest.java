package Day3;

import AoC2022.AdventTask;
import AoC2022.Day3.Task3A;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task3ATest {

    private final AdventTask mockedTask = new Task3A();

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
