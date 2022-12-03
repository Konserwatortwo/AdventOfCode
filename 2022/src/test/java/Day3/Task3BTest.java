package Day3;

import AoC2022.AdventTask;
import AoC2022.Day3.Task3B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task3BTest {

    private final AdventTask mockedTask = new Task3B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("vJrwpWtwJgWrhcsFMMfFFhFp");
        report.add("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        report.add("PmmdzqPrVvPwwTWBwg");
        report.add("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        report.add("ttgJtRGJQctTZtZT");
        report.add("CrZsJsPPZsGzwwsLwLmpwMDw");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("70", result.get(0));
    }
}
