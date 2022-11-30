package Day18;

import AoC2022.AdventTask;
import AoC2022.Day18.Task18B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task18BTest {

    private final AdventTask mockedTask = new Task18B();

    @Test
    public void firstTest() {
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
        Assert.assertEquals("3993", result.get(0));
    }
}
