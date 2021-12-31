package Day19;

import AoC2021.AdventTask;
import AoC2021.Day19.Task19A;
import AoC2021.Day19.TaskUtils;
import AoC2021.Day19.dto.Scanner;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Day19.InputFile.*;

public class Task19ATest {

    private final AdventTask mockedTask = new Task19A();

    @Test
    public void testReadData() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());
        report.addAll(thirdScannerInput());
        report.addAll(fourthScannerInput());
        report.addAll(fifthScannerInput());

        // Act
        List<Scanner> readScanners = TaskUtils.readData(report);

        // Assert
        Assert.assertNotNull(readScanners);
        Assert.assertEquals(5, readScanners.size());
        Assert.assertEquals(300, readScanners.get(0).getDistances().size());
        Assert.assertEquals(300, readScanners.get(1).getDistances().size());
        Assert.assertEquals(325, readScanners.get(2).getDistances().size());
        Assert.assertEquals(300, readScanners.get(3).getDistances().size());
        Assert.assertEquals(325, readScanners.get(4).getDistances().size());
    }

    @Test
    public void firstFinderPositionTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());

        // Act
        List<Scanner> readScanners = TaskUtils.readData(report);
        TaskUtils.determineScannersRelativePosition(readScanners);

        // Assert
        Assert.assertNotNull(readScanners);
        Assert.assertEquals(2, readScanners.size());
        Assert.assertTrue(readScanners.get(0).toString().contains("[0,0,0]"));
        Assert.assertTrue(readScanners.get(1).toString().contains("[68,-1246,-43]"));
    }

    @Test
    public void secondFinderPositionTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());
        report.addAll(fifthScannerInput());

        // Act
        List<Scanner> readScanners = TaskUtils.readData(report);
        TaskUtils.determineScannersRelativePosition(readScanners);

        // Assert
        Assert.assertNotNull(readScanners);
        Assert.assertEquals(3, readScanners.size());
        Assert.assertTrue(readScanners.get(0).toString().contains("[0,0,0]"));
        Assert.assertTrue(readScanners.get(1).toString().contains("[68,-1246,-43]"));
        Assert.assertTrue(readScanners.get(2).toString().contains("[-20,-1133,1061]"));
    }

    @Test
    public void thirdFinderPositionTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());
        report.addAll(fifthScannerInput());
        report.addAll(thirdScannerInput());

        // Act
        List<Scanner> readScanners = TaskUtils.readData(report);
        TaskUtils.determineScannersRelativePosition(readScanners);

        // Assert
        Assert.assertNotNull(readScanners);
        Assert.assertEquals(4, readScanners.size());
        Assert.assertTrue(readScanners.get(0).toString().contains("[0,0,0]"));
        Assert.assertTrue(readScanners.get(1).toString().contains("[68,-1246,-43]"));
        Assert.assertTrue(readScanners.get(2).toString().contains("[-20,-1133,1061]"));
        Assert.assertTrue(readScanners.get(3).toString().contains("[1105,-1205,1229]"));
    }

    @Test
    public void fourthFinderPositionTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());
        report.addAll(fifthScannerInput());
        report.addAll(thirdScannerInput());
        report.addAll(fourthScannerInput());

        // Act
        List<Scanner> readScanners = TaskUtils.readData(report);
        TaskUtils.determineScannersRelativePosition(readScanners);

        // Assert
        Assert.assertNotNull(readScanners);
        Assert.assertEquals(5, readScanners.size());
        Assert.assertTrue(readScanners.get(0).toString().contains("[0,0,0]"));
        Assert.assertTrue(readScanners.get(1).toString().contains("[68,-1246,-43]"));
        Assert.assertTrue(readScanners.get(2).toString().contains("[-20,-1133,1061]"));
        Assert.assertTrue(readScanners.get(3).toString().contains("[1105,-1205,1229]"));
        Assert.assertTrue(readScanners.get(4).toString().contains("[-92,-2380,-20]"));
    }

    @Test
    public void fifthFinderPositionTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.addAll(firstScannerInput());
        report.addAll(secondScannerInput());
        report.addAll(fifthScannerInput());
        report.addAll(thirdScannerInput());
        report.addAll(fourthScannerInput());

        // Act
        List<Scanner> readScanners = TaskUtils.readData(report);
        TaskUtils.determineScannersRelativePosition(readScanners);

        // Assert
        Assert.assertNotNull(readScanners);
        Assert.assertEquals(5, readScanners.size());
        Assert.assertTrue(readScanners.get(0).toString().contains("[0,0,0]"));
        Assert.assertTrue(readScanners.get(1).toString().contains("[68,-1246,-43]"));
        Assert.assertTrue(readScanners.get(3).toString().contains("[1105,-1205,1229]"));
        Assert.assertTrue(readScanners.get(4).toString().contains("[-92,-2380,-20]"));
        Assert.assertTrue(readScanners.get(2).toString().contains("[-20,-1133,1061]"));
    }


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
        Assert.assertEquals("79", result.get(0));
    }
}
