package Day25;

import AoC2021.AdventTask;
import AoC2021.Day23.Task23A;
import AoC2021.Day25.Board;
import AoC2021.Day25.Task25A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task25ATest {

    private final AdventTask mockedTask = new Task25A();

    @Test
    public void firstTestFirstStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...>...");
        report.add(".......");
        report.add("......>");
        report.add("v.....>");
        report.add("......>");
        report.add(".......");
        report.add("..vvv..");

        // Act
        Board board = new Board(report);

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("...>...", lines[0]);
        Assert.assertEquals(".......", lines[1]);
        Assert.assertEquals("......>", lines[2]);
        Assert.assertEquals("v.....>", lines[3]);
        Assert.assertEquals("......>", lines[4]);
        Assert.assertEquals(".......", lines[5]);
        Assert.assertEquals("..vvv..", lines[6]);
    }

    @Test
    public void firstTestSecondStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...>...");
        report.add(".......");
        report.add("......>");
        report.add("v.....>");
        report.add("......>");
        report.add(".......");
        report.add("..vvv..");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 1; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("..vv>..", lines[0]);
        Assert.assertEquals(".......", lines[1]);
        Assert.assertEquals(">......", lines[2]);
        Assert.assertEquals("v.....>", lines[3]);
        Assert.assertEquals(">......", lines[4]);
        Assert.assertEquals(".......", lines[5]);
        Assert.assertEquals("....v..", lines[6]);
    }

    @Test
    public void firstTestThirdStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...>...");
        report.add(".......");
        report.add("......>");
        report.add("v.....>");
        report.add("......>");
        report.add(".......");
        report.add("..vvv..");


        // Act
        Board board = new Board(report);
        for (int i = 0; i < 2; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("....v>.", lines[0]);
        Assert.assertEquals("..vv...", lines[1]);
        Assert.assertEquals(".>.....", lines[2]);
        Assert.assertEquals("......>", lines[3]);
        Assert.assertEquals("v>.....", lines[4]);
        Assert.assertEquals(".......", lines[5]);
        Assert.assertEquals(".......", lines[6]);
    }

    @Test
    public void firstTestFourthStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...>...");
        report.add(".......");
        report.add("......>");
        report.add("v.....>");
        report.add("......>");
        report.add(".......");
        report.add("..vvv..");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 3; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("......>", lines[0]);
        Assert.assertEquals("..v.v..", lines[1]);
        Assert.assertEquals("..>v...", lines[2]);
        Assert.assertEquals(">......", lines[3]);
        Assert.assertEquals("..>....", lines[4]);
        Assert.assertEquals("v......", lines[5]);
        Assert.assertEquals(".......", lines[6]);
    }

    @Test
    public void firstTestFifthStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("...>...");
        report.add(".......");
        report.add("......>");
        report.add("v.....>");
        report.add("......>");
        report.add(".......");
        report.add("..vvv..");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 4; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals(">......", lines[0]);
        Assert.assertEquals("..v....", lines[1]);
        Assert.assertEquals("..>.v..", lines[2]);
        Assert.assertEquals(".>.v...", lines[3]);
        Assert.assertEquals("...>...", lines[4]);
        Assert.assertEquals(".......", lines[5]);
        Assert.assertEquals("v......", lines[6]);
    }

    @Test
    public void secondTestFirstStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("v...>>.vv>", lines[0]);
        Assert.assertEquals(".vv>>.vv..", lines[1]);
        Assert.assertEquals(">>.>v>...v", lines[2]);
        Assert.assertEquals(">>v>>.>.v.", lines[3]);
        Assert.assertEquals("v>v.vv.v..", lines[4]);
        Assert.assertEquals(">.>>..v...", lines[5]);
        Assert.assertEquals(".vv..>.>v.", lines[6]);
        Assert.assertEquals("v.v..>>v.v", lines[7]);
        Assert.assertEquals("....v..v.>", lines[8]);
    }

    @Test
    public void secondTestSecondStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 1; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("....>.>v.>", lines[0]);
        Assert.assertEquals("v.v>.>v.v.", lines[1]);
        Assert.assertEquals(">v>>..>v..", lines[2]);
        Assert.assertEquals(">>v>v>.>.v", lines[3]);
        Assert.assertEquals(".>v.v...v.", lines[4]);
        Assert.assertEquals("v>>.>vvv..", lines[5]);
        Assert.assertEquals("..v...>>..", lines[6]);
        Assert.assertEquals("vv...>>vv.", lines[7]);
        Assert.assertEquals(">.v.v..v.v", lines[8]);
    }

    @Test
    public void secondTestThirdStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 2; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals(">.v.v>>..v", lines[0]);
        Assert.assertEquals("v.v.>>vv..", lines[1]);
        Assert.assertEquals(">v>.>.>.v.", lines[2]);
        Assert.assertEquals(">>v>v.>v>.", lines[3]);
        Assert.assertEquals(".>..v....v", lines[4]);
        Assert.assertEquals(".>v>>.v.v.", lines[5]);
        Assert.assertEquals("v....v>v>.", lines[6]);
        Assert.assertEquals(".vv..>>v..", lines[7]);
        Assert.assertEquals("v>.....vv.", lines[8]);
    }

    @Test
    public void secondTestFourthStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 3; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("v>v.v>.>v.", lines[0]);
        Assert.assertEquals("v...>>.v.v", lines[1]);
        Assert.assertEquals(">vv>.>v>..", lines[2]);
        Assert.assertEquals(">>v>v.>.v>", lines[3]);
        Assert.assertEquals("..>....v..", lines[4]);
        Assert.assertEquals(".>.>v>v..v", lines[5]);
        Assert.assertEquals("..v..v>vv>", lines[6]);
        Assert.assertEquals("v.v..>>v..", lines[7]);
        Assert.assertEquals(".v>....v..", lines[8]);
    }

    @Test
    public void secondTestFifthStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 4; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("v>..v.>>..", lines[0]);
        Assert.assertEquals("v.v.>.>.v.", lines[1]);
        Assert.assertEquals(">vv.>>.v>v", lines[2]);
        Assert.assertEquals(">>.>..v>.>", lines[3]);
        Assert.assertEquals("..v>v...v.", lines[4]);
        Assert.assertEquals("..>>.>vv..", lines[5]);
        Assert.assertEquals(">.v.vv>v.v", lines[6]);
        Assert.assertEquals(".....>>vv.", lines[7]);
        Assert.assertEquals("vvv>...v..", lines[8]);
    }

    @Test
    public void secondTestSixthStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 5; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("vv>...>v>.", lines[0]);
        Assert.assertEquals("v.v.v>.>v.", lines[1]);
        Assert.assertEquals(">.v.>.>.>v", lines[2]);
        Assert.assertEquals(">v>.>..v>>", lines[3]);
        Assert.assertEquals("..v>v.v...", lines[4]);
        Assert.assertEquals("..>.>>vvv.", lines[5]);
        Assert.assertEquals(".>...v>v..", lines[6]);
        Assert.assertEquals("..v.v>>v.v", lines[7]);
        Assert.assertEquals("v.v.>...v.", lines[8]);
    }

    @Test
    public void secondTestTenthStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 10; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("..>..>>vv.", lines[0]);
        Assert.assertEquals("v.....>>.v", lines[1]);
        Assert.assertEquals("..v.v>>>v>", lines[2]);
        Assert.assertEquals("v>.>v.>>>.", lines[3]);
        Assert.assertEquals("..v>v.vv.v", lines[4]);
        Assert.assertEquals(".v.>>>.v..", lines[5]);
        Assert.assertEquals("v.v..>v>..", lines[6]);
        Assert.assertEquals("..v...>v.>", lines[7]);
        Assert.assertEquals(".vv..v>vv.", lines[8]);
    }

    @Test
    public void secondTestTwentyStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 20; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("v>.....>>.", lines[0]);
        Assert.assertEquals(">vv>.....v", lines[1]);
        Assert.assertEquals(".>v>v.vv>>", lines[2]);
        Assert.assertEquals("v>>>v.>v.>", lines[3]);
        Assert.assertEquals("....vv>v..", lines[4]);
        Assert.assertEquals(".v.>>>vvv.", lines[5]);
        Assert.assertEquals("..v..>>vv.", lines[6]);
        Assert.assertEquals("v.v...>>.v", lines[7]);
        Assert.assertEquals("..v.....v>", lines[8]);
    }

    @Test
    public void secondTestFortyStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 40; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals(">>v>v..v..", lines[0]);
        Assert.assertEquals("..>>v..vv.", lines[1]);
        Assert.assertEquals("..>>>v.>.v", lines[2]);
        Assert.assertEquals("..>>>>vvv>", lines[3]);
        Assert.assertEquals("v.....>...", lines[4]);
        Assert.assertEquals("v.v...>v>>", lines[5]);
        Assert.assertEquals(">vv.....v>", lines[6]);
        Assert.assertEquals(".>v...v.>v", lines[7]);
        Assert.assertEquals("vvv.v..v.>", lines[8]);
    }

    @Test
    public void secondTestFiftyStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 50; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("..>>v>vv.v", lines[0]);
        Assert.assertEquals("..v.>>vv..", lines[1]);
        Assert.assertEquals("v.>>v>>v..", lines[2]);
        Assert.assertEquals("..>>>>>vv.", lines[3]);
        Assert.assertEquals("vvv....>vv", lines[4]);
        Assert.assertEquals("..v....>>>", lines[5]);
        Assert.assertEquals("v>.......>", lines[6]);
        Assert.assertEquals(".vv>....v>", lines[7]);
        Assert.assertEquals(".>v.vv.v..", lines[8]);
    }

    @Test
    public void secondTestFiftyFiveStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 55; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("..>>v>vv..", lines[0]);
        Assert.assertEquals("..v.>>vv..", lines[1]);
        Assert.assertEquals("..>>v>>vv.", lines[2]);
        Assert.assertEquals("..>>>>>vv.", lines[3]);
        Assert.assertEquals("v......>vv", lines[4]);
        Assert.assertEquals("v>v....>>v", lines[5]);
        Assert.assertEquals("vvv...>..>", lines[6]);
        Assert.assertEquals(">vv.....>.", lines[7]);
        Assert.assertEquals(".>v.vv.v..", lines[8]);
    }

    @Test
    public void secondTestSixtyStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 60; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("..>>v>vv..", lines[0]);
        Assert.assertEquals("..v.>>vv..", lines[1]);
        Assert.assertEquals("..>>v>>vv.", lines[2]);
        Assert.assertEquals("..>>>>>vv.", lines[3]);
        Assert.assertEquals("v......>vv", lines[4]);
        Assert.assertEquals("v>v....>>v", lines[5]);
        Assert.assertEquals("vvv.....>>", lines[6]);
        Assert.assertEquals(">vv......>", lines[7]);
        Assert.assertEquals(".>v.vv.v..", lines[8]);
    }

    @Test
    public void secondTestSeventyStep() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        Board board = new Board(report);
        for (int i = 0; i < 70; i++) {
            board.step();
        }

        // Assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.toString());
        String[] lines = board.toString().split("\n");
        Assert.assertEquals(report.size(), lines.length);
        Assert.assertEquals("..>>v>vv..", lines[0]);
        Assert.assertEquals("..v.>>vv..", lines[1]);
        Assert.assertEquals("..>>v>>vv.", lines[2]);
        Assert.assertEquals("..>>>>>vv.", lines[3]);
        Assert.assertEquals("v......>vv", lines[4]);
        Assert.assertEquals("v>v....>>v", lines[5]);
        Assert.assertEquals("vvv.....>>", lines[6]);
        Assert.assertEquals(">vv......>", lines[7]);
        Assert.assertEquals(".>v.vv.v..", lines[8]);
    }

    @Test
    public void thirdTest() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("v...>>.vv>");
        report.add(".vv>>.vv..");
        report.add(">>.>v>...v");
        report.add(">>v>>.>.v.");
        report.add("v>v.vv.v..");
        report.add(">.>>..v...");
        report.add(".vv..>.>v.");
        report.add("v.v..>>v.v");
        report.add("....v..v.>");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("58", result.get(0));
    }
}
