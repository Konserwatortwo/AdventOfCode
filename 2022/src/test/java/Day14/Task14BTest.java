package Day14;

import AoC2022.Day14.Task14B;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task14BTest {

    private final Task14B mockedTask = new Task14B();

    @Test
    public void finalTest() {
        // Arrange
        List<String> report = List.of("item1", "item2", "item3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }
}
