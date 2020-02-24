package AdventOfCode.Day1;

import org.junit.Assert;
import org.junit.Test;

public class Task1ATest {

    @Test
    public void firstTest() {
        // Arrange
        long mass = 12;

        // Act
        long fuel = new Task1A().fuelForMass(mass);

        // Assert
        Assert.assertEquals(2, fuel);
    }

    @Test
    public void secondTest() {
        // Arrange
        long mass = 14;

        // Act
        long fuel = new Task1A().fuelForMass(mass);

        // Assert
        Assert.assertEquals(2, fuel);
    }

    @Test
    public void thirdTest() {
        // Arrange
        long mass = 1969;

        // Act
        long fuel = new Task1A().fuelForMass(mass);

        // Assert
        Assert.assertEquals(654, fuel);
    }

    @Test
    public void fourthTest() {
        // Arrange
        long mass = 100756;

        // Act
        long fuel = new Task1A().fuelForMass(mass);

        // Assert
        Assert.assertEquals(33583, fuel);
    }
}