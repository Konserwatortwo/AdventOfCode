package Day25;

import AoC2023.AdventTask;
import AoC2023.Day25.Task25A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task25ATest {

    private final AdventTask mockedTask = new Task25A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("jqt: rhn xhk nvd");
        report.add("rsh: frs pzl lsr");
        report.add("xhk: hfx");
        report.add("cmg: qnr nvd lhk bvb");
        report.add("rhn: xhk bvb hfx");
        report.add("bvb: xhk hfx");
        report.add("pzl: lsr hfx nvd");
        report.add("qnr: nvd");
        report.add("ntq: jqt hfx bvb xhk");
        report.add("nvd: lhk");
        report.add("lsr: lhk");
        report.add("rzs: qnr cmg lsr rsh");
        report.add("frs: qnr lhk lsr");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("54", result.get(0));
    }
}
