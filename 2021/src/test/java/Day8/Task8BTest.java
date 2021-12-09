package Day8;

import AoC2021.AdventTask;
import AoC2021.Day8.Task8B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task8BTest {

    private final AdventTask mockedTask = new Task8B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");
        report.add("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc");
        report.add("fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg");
        report.add("fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb");
        report.add("aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea");
        report.add("fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb");
        report.add("dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe");
        report.add("bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef");
        report.add("egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb");
        report.add("gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("61229", result.get(0));
    }
}
