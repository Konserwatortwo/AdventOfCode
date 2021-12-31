package Day21;

import AoC2021.AdventTask;
import AoC2021.Day21.Player;
import AoC2021.Day21.Task21B;
import AoC2021.Day21.Universe;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task21BTest {

    private final AdventTask mockedTask = new Task21B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Player 1 starting position: 4");
        report.add("Player 2 starting position: 8");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("444356092776315", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Player 1 starting position: 2");
        report.add("Player 2 starting position: 10");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("49975322685009", result.get(0));
    }
}
