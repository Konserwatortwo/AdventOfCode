package Day18;

import AoC2022.Day18.SailfishNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static AoC2022.Day18.SailfishNumberUtils.addSailfishNumbers;

public class SnailfishNumberAdditionTest {

    public SailfishNumber perform(List<String> input) {
        SailfishNumber resultNumber = new SailfishNumber(input.get(0));
        for (int i = 1, inputSize = input.size(); i < inputSize; i++) {
            resultNumber = addSailfishNumbers(resultNumber, new SailfishNumber(input.get(i)));
            System.out.println(resultNumber.toString());
        }
        return resultNumber;
    }

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[1,1]");
        report.add("[2,2]");
        report.add("[3,3]");
        report.add("[4,4]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[1,1],[2,2]],[3,3]],[4,4]]", result.toString());
    }

    @Test
    public void secondTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[1,1]");
        report.add("[2,2]");
        report.add("[3,3]");
        report.add("[4,4]");
        report.add("[5,5]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[3,0],[5,3]],[4,4]],[5,5]]", result.toString());
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[1,1]");
        report.add("[2,2]");
        report.add("[3,3]");
        report.add("[4,4]");
        report.add("[5,5]");
        report.add("[6,6]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[5,0],[7,4]],[5,5]],[6,6]]", result.toString());
    }

    @Test
    public void fourthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[4,3],4],4],[7,[[8,4],9]]]");
        report.add("[1,1]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", result.toString());
    }

    @Test
    public void fifthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]");
        report.add("[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]", result.toString());
    }

    @Test
    public void sixthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]");
        report.add("[[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[6,7],[6,7]],[[7,7],[0,7]]],[[[8,7],[7,7]],[[8,8],[8,0]]]]", result.toString());
    }

    @Test
    public void seventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[7,0],[7,7]],[[7,7],[7,8]]],[[[7,7],[8,8]],[[7,7],[8,7]]]]");
        report.add("[7,[5,[[3,8],[1,4]]]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[7,7],[7,8]],[[9,5],[8,7]]],[[[6,8],[0,8]],[[9,9],[9,0]]]]", result.toString());
    }

    @Test
    public void eightTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[7,7],[7,8]],[[9,5],[8,7]]],[[[6,8],[0,8]],[[9,9],[9,0]]]]");
        report.add("[[2,[2,2]],[8,[8,1]]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[6,6],[6,6]],[[6,0],[6,7]]],[[[7,7],[8,9]],[8,[8,1]]]]", result.toString());
    }


    @Test
    public void ninthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[6,6],[6,6]],[[6,0],[6,7]]],[[[7,7],[8,9]],[8,[8,1]]]]");
        report.add("[2,9]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[6,6],[7,7]],[[0,7],[7,7]]],[[[5,5],[5,6]],9]]", result.toString());
    }

    @Test
    public void tenthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[6,6],[7,7]],[[0,7],[7,7]]],[[[5,5],[5,6]],9]]");
        report.add("[1,[[[9,3],9],[[9,0],[0,7]]]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[7,8],[6,7]],[[6,8],[0,8]]],[[[7,7],[5,0]],[[5,5],[5,6]]]]", result.toString());
    }

    @Test
    public void eleventhTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[7,8],[6,7]],[[6,8],[0,8]]],[[[7,7],[5,0]],[[5,5],[5,6]]]]");
        report.add("[[[5,[7,4]],7],1]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[7,7],[7,7]],[[8,7],[8,7]]],[[[7,0],[7,7]],9]]", result.toString());
    }

    @Test
    public void twelfthTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[[7,7],[7,7]],[[8,7],[8,7]]],[[[7,0],[7,7]],9]]");
        report.add("[[[[4,2],2],6],[8,7]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]", result.toString());
    }

    @Test
    public void finalTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]");
        report.add("[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]");
        report.add("[[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]");
        report.add("[[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]]");
        report.add("[7,[5,[[3,8],[1,4]]]]");
        report.add("[[2,[2,2]],[8,[8,1]]]");
        report.add("[2,9]");
        report.add("[1,[[[9,3],9],[[9,0],[0,7]]]]");
        report.add("[[[5,[7,4]],7],1]");
        report.add("[[[[4,2],2],6],[8,7]]");

        // Act
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]", result.toString());
    }

    @Test
    public void anotherFinalTest() {
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
        SailfishNumber result = perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals("[[[[6,6],[7,6]],[[7,7],[7,0]]],[[[7,7],[7,7]],[[7,8],[9,9]]]]", result.toString());
    }
}
