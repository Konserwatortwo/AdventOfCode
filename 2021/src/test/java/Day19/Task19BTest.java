package Day19;

import AoC2021.AdventTask;
import AoC2021.Day19.Task19B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Day19.InputFile.*;

public class Task19BTest {

    private final AdventTask mockedTask = new Task19B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());
        report.addAll(fifthScannerInput());
        report.addAll(thirdScannerInput());
        report.addAll(fourthScannerInput());

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3621", result.get(0));
    }
}
