package Day17;

import AoC2022.AdventTask;
import AoC2022.Day17.Task17A;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Task17ATest {

    private final Task17A mockedTask = new Task17A();

    String line2 = ">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>";
    String line = "><<>>>><>>><<>><<>><<<<>>><<<<>><<<>>>><<>><><<<><<<>><>>>><<<>><<<<><<><<<>>><>><<<<>><>>><<<<>>>><<>>>><<<>><><<<<><<>>><>>>><>>><>>>><<<<><<>>><<>>><<<<>>>><<<><>><<>><<<<>>><<<>>>><>><>>>><>>><<<<><<>><>>>><<<<><<>>>><<>>><>><<<>><<<<>>>><<<>>>><<<>>>><<<<>>><<<<>>><>><<>>>><<><<<<>><<>><<>>><<<>>>><>><<>>>><<>><<<<>>>><<>>>><>><>>><<<<><<>><<>>>><<><<<>>>><>>><<<<>>><<<>><<<><>>>><<<<><<<<>>><<<<><<<>><>><<<<>>>><<>>><<>><<>><<<><<<<><<<>>>><<<><<<<><<<<>><<<<>>><>>><<<<>>><<<><<<><>><<<<>><<<><<<<>>>><<>><<>>><<<<>>>><<><<<<>>>><<>>>><<<>>><<>><<><<<><<<<>>><<<<><><>>><<<<>>><<<>>><>>>><<<>>>><>>>><<<<>>><<<>><<>><<><<<<>>>><<<><<<<><<<<>><<<<>>>><>>>><<>>><<<<>><<<>>>><<><><<<<>>><>>>><<<>>><<<>>><>>>><>><<>>><>><<<><<<>>>><<<<>>>><><<>>><>><<<>>><<<>>><<<<>>>><<<<>>>><<>>><<<><<>><<<<><<<<>>>><><<>>>><<>>><<>>>><<<>>><<>><<>>><>>>><<<<>>>><<>>>><<>>>><<>>><<<>>><<<>>>><><<<<>>><>>>><<<>><<<>>>><<>>>><<<<>>><>>>><<<>>>><<>><>>>><<<>><<<><<<>>>><><<>>><<><<>>><<>>>><<>>>><<<>>><<<>><<><>><<<<>>><<<><<>>>><<<>>><<><<<<><<><<<<>>>><<<<>>>><<<><>>><>>><<<<><<<<><>><<<<>>>><<>>><>>><<<<>><><<<>>>><>>><<<>><>>>><<<<>>><<<>>>><<>><>><<<>><<<<>>>><<<<>>><<<<><<>>>><<>><<<>><<<>><<<><<><<<<>><<>>><<>><<<>>><<<<>><>>><<<>>>><<<<><<>>><<<<>><<<>>>><<<><<<><<>>><<>>>><<<<>>>><<<><<<>>>><<<<>>>><<<>><>>><<>>>><><<<<><<<<>><<><>>><>><<>>>><<<<><><<<<>>><<<>>>><<<>><<<>>><<<>>><<>><>>><<<><><>>>><>><>><<<>><<<<>><<<>>>><<<<>>><<<<>><>>>><>>>><<<>><>><<>>><<<<>><>>><<<>><>><<>>>><<<<>>><<>>>><<<><<>><<>>>><>><>>><<><>><<>>>><<<>><><<>>>><<<>>><<>><<<>>><>>>><>><<>><>><<<<>>><>>><<>><<>>>><<<><<<<><<>>>><<>><<>>><>>><<<>>><<>>>><<<<><<><><<<<>>>><<<<>>><<<><>>><<<<>>>><<<>><>>><<<>><<<>>>><<>><<<><<><<<<><><>>>><<>><>>>><>>>><<<<>>><<>><<<<>><<>>><<<>><<<<><<<>>><<<>>>><<><<><<<<>><>>><<><<<<>><<><><>><<<><<<<>><<<><<>><<>><>>><>>><<<<>>>><>>>><<<<><>><<<<>>>><<<<>>><<<<>>>><<<>>><<>><>><>>><<>><<<>>><<<>>><<<<>>>><<<<>>><<<>>>><>>>><><><<>>>><<>>>><<<<>>><<<<>>>><<>>><>><<<<>>><<<<>>>><<<><<<<>>>><<>>><<<><>><<>>>><<<>>><<<>>><>>><<<>>>><<<<>>>><<<><<>><<<><>>>><<>>><<>>>><>>><<>><<<>>>><<<<>>>><<<<>>><>>>><><<<<>><><<><><<<<><<<<>>>><><<><<<<>><<<<><<<<>>>><<<>>><<<<>>><>>><<>>><<<>><<<<>><>>><<<<><>><<<<>>>><>>>><<>>><>><>>><>>>><>><<<<>>><<<>><<<>>><<>>><<<>>>><<><<<<>>>><<<<>>><<<<>><<<<>>>><>>>><<<<>>>><<<>>>><><<<<>>>><<>><<<>><<<>>>><<>>><<<<>>><>>>><<<>><>>>><<>>>><<>>>><<><><<><<>><<<<>>><<<<>><<<>><>>><>>>><<<>>>><<>><><<<><<<<>>>><<><<<<><<<>>><<<><>>>><<>>>><<<<>><<<>><><<<>><<<<><<<>>>><<><><<<<>>><><>>>><>>>><<<<>><<><>>><<>>>><<>>><>>><<>><<<>><><><><>><<>>><>><<<>>>><<<>><>>><>>>><>><<>>><<>>>><<<<>>><<>><<<<>>><>><<<<>>><>>>><><<<>><<<>>><<<<>>><<><<<><<<<>>><>>><><<<<><<<>>><<>><><<<<>><<<><><<<<>>>><<<><><<>>><<<>><>>><<>><<<<><>><<><<<<>><<<>><>>><>>>><<<><<<>><<>><<<<>>>><<>><>>><>>><<<<>>><>>>><<<<>>>><<>>><<>>>><<<<><<<><<<>><<<<>><<<>>><<<<>>>><<<>>>><<>>>><<<<><<<<>>><<<<>><<><<<<><>><<<>><<<<><<>>>><<<><<<<>><<<<><><<<>>><>>>><<<<>>><<<<>><>><<<<><<<><<<>>><<<><<>>><<<><<<>>>><<<>>><<<><<<><<><<<>>><<<<>><>>>><<<<>>><<<>>><<<<><<>>><<<<>>><<<<>><>>><<><<<><<<<><<>><<<>>><<><<<>><<<<>><<>>><<<<><<<>>>><>>><<<<><>>>><<<<><<<<>><<>>><<><<<<>><<><>>><<<<>>><<<>><<<>>>><>><<>>><>>>><>>>><<<<>><<><<<>>>><<>><<<<>>><<>>><<>><<>><>>>><<><<<<>>><>>>><<>>>><<>><>>><<<<>>>><<<><>>><<>>><>>>><<<<><<>><<<>>>><<>><<<<>><<<><<>>>><>>>><<<<><><<<><<<<>><<<>>>><>>>><<<><><<<><<<>>><>>><<<>><<<>>>><<<><<<>>><<<<>>><<>>><<<>><>><>><<>>>><>><<<>>><<<><<<<>>><<<>>>><<>>><>><<>>>><<>>>><<>>><<><<>><<>>><<<<>>><<<<>><<<<>>>><<<>>>><<<<>><<>><<<<>><<<>>>><<>>>><>>><<<>><>>><>><<<><<<><<>>>><<<<>><><>><<<<>>>><<>>>><<>>>><<<>>><<<>>><<<<>>>><>>>><><<><<>>>><<>>>><>><<>><>><<>><<>><<<>>>><<>><<><<><<><<<<>>><<<<><><>>><<<>><><<<><<<<>><<>>>><<>><<<<>><<>><<>>><<><<>>>><>><<<<>>><><<>><>>>><<<<>>><<>>>><<><<<>>>><><<<>><>><<>><<><<<<>>><<><><<<<>>>><>>><><<>>>><<>>><>>>><<<<>>>><<>><<<>><<<>>>><>>>><<<><>><<>><<<<>>>><<<>>>><<<>>>><<<>><<<<>><<<<><<<<>>>><<>><<<<><<>><<<>>><<>>>><<<<>>>><>>>><<>>>><<<<>>><<<<>><<<>><<>>>><>><<>><<>><<>><<<<>>>><<<><<>>><<<><<<<>><<>><<<<>>><<<<>>><<<><>>>><<<<>>><<<<>>><>><<>>>><<<<><<<<>>>><<<<><<>>><<<<><<><<<>>><>><<<<>>>><<<><<<>>>><>>>><<<>><><<<<><<<>>><<>>><<<<>><<<<>>><<>>><<>>><<<<><<<>><>>>><>><<<<>>><>>><<>>><<>>><<><<>>>><<<>>>><<<>>><>>><<<>><>>>><<<>>><><<>>>><<<<>>><>>><<<<>>>><<<>><<<><<>>><<<>>><<<<>><<<<>><>><<<>><<<<>>>><<><>><>>>><<<<>>><>>><<<<>>><>>><>>><<<>>><<<><<<>><>><<<><<>>><>>><<<<>>><<<<>>><<>>>><>>><<<>>>><<<<><<>><<><><<<><<>><>><<<>>><<<<>>><>>><<<>>>><<<<>>>><<<>>><><<<<>>><<>>><<>>>><<>><<<<><>>><<<>>>><<><<><<>>><<><<<><<<>>>><>>><><><>>>><<>>><><<<>><><<>><><>><>>><><<<><<><>>><<<<>><<<<>>><>>><<>><<>>>><<<<><<<><<<<>>><<<<>><<<<>>><<>><<<>><<>><<>>>><<<<>>>><<>><<<><>><<<<>>>><<>><<><<<>><<>><>><<<>><<<>><<<>>>><<>>><<>><<<>><<>>><><>><<>>><>>><<<<>>><<<<>><<><>>><><<>>>><<><><<<>><>><<>>>><<<>>>><<<>><>>>><<<<>><<>>>><>>>><<<>><<>><>>><<<<><><><<<>>>><>>>><<><<<><><<<>>>><<<<>>>><><><<<>>><<<>><<<>>><<<<>>>><<<<>>><<>><><<<>>>><<>>><>>>><<<<>>><>>>><<<><<<>><<<>><<<><<<><<<>>>><<<<>>><<>>><>>><<>><>>>><<>>>><<>>>><<<>>>><<<>>><>>><<<<><><<>>><<<<>>><>><<<<>><>><<<><><<<<><>>><<<>>>><>>>><>>>><<<><<<<><<<<>>><<<>><<<>>><<>>>><<>>>><<<<>><<<>>><<<>>>><<<<><<>>>><<>><<<>><<<<><<><><<><>>><><<<><<<<>>><>>>><<><<<<>>>><>>>><>>><<>>><<<<>>><><<<<>>>><>>><<>><<<>>>><<>>>><<<>>>><<><<>>>><>><<<<><<><<<<>><<<><<<>>>><><>>><<>>>><<>><>><<<<>><<<>>>><>><<<>><<<>><<<><<<>><<<>><><<<<>>>><<>>><<<>>><<>>><>>>><>>>><<><<<>>>><<>>><>><<<<>><<><<<>>>><<>>>><>><<<<>>><<<<>>>><<<<><<<<>><<>>><>>><<<<>>>><<<>>><>><<<<>>><><<<<><<>>><<>>><><<<><<<<>><>>><<<<><<<><<><<<<><<<<>><<<<><<<<>>>><<<<>><>>>><>>><<<<><<>><>><<>>>><<<<>><<<<>>><>>><<<>>><<<>>><<<<>>><>>><<<<>>>><<<><<<><<<><<><<<>><<<>><<<>>><>><<>>><<>><<<<>>><<<<>><<<<><>>>><>>>><<<>>><<<>>><<><<<>>>><<<><<>><<>>><<><<<<><<<<>><<<>><>>><<<<>><<><<<<>>><<>><<<><>><<<<>><<<>><<>>><<<<><<>>>><<><<>>>><<<<>>>><<<><<<><<<<>>>><<<<><<>>>><<>>>><>>><<<>>>><<<<>>>><>>>><>>>><<<<><<><>><<><<>>>><>>>><><<<<>><<<<>><<>>><<>><>>>><<><<><<>><<<<>>><<<<>>>><<>><<>><<><><>><<<>>>><<<><<<>><<<<><<<<>>>><<<<>>>><<<>>><<><<>>>><<<><><<>>>><<<><<<><<<<>><>>>><<><<<><>>>><<>>>><<<<>><<<>><<>><<>><<>>>><<>>><>>>><>>><<>>>><<<>><<<>><<>><<<><<>><<<<>><<>>>><<<>>>><<<>>>><<><<<<><<<>>>><>>><<<><<<>>><<<<>>>><<><<<<>><<<>>><>>>><<<>>><<<<>>><<<>>>><>>>><<<<><<>><<<<>><><<<>><<>><<<>><<>>>><>>>><><<<>>>><<>>><<<>>>><<<<>><<>>>><<><<<<>><<<<>>><><<>><<<><<<>>>><<<><<<<>>><>>>><<<>><<>>><<>><><<><<<<><>>><>>>><>><>><<<>>>><<<<><<<<>>>><>>><<><<<>><<<>><>><>>>><><<>>>><>>><<<<><<<><>><><>>><<<><<<><<<<>>><<<>>><<<>><<<>>>><<<>>>><<<>>>><<<>>>><<<<>>><<<<><>>><><<<>>>><>>><<>><>><<<>>>><<<<><<>>>><>>><>>><<<>><<<<>>><<<><>>><>>><<><<><<<>>><<<<>>>><<<<>>>><>><<<<><<>>><<<<>>>><<>>><<<<><>><<>>><><<<<>>>><>>><<<<><<<<>>><<<<><<>>>><<<<>>>><<<<>>><<<>><>>><>>><<<<>>><>><<>><<><<<>>><<<><<<<>>>><>>>><<<<><<<<><<>>><<<>><>>><<<<>>>><<<><<<>><<>>>><><><<<<>><<<<><<<<><<<>>><<<>>><>><<<<>><<<<>><<<>>>><>><<>><<<<>>>><<<<>>>><<<>>><<<<>>><<<<>>><<<><<<<>>>><<>>>><<>>><<<>>>><><<<<><<<<><<>><>>>><>>><<<>><>>><<<<><<<<><<>>><>>><><<<><<>><<>>><<>>>><<<><>>>><<<>><<<><<>><<>>><<<<>>><<><<><><>>><><<>>><<<<><<<>>>><<<>>>><>>><<>>>><<<><<<>><<<>><<<<>>><<><<><<<<>>>><<>>>><>>><<>>>><><<<<>>><<<<>><<><<>>>><<<<>><<<<>>><<<<>>>><<<>>>><>>>><<<<>>>><>><<>>><<<><>>>><<>>>><<<>>><<>>>><<<>><<<>>>><<>><<<>>><<>><<><>><<><<<>>><<<>>><<<<>><<>>><>>>><<<<><<<><><>>><<<>><<<<>>><<>>>><>><>>>><<<<>>>><>>>><<<><<>>>><<<<><<<>>>><<<><><<<<>><<>>>><>>><<><>>><<>>>><>>><<>>><><<>>>><<<<>><>>><<<><<>><<<<>>><<<>><<<<>>><<>>><>><<<>><>>><<<<>>>><<<>><<>>><<<<><<>>>><<<<>>>><<><><<<<><<<>>>><<>>><<<<>>><<>>><<<<>><<<<><<>>>><<><>>><<<>><<<><<<>>><<<<>><<><>>>><<<><>><<>><>>>><<<<>><<<<>><><<<<><<<>>><<<<>><><>><<<<>>><>>>><<<<>>>><><<<<>>><<<<>>><<<<><><<<<>>>><<<>>>><<<<>><<>>><<<<>><<<><<>><><<<><<<>>><<<<>>>><<>>>><<>><<>>>><<<<>>><>><<><<>><<>><<<<><<<<>><<<>><<<>><<>>>><<<>>>><<<<>><>><>>>><<><<<<>><<<>><<<>><>>>><<<>>>><>>><<<<>>>><<<>>>><<><>>>><<<<><<>>>><<>>><<<<><<><<<<>>>><<>>><<><<<><<>><<<>><<>><<<><><<<<>>><<<<><<><<>><<>>><<<<>>><>>>><>>>><>>><><<<>><><<<>>>><<>>><<<<><<<><<<<><<<>>>><<>><>>><<<>>><>>><<>>>><>>>><>>>><<<>>>><>><<<><>><<<>>>><<>>><<>><>>>><>><<<<>>><<>><<><>>><><<<<>>>><<<><<<<>>><>>>><<><<<>>>><>>><<<<>><<>><<>>><>><>>><<<>>><>>>><<<><<<>>>><<<<>><<<>>><<<>>>><><<>><<><<<>>><><<<<><>>>><<<<>>><<><>>>><><<<<>>>><<<<>>>><><<><<>>><>><<<<>>><<<<><>>>><<>><<<<>>><>><<><<><<<>>>><<<<>><<<<>>>><>><<<<>>>><<<>>><<>>><><<<<><<<<>>><<>>><<<>>>><<<>>><><>><>>>><<<<><<>><<<<>>>><<<<>>>><<<<><<<><><>><><<<>>>><<<<>><<>><>>><<<>>><>>><<><<><>><>><<<>>>><<<<>>><><<<<><<<>>><<><<<>>><<<<><<<>>><<<>>>><<>>>><<>><>>><><<><<<>><>><<<<>><<>><>><<<<><<<<><>>>><<<<>>><<<><<<>><<><<<<>>><<<>>><>><><>>>><<<><>><<<<><>><<<<>>><><<><>><><<<<>>>><<><<<>>><<>>>><<<<>><<<>>><>>>><<>><>><<<<>>><<<>><><><>>>><<<>><<<<><<<>><<<<>><<<>>>><<>>><<<<>><><<>><<<>><<<<>>><<<>><>>>><<><<><>>>><<<><<>>>><><<<>><<>>><>><<<<>>><<<<><<<>>><<<<>>>><<>>>><<<>><<>><<<<>>><<<<>><>><<<>><<>>>><><<<>>>><<<>><>>>><<<>>>><<<<><<>><<<<>>><<>><><<>>><<<>><<>><<<>><<>>><<>>><<<>><<<>>><<>><<>><<<<>>>><<<<>>>><<<<><<>><<<>>><<<>>>><<<>><>>><><>><>>><><<>>>><>>><<<<>>>><<<>>>><>>><<<><<<>>><<<>><>>>><<<<>>><<<<><<<>>><<>>><<<>><<<<>><<<><<<>>>><><<<<>><<<<>>>><<<><<<>>><<<><<<<><>><>><<>>><<<>>><>>><><<<><<>>>><<<>>><>>><>>><>>>><<<><<<<>>>><<><<>><<<><<<><<<<><>><<><<<>>><<>>><<><<>>><<<<>><>><<<>>><<<<>>><>>><<<<>><>><<<<>><<>>>><<>>><>><<>><<<>><<<>>><<<<>><<<><<<>>>><<<>>><<>><<<<>><<<<>>><<<<>>>><<<>><<<<>>><>><<>>><<<>>><<<>>>><<<<>>>><<<><<<>>><<<>>><>>><>><<<<><><<<>><<<>>>><<<>>>><<<<>>>><<>><<>>><>><<<>>><<>><>><>><<<>>><>>><<<<>>><<<><<<>>><<<>><<<>><<<<>>><<<<>><<><><>>><<><<<<>>><<<<><<>><<<>><>><<<>>><<<>>>><<<<>>>><>>><<>>><<<<>><<<<>>>><<<>><<<>>><<<<><<<<><><<<>><>><<<<>><>>><<<><<<<>>><<<>><<<<><<<<>><>>><>><<><<>>>><<<<><<><<<<><<<<>>><<<><<<<>>><<<<><<<>>><<<";


    @Test
    public void firstTest() {
        // Arrange
        List<String> report = List.of(line);

        // Act
        List<String> result = mockedTask.perform(report, 2022);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
//        Assert.assertEquals("3068", result.get(0));
        Assert.assertEquals("3137", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = List.of(line);

        // Act
        List<String> result = mockedTask.perform(report, 10000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("15618", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = List.of(line);

        // Act
        List<String> result = mockedTask.perform(report, 20000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("31287", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = List.of(line);

        // Act
        List<String> result = mockedTask.perform(report, 30000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("46943", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = List.of(line);

        // Act
        List<String> result = mockedTask.perform(report, 40000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("62577", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = List.of(line);

        // Act
        List<String> result = mockedTask.perform(report, 50000);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("78220", result.get(0));
    }
}
