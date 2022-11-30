package Day22;

import AoC2022.AdventTask;
import AoC2022.Day22.Task22B;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task22BTest {

    private final AdventTask mockedTask = new Task22B();

    @Test
    public void testNo1() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=10..12,y=10..12,z=10..12");
        report.add("on x=11..13,y=11..13,z=11..13");
        report.add("off x=9..11,y=9..11,z=9..11");
        report.add("on x=10..10,y=10..10,z=10..10");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("39", result.get(0));
    }

    @Test
    public void testNo21() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("210918", result.get(0));
    }

    @Test
    public void testNo22() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("225476", result.get(0));
    }

    @Test
    public void testNo23() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("328328", result.get(0));
    }

    @Test
    public void testNo24() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("387734", result.get(0));
    }

    @Test
    public void testNo25() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("420416", result.get(0));
    }

    @Test
    public void testNo26() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("436132", result.get(0));
    }

    @Test
    public void testNo27() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("478727", result.get(0));
    }


    @Test
    public void testNo28() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("494759", result.get(0));
    }

    @Test
    public void testNo29() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("494804", result.get(0));
    }


    @Test
    public void testNo30() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("492164", result.get(0));
    }


    @Test
    public void testNo31() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("534936", result.get(0));
    }


    @Test
    public void testNo32() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("534936", result.get(0));
    }

    @Test
    public void testNo33() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("567192", result.get(0));
    }

    @Test
    public void testNo34() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");
        report.add("off x=-40..-22,y=-38..-28,z=23..41");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("567150", result.get(0));
    }

    @Test
    public void testNo35() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");
        report.add("off x=-40..-22,y=-38..-28,z=23..41");
        report.add("on x=-16..35,y=-41..10,z=-47..6");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("592167", result.get(0));
    }

    @Test
    public void testNo36() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");
        report.add("off x=-40..-22,y=-38..-28,z=23..41");
        report.add("on x=-16..35,y=-41..10,z=-47..6");
        report.add("off x=-32..-23,y=11..30,z=-14..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("588567", result.get(0));
    }

    @Test
    public void testNo37() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");
        report.add("off x=-40..-22,y=-38..-28,z=23..41");
        report.add("on x=-16..35,y=-41..10,z=-47..6");
        report.add("off x=-32..-23,y=11..30,z=-14..3");
        report.add("on x=-49..-5,y=-3..45,z=-29..18");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("592902", result.get(0));
    }

    @Test
    public void testNo38() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");
        report.add("off x=-40..-22,y=-38..-28,z=23..41");
        report.add("on x=-16..35,y=-41..10,z=-47..6");
        report.add("off x=-32..-23,y=11..30,z=-14..3");
        report.add("on x=-49..-5,y=-3..45,z=-29..18");
        report.add("off x=18..30,y=-20..-8,z=-3..13");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("590029", result.get(0));
    }

    @Test
    public void testNo40() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-20..26,y=-36..17,z=-47..7");
        report.add("on x=-20..33,y=-21..23,z=-26..28");
        report.add("on x=-22..28,y=-29..23,z=-38..16");
        report.add("on x=-46..7,y=-6..46,z=-50..-1");
        report.add("on x=-49..1,y=-3..46,z=-24..28");
        report.add("on x=2..47,y=-22..22,z=-23..27");
        report.add("on x=-27..23,y=-28..26,z=-21..29");
        report.add("on x=-39..5,y=-6..47,z=-3..44");
        report.add("on x=-30..21,y=-8..43,z=-13..34");
        report.add("on x=-22..26,y=-27..20,z=-29..19");
        report.add("off x=-48..-32,y=26..41,z=-47..-37");
        report.add("on x=-12..35,y=6..50,z=-50..-2");
        report.add("off x=-48..-32,y=-32..-16,z=-15..-5");
        report.add("on x=-18..26,y=-33..15,z=-7..46");
        report.add("off x=-40..-22,y=-38..-28,z=23..41");
        report.add("on x=-16..35,y=-41..10,z=-47..6");
        report.add("off x=-32..-23,y=11..30,z=-14..3");
        report.add("on x=-49..-5,y=-3..45,z=-29..18");
        report.add("off x=18..30,y=-20..-8,z=-3..13");
        report.add("on x=-41..9,y=-7..43,z=-33..15");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("590784", result.get(0));
    }

    @Test
    public void testNo50() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");
        report.add("on x=-16478..35915,y=36008..118594,z=-7885..47086");
        report.add("off x=-98156..-27851,y=-49952..43171,z=-99005..-8456");
        report.add("off x=2032..69770,y=-71013..4824,z=7471..94418");
        report.add("on x=43670..120875,y=-42068..12382,z=-24787..38892");
        report.add("off x=37514..111226,y=-45862..25743,z=-16714..54663");
        report.add("off x=25699..97951,y=-30668..59918,z=-15349..69697");
        report.add("off x=-44271..17935,y=-9516..60759,z=49131..112598");
        report.add("on x=-61695..-5813,y=40978..94975,z=8655..80240");
        report.add("off x=-101086..-9439,y=-7088..67543,z=33935..83858");
        report.add("off x=18020..114017,y=-48931..32606,z=21474..89843");
        report.add("off x=-77139..10506,y=-89994..-18797,z=-80..59318");
        report.add("off x=8476..79288,y=-75520..11602,z=-96624..-24783");
        report.add("on x=-47488..-1262,y=24338..100707,z=16292..72967");
        report.add("off x=-84341..13987,y=2429..92914,z=-90671..-1318");
        report.add("off x=-37810..49457,y=-71013..-7894,z=-105357..-13188");
        report.add("off x=-27365..46395,y=31009..98017,z=15428..76570");
        report.add("off x=-70369..-16548,y=22648..78696,z=-1892..86821");
        report.add("on x=-53470..21291,y=-120233..-33476,z=-44150..38147");
        report.add("off x=-93533..-4276,y=-16170..68771,z=-104985..-24507");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2758514936282235", result.get(0));
    }

    @Test
    public void testNo51() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("474140", result.get(0));
    }

    @Test
    public void testNo52() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1117416850459262", result.get(0));
    }

    @Test
    public void testNo53() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2796176352477231", result.get(0));
    }

    @Test
    public void testNo54() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3941467117348921", result.get(0));
    }

    @Test
    public void testNo55() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4759573874668344", result.get(0));
    }

    @Test
    public void testNo56() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5465720731552919", result.get(0));
    }

    @Test
    public void testNo57() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5571972171236238", result.get(0));
    }

    @Test
    public void testNo58() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");
        report.add("on x=-16478..35915,y=36008..118594,z=-7885..47086");
        report.add("off x=-98156..-27851,y=-49952..43171,z=-99005..-8456");
        report.add("off x=2032..69770,y=-71013..4824,z=7471..94418");
        report.add("on x=43670..120875,y=-42068..12382,z=-24787..38892");
        report.add("off x=37514..111226,y=-45862..25743,z=-16714..54663");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4656401103275421", result.get(0));
    }

    @Test
    public void testNo59() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");
        report.add("on x=-16478..35915,y=36008..118594,z=-7885..47086");
        report.add("off x=-98156..-27851,y=-49952..43171,z=-99005..-8456");
        report.add("off x=2032..69770,y=-71013..4824,z=7471..94418");
        report.add("on x=43670..120875,y=-42068..12382,z=-24787..38892");
        report.add("off x=37514..111226,y=-45862..25743,z=-16714..54663");
        report.add("off x=25699..97951,y=-30668..59918,z=-15349..69697");
        report.add("off x=-44271..17935,y=-9516..60759,z=49131..112598");
        report.add("on x=-61695..-5813,y=40978..94975,z=8655..80240");
        report.add("off x=-101086..-9439,y=-7088..67543,z=33935..83858");
        report.add("off x=18020..114017,y=-48931..32606,z=21474..89843");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4074912516728465", result.get(0));
    }

    @Test
    public void testNo60() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");
        report.add("on x=-16478..35915,y=36008..118594,z=-7885..47086");
        report.add("off x=-98156..-27851,y=-49952..43171,z=-99005..-8456");
        report.add("off x=2032..69770,y=-71013..4824,z=7471..94418");
        report.add("on x=43670..120875,y=-42068..12382,z=-24787..38892");
        report.add("off x=37514..111226,y=-45862..25743,z=-16714..54663");
        report.add("off x=25699..97951,y=-30668..59918,z=-15349..69697");
        report.add("off x=-44271..17935,y=-9516..60759,z=49131..112598");
        report.add("on x=-61695..-5813,y=40978..94975,z=8655..80240");
        report.add("off x=-101086..-9439,y=-7088..67543,z=33935..83858");
        report.add("off x=18020..114017,y=-48931..32606,z=21474..89843");
        report.add("off x=-77139..10506,y=-89994..-18797,z=-80..59318");
        report.add("off x=8476..79288,y=-75520..11602,z=-96624..-24783");
        report.add("on x=-47488..-1262,y=24338..100707,z=16292..72967");
        report.add("off x=-84341..13987,y=2429..92914,z=-90671..-1318");
        report.add("off x=-37810..49457,y=-71013..-7894,z=-105357..-13188");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2836043623781678", result.get(0));
    }

    @Test
    public void testNo61() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");
        report.add("on x=-16478..35915,y=36008..118594,z=-7885..47086");
        report.add("off x=-98156..-27851,y=-49952..43171,z=-99005..-8456");
        report.add("off x=2032..69770,y=-71013..4824,z=7471..94418");
        report.add("on x=43670..120875,y=-42068..12382,z=-24787..38892");
        report.add("off x=37514..111226,y=-45862..25743,z=-16714..54663");
        report.add("off x=25699..97951,y=-30668..59918,z=-15349..69697");
        report.add("off x=-44271..17935,y=-9516..60759,z=49131..112598");
        report.add("on x=-61695..-5813,y=40978..94975,z=8655..80240");
        report.add("off x=-101086..-9439,y=-7088..67543,z=33935..83858");
        report.add("off x=18020..114017,y=-48931..32606,z=21474..89843");
        report.add("off x=-77139..10506,y=-89994..-18797,z=-80..59318");
        report.add("off x=8476..79288,y=-75520..11602,z=-96624..-24783");
        report.add("on x=-47488..-1262,y=24338..100707,z=16292..72967");
        report.add("off x=-84341..13987,y=2429..92914,z=-90671..-1318");
        report.add("off x=-37810..49457,y=-71013..-7894,z=-105357..-13188");
        report.add("off x=-27365..46395,y=31009..98017,z=15428..76570");
        report.add("off x=-70369..-16548,y=22648..78696,z=-1892..86821");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2451133789619031", result.get(0));
    }

    @Test
    public void testNo62() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=-5..47,y=-31..22,z=-19..33");
        report.add("on x=-44..5,y=-27..21,z=-14..35");
        report.add("on x=-49..-1,y=-11..42,z=-10..38");
        report.add("on x=-20..34,y=-40..6,z=-44..1");
        report.add("off x=26..39,y=40..50,z=-2..11");
        report.add("on x=-41..5,y=-41..6,z=-36..8");
        report.add("off x=-43..-33,y=-45..-28,z=7..25");
        report.add("on x=-33..15,y=-32..19,z=-34..11");
        report.add("off x=35..47,y=-46..-34,z=-11..5");
        report.add("on x=-14..36,y=-6..44,z=-16..29");
        report.add("on x=-57795..-6158,y=29564..72030,z=20435..90618");
        report.add("on x=36731..105352,y=-21140..28532,z=16094..90401");
        report.add("on x=30999..107136,y=-53464..15513,z=8553..71215");
        report.add("on x=13528..83982,y=-99403..-27377,z=-24141..23996");
        report.add("on x=-72682..-12347,y=18159..111354,z=7391..80950");
        report.add("on x=-1060..80757,y=-65301..-20884,z=-103788..-16709");
        report.add("on x=-83015..-9461,y=-72160..-8347,z=-81239..-26856");
        report.add("on x=-52752..22273,y=-49450..9096,z=54442..119054");
        report.add("on x=-29982..40483,y=-108474..-28371,z=-24328..38471");
        report.add("on x=-4958..62750,y=40422..118853,z=-7672..65583");
        report.add("on x=55694..108686,y=-43367..46958,z=-26781..48729");
        report.add("on x=-98497..-18186,y=-63569..3412,z=1232..88485");
        report.add("on x=-726..56291,y=-62629..13224,z=18033..85226");
        report.add("on x=-110886..-34664,y=-81338..-8658,z=8914..63723");
        report.add("on x=-55829..24974,y=-16897..54165,z=-121762..-28058");
        report.add("on x=-65152..-11147,y=22489..91432,z=-58782..1780");
        report.add("on x=-120100..-32970,y=-46592..27473,z=-11695..61039");
        report.add("on x=-18631..37533,y=-124565..-50804,z=-35667..28308");
        report.add("on x=-57817..18248,y=49321..117703,z=5745..55881");
        report.add("on x=14781..98692,y=-1341..70827,z=15753..70151");
        report.add("on x=-34419..55919,y=-19626..40991,z=39015..114138");
        report.add("on x=-60785..11593,y=-56135..2999,z=-95368..-26915");
        report.add("on x=-32178..58085,y=17647..101866,z=-91405..-8878");
        report.add("on x=-53655..12091,y=50097..105568,z=-75335..-4862");
        report.add("on x=-111166..-40997,y=-71714..2688,z=5609..50954");
        report.add("on x=-16602..70118,y=-98693..-44401,z=5197..76897");
        report.add("on x=16383..101554,y=4615..83635,z=-44907..18747");
        report.add("off x=-95822..-15171,y=-19987..48940,z=10804..104439");
        report.add("on x=-89813..-14614,y=16069..88491,z=-3297..45228");
        report.add("on x=41075..99376,y=-20427..49978,z=-52012..13762");
        report.add("on x=-21330..50085,y=-17944..62733,z=-112280..-30197");
        report.add("on x=-16478..35915,y=36008..118594,z=-7885..47086");
        report.add("off x=-98156..-27851,y=-49952..43171,z=-99005..-8456");
        report.add("off x=2032..69770,y=-71013..4824,z=7471..94418");
        report.add("on x=43670..120875,y=-42068..12382,z=-24787..38892");
        report.add("off x=37514..111226,y=-45862..25743,z=-16714..54663");
        report.add("off x=25699..97951,y=-30668..59918,z=-15349..69697");
        report.add("off x=-44271..17935,y=-9516..60759,z=49131..112598");
        report.add("on x=-61695..-5813,y=40978..94975,z=8655..80240");
        report.add("off x=-101086..-9439,y=-7088..67543,z=33935..83858");
        report.add("off x=18020..114017,y=-48931..32606,z=21474..89843");
        report.add("off x=-77139..10506,y=-89994..-18797,z=-80..59318");
        report.add("off x=8476..79288,y=-75520..11602,z=-96624..-24783");
        report.add("on x=-47488..-1262,y=24338..100707,z=16292..72967");
        report.add("off x=-84341..13987,y=2429..92914,z=-90671..-1318");
        report.add("off x=-37810..49457,y=-71013..-7894,z=-105357..-13188");
        report.add("off x=-27365..46395,y=31009..98017,z=15428..76570");
        report.add("off x=-70369..-16548,y=22648..78696,z=-1892..86821");
        report.add("on x=-53470..21291,y=-120233..-33476,z=-44150..38147");
        report.add("off x=-93533..-4276,y=-16170..68771,z=-104985..-24507");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2758514936282235", result.get(0));
    }

    @Test
    public void testNo104() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("27", result.get(0));
    }

    @Test
    public void testNo105() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=2..2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("3", result.get(0));
    }

    @Test
    public void testNo106() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=3..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("4", result.get(0));
    }

    @Test
    public void testNo107() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=3..4");
        report.add("on x=0..0,y=0..0,z=1..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5", result.get(0));
    }

    @Test
    public void testNo108() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=3..4");
        report.add("off x=0..0,y=0..0,z=1..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2", result.get(0));
    }

    @Test
    public void testNo109() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=3..4");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2", result.get(0));
    }

    @Test
    public void testNo110() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=3..4");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("on x=0..0,y=0..0,z=1..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5", result.get(0));
    }


    @Test
    public void testNo111() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..0,y=0..0,z=0..2");
        report.add("on x=0..0,y=0..0,z=3..4");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("on x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("on x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");
        report.add("off x=0..0,y=0..0,z=1..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("2", result.get(0));
    }

    @Test
    public void testNo112() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=0..1,y=0..1,z=0..1");
        report.add("off x=2..2,y=2..2,z=2..2");
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=0..1,y=0..1,z=0..1");
        report.add("off x=2..2,y=2..2,z=2..2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("26", result.get(0));
    }

    @Test
    public void testNo113() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=3..5,y=3..5,z=3..5");
        report.add("off x=6..6,y=6..6,z=6..6");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("54", result.get(0));
    }

    @Test
    public void testNo114() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=3..5,y=3..5,z=3..5");
        report.add("off x=2..3,y=2..3,z=2..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("52", result.get(0));
    }

    @Test
    public void testNo115() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=3..5,y=3..5,z=3..5");
        report.add("off x=2..3,y=2..3,z=2..3");
        report.add("off x=2..3,y=2..3,z=2..3");
        report.add("off x=2..3,y=2..3,z=2..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("52", result.get(0));
    }

    @Test
    public void testNo116() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=1..3,y=1..3,z=1..3");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("46", result.get(0));
    }

    @Test
    public void testNo117() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=1..3,y=1..3,z=1..3");
        report.add("on x=1..2,y=1..2,z=1..2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("46", result.get(0));
    }

    @Test
    public void testNo118() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=1..3,y=1..3,z=1..3");
        report.add("on x=1..2,y=1..2,z=1..2");
        report.add("off x=1..2,y=1..2,z=1..2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("38", result.get(0));
    }

    @Test
    public void testNo119() {
        // Arrange
        List<String> report = new ArrayList<>();
        report.add("on x=0..2,y=0..2,z=0..2");
        report.add("on x=1..3,y=1..3,z=1..3");
        report.add("on x=1..2,y=1..2,z=1..2");
        report.add("off x=1..2,y=1..2,z=1..2");
        report.add("on x=1..2,y=1..2,z=1..2");
        report.add("off x=1..2,y=1..2,z=1..2");
        report.add("on x=1..2,y=1..2,z=1..2");

        // Act
        List<String> result = mockedTask.perform(report);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("46", result.get(0));
    }
}
