package Day13;

import AoC2022.AdventTask;
import AoC2022.Day13.Task13B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task13BTest {

    private final AdventTask mockedTask = new Task13B();

    @Test
    public void allPairTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[1,1,3,1,1]");
        report.add("[1,1,5,1,1]");
        report.add("");
        report.add("[[1],[2,3,4]]");
        report.add("[[1],4]");
        report.add("");
        report.add("[9]");
        report.add("[[8,7,6]]");
        report.add("");
        report.add("[[4,4],4,4]");
        report.add("[[4,4],4,4,4]");
        report.add("");
        report.add("[7,7,7,7]");
        report.add("[7,7,7]");
        report.add("");
        report.add("[]");
        report.add("[3]");
        report.add("");
        report.add("[[[]]]");
        report.add("[[]]");
        report.add("");
        report.add("[1,[2,[3,[4,[5,6,7]]]],8,9]");
        report.add("[1,[2,[3,[4,[5,6,0]]]],8,9]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("140", result.get(0));
    }
}
