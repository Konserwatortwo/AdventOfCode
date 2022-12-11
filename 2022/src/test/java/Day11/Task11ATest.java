package Day11;

import AoC2022.AdventTask;
import AoC2022.Day11.Task11A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Day10.InstructionData.*;
import static Day11.MonkeyData.*;

public class Task11ATest {

    private final AdventTask mockedTask = new Task11A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = getAllMonkey();

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("10605", result.get(0));
    }
}
