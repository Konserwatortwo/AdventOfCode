package AoC2022.Day20;

public class Algorithm {

    private final boolean[] setBites;

    public Algorithm(String line) {
        this.setBites = new boolean[512];
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            setBites[i] = charArray[i] == '#';
        }
    }

    public Image perform(Image oldImage) {
        Image newImage = new Image(oldImage, shouldOuterSpaceBeLighten(oldImage.isOutlineLighten()));
        for (int x = -1; x < oldImage.getSizeX() + 1; x++) {
            for (int y = -1; y < oldImage.getSizeY() + 1; y++) {
                if (setBites[oldImage.determineValueExpectedOnPosition(x, y)]) {
                    newImage.setBiteOnPosition(x + 1, y + 1);
                }
            }
        }
        return newImage;
    }

    private boolean shouldOuterSpaceBeLighten(boolean isLighten) {
        return isLighten ? setBites[setBites.length - 1] : setBites[0];
    }
}
