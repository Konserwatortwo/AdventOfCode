package Day15;

import AoC2023.Day15.Task15A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task15ATest {

    private final Task15A mockedTask = new Task15A();
    
    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1320", result.get(0));
    }
}
