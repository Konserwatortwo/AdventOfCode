package Day18;

import AoC2021.AdventTask;
import AoC2021.Day18.Task18A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task18ATest {

    private final AdventTask mockedTask = new Task18A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[1,2],[[3,4],5]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("143", result.get(0));
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1384", result.get(0));
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[1,1],[2,2]],[3,3]],[4,4]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("445", result.get(0));
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[3,0],[5,3]],[4,4]],[5,5]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("791", result.get(0));
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[5,0],[7,4]],[5,5]],[6,6]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1137", result.get(0));
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3488", result.get(0));
    }

    @Test
    public void seventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[6,6],[7,6]],[[7,7],[7,0]]],[[[7,7],[7,7]],[[7,8],[9,9]]]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4140", result.get(0));
    }

    @Test
    public void finalTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]");
        report.add("[[[5,[2,8]],4],[5,[[9,9],0]]]");
        report.add("[6,[[[6,2],[5,6]],[[7,6],[4,7]]]]");
        report.add("[[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]");
        report.add("[[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]");
        report.add("[[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]");
        report.add("[[[[5,4],[7,7]],8],[[8,3],8]]");
        report.add("[[9,3],[[9,9],[6,[4,9]]]]");
        report.add("[[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]");
        report.add("[[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4140", result.get(0));
    }
}
