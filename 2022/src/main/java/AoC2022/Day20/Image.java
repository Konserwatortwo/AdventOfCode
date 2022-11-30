package AoC2022.Day20;

import java.util.List;
import java.util.StringJoiner;

public class Image {

    private final int sizeX;
    private final int sizeY;
    private final boolean isOutlineLighten;
    private final boolean[][] setBites;

    public Image(int sizeX, int sizeY, boolean isOutlineLighten) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.isOutlineLighten = isOutlineLighten;
        this.setBites = new boolean[getSizeX()][getSizeY()];
    }

    public Image(List<String> lines) {
        this(lines.get(0).length(), lines.size(), false);
        for (int j = 0; j < lines.size(); j++) {
            char[] charArray = lines.get(j).toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                setBites[i][j] = charArray[i] == '#';
            }
        }
    }

    public Image(Image otherImage, boolean isOutOfImageLighten) {
        this(otherImage.sizeX + 2, otherImage.sizeY + 2, isOutOfImageLighten);
    }

    public boolean isOutlineLighten() {
        return isOutlineLighten;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int determineValueExpectedOnPosition(int x, int y) {
        StringBuilder binary = new StringBuilder();
        for (int nearbyY = -1; nearbyY <= 1; nearbyY++) {
            for (int nearbyX = -1; nearbyX <= 1; nearbyX++) {
                binary.append(retrieveBitOnPosition(x + nearbyX, y + nearbyY) ? "1" : "0");
            }
        }
        return Integer.parseInt(binary.toString(), 2);
    }

    private boolean retrieveBitOnPosition(int x, int y) {
        return isOutOfImage(x, y) ? isOutlineLighten : setBites[x][y];
    }

    private boolean isOutOfImage(int x, int y) {
        return x < 0 || x >= getSizeX() || y < 0 || y >= getSizeY();
    }

    public void setBiteOnPosition(int x, int y) {
        this.setBites[x][y] = true;
    }

    public int countBites() {
        int counter = 0;
        for (int x = 0; x < getSizeX(); x++) {
            for (int y = 0; y < getSizeY(); y++) {
                counter += setBites[x][y] ? 1 : 0;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        int padding = 5;
        StringJoiner joiner = new StringJoiner("\n");
        for (int y = -padding; y < getSizeY()+padding; y++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int x = -padding; x < getSizeX()+padding; x++) {
                stringBuilder.append(retrieveBitOnPosition(x, y) ? "#" : ".").append(" ");
            }
            joiner.add(stringBuilder.toString());
        }
        joiner.add("");
        return joiner.toString();
    }
}
