package Day15;

import AoC2022.Day15.Task15B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task15BTest {

    private final Task15B mockedTask = new Task15B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Sensor at x=2, y=18: closest beacon is at x=-2, y=15");
        report.add("Sensor at x=9, y=16: closest beacon is at x=10, y=16");
        report.add("Sensor at x=13, y=2: closest beacon is at x=15, y=3");
        report.add("Sensor at x=12, y=14: closest beacon is at x=10, y=16");
        report.add("Sensor at x=10, y=20: closest beacon is at x=10, y=16");
        report.add("Sensor at x=14, y=17: closest beacon is at x=10, y=16");
        report.add("Sensor at x=8, y=7: closest beacon is at x=2, y=10");
        report.add("Sensor at x=2, y=0: closest beacon is at x=2, y=10");
        report.add("Sensor at x=0, y=11: closest beacon is at x=2, y=10");
        report.add("Sensor at x=20, y=14: closest beacon is at x=25, y=17");
        report.add("Sensor at x=17, y=20: closest beacon is at x=21, y=22");
        report.add("Sensor at x=16, y=7: closest beacon is at x=15, y=3");
        report.add("Sensor at x=14, y=3: closest beacon is at x=15, y=3");
        report.add("Sensor at x=20, y=1: closest beacon is at x=15, y=3");

        // Act
        List<String> result = mockedTask.perform(report, 20);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("56000011", result.get(0));
    }
}
