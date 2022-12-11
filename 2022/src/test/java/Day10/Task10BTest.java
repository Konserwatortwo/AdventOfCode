package Day10;

import AoC2022.AdventTask;
import AoC2022.Day10.Task10B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Day10.InstructionData.*;
import static Day10.InstructionData.TO_SIXTH_CHECK;

public class Task10BTest {

    private final AdventTask mockedTask = new Task10B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(TO_FIRST_CHECK);
        report.addAll(TO_SECOND_CHECK);
        report.addAll(TO_THIRD_CHECK);
        report.addAll(TO_FORTH_CHECK);
        report.addAll(TO_FIFTH_CHECK);
        report.addAll(TO_SIXTH_CHECK);

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(6, result.size());
        Assert.assertEquals("##..##..##..##..##..##..##..##..##..##..", result.get(0));
        Assert.assertEquals("###...###...###...###...###...###...###.", result.get(1));
        Assert.assertEquals("####....####....####....####....####....", result.get(2));
        Assert.assertEquals("#####.....#####.....#####.....#####.....", result.get(3));
        Assert.assertEquals("######......######......######......####", result.get(4));
        Assert.assertEquals("#######.......#######.......#######.....", result.get(5));
    }
}
