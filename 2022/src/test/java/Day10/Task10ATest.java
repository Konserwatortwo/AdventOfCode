package Day10;

import AoC2022.AdventTask;
import AoC2022.Day10.Task10A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task10ATest {

    private final AdventTask mockedTask = new Task10A();

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
        Assert.assertEquals("26397", result.get(0));
    }
}
