package Day21;

import AoC2023.AdventTask;
import AoC2023.Day21.Garden;
import AoC2023.Day21.Task21B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task21BTest {

    private final AdventTask mockedTask = new Task21B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("470149643712804", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(6);

        // Assert
        Assert.assertEquals(16, result);
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(10);

        // Assert
        Assert.assertEquals(50, result);
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(50);

        // Assert
        Assert.assertEquals(1594, result);
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(100);

        // Assert
        Assert.assertEquals(6536, result);
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(500);

        // Assert
        Assert.assertEquals(167004, result);
    }

    @Test
    public void seventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(1000);

        // Assert
        Assert.assertEquals(668697, result);
    }

    @Test
    public void eightTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(5000);

        // Assert
        Assert.assertEquals(16733044, result);
    }

    @Test
    public void ninthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(100001);

        // Assert
        Assert.assertEquals(6694248704L, result);
    }

    @Test
    public void tenthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...........");
        report.add(".....###.#.");
        report.add(".###.##..#.");
        report.add("..#.#...#..");
        report.add("....#.#....");
        report.add(".##..S####.");
        report.add(".##..#...#.");
        report.add(".......##..");
        report.add(".##.#.####.");
        report.add(".##..##.##.");
        report.add("...........");

        // Act
        Garden garden = Garden.of(report);
        long result = garden.findPlacesInInfiniteGarden(1000003);

        // Assert
        Assert.assertEquals(669424785084L, result);
    }
}
