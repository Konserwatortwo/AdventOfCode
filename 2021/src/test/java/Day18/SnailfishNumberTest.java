package Day18;

import AoC2021.Day18.SailfishNumber;
import org.junit.Assert;
import org.junit.Test;

public class SnailfishNumberTest {

    @Test
    public void firstTestOfSnailfishNumber() {
        // Arrange
        String input = "[1,2]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }

    @Test
    public void secondTestOfSnailfishNumber() {
        // Arrange
        String input = "[[1,2],3]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }


    @Test
    public void thirdTestOfSnailfishNumber() {
        // Arrange
        String input = "[9,[8,7]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }

    @Test
    public void fourthTestOfSnailfishNumber() {
        // Arrange
        String input = "[[1,9],[8,5]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }

    @Test
    public void fifthTestOfSnailfishNumber() {
        // Arrange
        String input = "[[[[1,2],[3,4]],[[5,6],[7,8]]],9]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }

    @Test
    public void sixthTestOfSnailfishNumber() {
        // Arrange
        String input = "[[[9,[3,8]],[[0,9],6]],[[[3,7],[4,9]],3]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }

    @Test
    public void seventhTestOfSnailfishNumber() {
        // Arrange
        String input = "[[[[1,3],[5,3]],[[1,3],[8,7]]],[[[4,9],[6,9]],[[8,2],[7,3]]]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals(input, number.toString());
    }

    @Test
    public void firstTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[[[[[9,8],1],2],3],4]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[[[[0,9],2],3],4]", number.toString());
    }

    @Test
    public void secondTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[7,[6,[5,[4,[3,2]]]]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[7,[6,[5,[7,0]]]]", number.toString());
    }

    @Test
    public void thirdTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[[6,[5,[4,[3,2]]]],1]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[[6,[5,[7,0]]],3]", number.toString());
    }

    @Test
    public void fourthTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", number.toString());
    }

    @Test
    public void fifthTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", number.toString());
    }

    @Test
    public void sixthTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", number.toString());
    }

    @Test
    public void eighthTestOfSnailfishNumberExplode() {
        // Arrange
        String input = "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]";

        // Act
        SailfishNumber number = new SailfishNumber(input);
        number.reduce();

        // Assert
        Assert.assertNotNull(number);
        Assert.assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", number.toString());
    }
}
