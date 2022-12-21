package Day21;

import AoC2022.AdventTask;
import AoC2022.Day21.Task21A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task21ATest {

    private final AdventTask mockedTask = new Task21A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("root: pppw + sjmn");
        report.add("dbpl: 5");
        report.add("cczh: sllz + lgvd");
        report.add("zczc: 2");
        report.add("ptdq: humn - dvpt");
        report.add("dvpt: 3");
        report.add("lfqf: 4");
        report.add("humn: 5");
        report.add("ljgn: 2");
        report.add("sjmn: drzm * dbpl");
        report.add("sllz: 4");
        report.add("pppw: cczh / lfqf");
        report.add("lgvd: ljgn * ptdq");
        report.add("drzm: hmdt - zczc");
        report.add("hmdt: 32");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("152", result.get(0));
    }
}
