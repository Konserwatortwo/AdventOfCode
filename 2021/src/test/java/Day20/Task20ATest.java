package Day20;

import AoC2021.AdventTask;
import AoC2021.Day20.Task20A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task20ATest {

    private final AdventTask mockedTask = new Task20A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##");
        builder.append("#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###");
        builder.append(".######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#.");
        builder.append(".#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#.....");
        builder.append(".#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#..");
        builder.append("...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.....");
        builder.append("..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#");
        report.add(builder.toString());
        report.add("");
        report.add("#..#.");
        report.add("#....");
        report.add("##..#");
        report.add("..#..");
        report.add("..###");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("35", result.get(0));
    }
}
