package Day19;

import AoC2023.AdventTask;
import AoC2023.Day19.Task19A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task19ATest {

    private final AdventTask mockedTask = new Task19A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("px{a<2006:qkq,m>2090:A,rfg}");
        report.add("pv{a>1716:R,A}");
        report.add("lnx{m>1548:A,A}");
        report.add("rfg{s<537:gd,x>2440:R,A}");
        report.add("qs{s>3448:A,lnx}");
        report.add("qkq{x<1416:A,crn}");
        report.add("crn{x>2662:A,R}");
        report.add("in{s<1351:px,qqz}");
        report.add("qqz{s>2770:qs,m<1801:hdj,R}");
        report.add("gd{a>3333:R,R}");
        report.add("hdj{m>838:A,pv}");
        report.add("");
        report.add("{x=787,m=2655,a=1222,s=2876}");
        report.add("{x=1679,m=44,a=2067,s=496}");
        report.add("{x=2036,m=264,a=79,s=2244}");
        report.add("{x=2461,m=1339,a=466,s=291}");
        report.add("{x=2127,m=1623,a=2188,s=1013}");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("19114", result.get(0));
    }
}
