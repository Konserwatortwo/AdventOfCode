package Day2;

import AoC2023.AdventTask;
import AoC2023.Day2.Task2A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task2ATest {

    private final AdventTask mockedTask = new Task2A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        report.add("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        report.add("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        report.add("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        report.add("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("8", result.get(0));
    }
}
