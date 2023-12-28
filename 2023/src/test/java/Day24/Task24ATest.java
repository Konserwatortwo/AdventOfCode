package Day24;

import AoC2023.Day24.CheckingGround;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task24ATest {

    @Test
    public void firstTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("19, 13, 30 @ -2,  1, -2");
        report.add("18, 19, 22 @ -1, -1, -2");
        report.add("20, 25, 34 @ -2, -2, -4");
        report.add("12, 31, 28 @ -1, -2, -1");
        report.add("20, 19, 15 @  1, -5, -3");

        // Act
        long result = CheckingGround.of(report).countCollisionIn(7, 27);

        // Assert
        Assert.assertEquals(2, result);
    }
}
