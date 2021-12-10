package Day10;

import AoC2021.AdventTask;
import AoC2021.Day10.Task10B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task10BTest {

    private final AdventTask mockedTask = new Task10B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("[({(<(())[]>[[{[]{<()<>>");
        report.add("[(()[<>])]({[<{<<[]>>(");
        report.add("{([(<{}[<>[]}>{[]{[(<()>");
        report.add("(((({<>}<{<{<>}{[]{[]{}");
        report.add("[[<[([]))<([[{}[[()]]]");
        report.add("[{[{({}]{}}([{[{{{}}([]");
        report.add("{<[[]]>}<{[{[{[]{()[[[]");
        report.add("[<(<(<(<{}))><([]([]()");
        report.add("<{([([[(<>()){}]>(<<{{");
        report.add("<{([{{}}[<[[[<>{}]]]>[]]");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("288957", result.get(0));
    }
}
