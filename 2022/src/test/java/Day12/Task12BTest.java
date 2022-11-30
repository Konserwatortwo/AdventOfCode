package Day12;

import AoC2022.AdventTask;
import AoC2022.Day12.Task12B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task12BTest {

    private final AdventTask mockedTask = new Task12B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("start-A");
        report.add("start-b");
        report.add("A-c");
        report.add("A-b");
        report.add("b-d");
        report.add("A-end");
        report.add("b-end");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("36", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("dc-end");
        report.add("HN-start");
        report.add("start-kj");
        report.add("dc-start");
        report.add("dc-HN");
        report.add("LN-dc");
        report.add("HN-end");
        report.add("kj-sa");
        report.add("kj-HN");
        report.add("kj-dc");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("103", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("fs-end");
        report.add("he-DX");
        report.add("fs-he");
        report.add("start-DX");
        report.add("pj-DX");
        report.add("end-zg");
        report.add("zg-sl");
        report.add("zg-pj");
        report.add("pj-he");
        report.add("RW-he");
        report.add("fs-DX");
        report.add("pj-RW");
        report.add("zg-RW");
        report.add("start-pj");
        report.add("he-WI");
        report.add("zg-he");
        report.add("pj-fs");
        report.add("start-RW");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3509", result.get(0));
    }
}
