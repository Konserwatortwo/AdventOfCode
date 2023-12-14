package Day14;

import AoC2023.Day14.Task14B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task14BTest {

    private final Task14B mockedTask = new Task14B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("O....#....");
        report.add("O.OO#....#");
        report.add(".....##...");
        report.add("OO.#O....O");
        report.add(".O.....O#.");
        report.add("O.#..O.#.#");
        report.add("..O..#O..O");
        report.add(".......O..");
        report.add("#....###..");
        report.add("#OO..#....");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("64", result.get(0));
    }
}
