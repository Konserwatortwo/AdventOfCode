package Day16;

import AoC2023.AdventTask;
import AoC2023.Day16.Task16B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task16BTest {

    private final AdventTask mockedTask = new Task16B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add(".|...\\....");
        report.add("|.-.\\.....");
        report.add(".....|-...");
        report.add("........|.");
        report.add("..........");
        report.add(".........\\");
        report.add("..../.\\\\..");
        report.add(".-.-/..|..");
        report.add(".|....-|.\\");
        report.add("..//.|....");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("51", result.get(0));
    }
}
