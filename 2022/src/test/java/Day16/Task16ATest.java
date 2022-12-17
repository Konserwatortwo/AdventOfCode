package Day16;

import AoC2022.AdventTask;
import AoC2022.Day16.Task16A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task16ATest {

    private final AdventTask mockedTask = new Task16A();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("Valve AA has flow rate=0; tunnels lead to valves DD, II, BB");
        report.add("Valve BB has flow rate=13; tunnels lead to valves CC, AA");
        report.add("Valve CC has flow rate=2; tunnels lead to valves DD, BB");
        report.add("Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE");
        report.add("Valve EE has flow rate=3; tunnels lead to valves FF, DD");
        report.add("Valve FF has flow rate=0; tunnels lead to valves EE, GG");
        report.add("Valve GG has flow rate=0; tunnels lead to valves FF, HH");
        report.add("Valve HH has flow rate=22; tunnel leads to valve GG");
        report.add("Valve II has flow rate=0; tunnels lead to valves AA, JJ");
        report.add("Valve JJ has flow rate=21; tunnel leads to valve II");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1651", result.get(0));
    }
}
