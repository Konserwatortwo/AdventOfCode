package Day22;

import AoC2023.AdventTask;
import AoC2023.Day22.Task22A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task22ATest {

    private final AdventTask mockedTask = new Task22A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("1,0,1~1,2,1");
        report.add("0,0,2~2,0,2");
        report.add("0,2,3~2,2,3");
        report.add("0,0,4~0,2,4");
        report.add("2,0,5~2,2,5");
        report.add("0,1,6~2,1,6");
        report.add("1,1,8~1,1,9");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5", result.get(0));
    }
}
