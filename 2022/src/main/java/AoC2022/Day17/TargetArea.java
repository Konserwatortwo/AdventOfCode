package AoC2022.Day17;

public class TargetArea {

    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public TargetArea(String line) {
        String[] coordinates = line.replace("target area: x=", "").split(", y=");
        String[] coordinatesX = coordinates[0].split("\\.\\.");
        minX = Integer.parseInt(coordinatesX[0]);
        maxX = Integer.parseInt(coordinatesX[1]);
        String[] coordinatesY = coordinates[1].split("\\.\\.");
        minY = Integer.parseInt(coordinatesY[0]);
        maxY = Integer.parseInt(coordinatesY[1]);
    }

    public boolean probeInTargetArea(Probe probe) {
        return minX <= probe.getX() && maxX >= probe.getX() && minY <= probe.getY() && maxY >= probe.getY();
    }

    public boolean probeBeyondTargetArea(Probe probe) {
        return maxX < probe.getX() || minY > probe.getY();
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
}
