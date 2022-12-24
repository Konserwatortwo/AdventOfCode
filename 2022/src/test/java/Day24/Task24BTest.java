package Day24;

import AoC2022.AdventTask;
import AoC2022.Day24.Task24A;
import AoC2022.Day24.Task24B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task24BTest {

    private final AdventTask mockedTask = new Task24B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("#.#####");
        report.add("#.....#");
        report.add("#>....#");
        report.add("#.....#");
        report.add("#...v.#");
        report.add("#.....#");
        report.add("#####.#");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("30", result.get(0));
    }


    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("#.######");
        report.add("#>>.<^<#");
        report.add("#.<..<<#");
        report.add("#>v.><>#");
        report.add("#<^v^^>#");
        report.add("######.#");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("54", result.get(0));
    }
}
