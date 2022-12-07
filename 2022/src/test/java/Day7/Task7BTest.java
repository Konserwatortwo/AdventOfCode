package Day7;

import AoC2022.AdventTask;
import AoC2022.Day7.Task7B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task7BTest {

    private final AdventTask mockedTask = new Task7B();

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("$ cd /");
        report.add("$ ls");
        report.add("dir a");
        report.add("14848514 b.txt");
        report.add("8504156 c.dat");
        report.add("dir d");
        report.add("$ cd a");
        report.add("$ ls");
        report.add("dir e");
        report.add("29116 f");
        report.add("2557 g");
        report.add("62596 h.lst");
        report.add("$ cd e");
        report.add("$ ls");
        report.add("584 i");
        report.add("$ cd ..");
        report.add("$ cd ..");
        report.add("$ cd d");
        report.add("$ ls");
        report.add("4060174 j");
        report.add("8033020 d.log");
        report.add("5626152 d.ext");
        report.add("7214296 k");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("24933642", result.get(0));
    }
}
