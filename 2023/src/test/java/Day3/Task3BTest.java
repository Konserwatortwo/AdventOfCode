package Day3;

import AoC2023.AdventTask;
import AoC2023.Day3.Task3B;
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
        report.add("467..114..");
        report.add("...*......");
        report.add("..35..633.");
        report.add("......#...");
        report.add("617*......");
        report.add(".....+.58.");
        report.add("..592.....");
        report.add("......755.");
        report.add("...$.*....");
        report.add(".664.598..");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("467835", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("..................&......124*...........*...............*...259........696...424...........*...............322..534................*519.....");
        report.add("........201*.30...474........567.526..363............%.963......287+......*.........939.964.....994.............*.....-........287.......657");
        report.add("........................709*......=.........854...527................50..591...859....%..........*....196.......188..395..157...*...........");
        report.add(".281*....878................354.......*221...*............308....309...*.........$..@...72#......577.........................*...734.....481");
        report.add(".....9....*.............658........235......767..12..548...=...#.......585..830....609........................603.130.....884...........*...");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2494738", result.get(0));
    }
}
