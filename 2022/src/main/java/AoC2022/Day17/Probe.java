package AoC2022.Day17;

public class Probe {
    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public Probe(int velocityX, int velocityY) {
        this.x = 0;
        this.y = 0;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void calculateNextStep() {
        x += velocityX;
        y += velocityY;
        resistanceToVelocity();
    }

    private void resistanceToVelocity() {
        if (velocityX < 0) {
            velocityX++;
        } else if (velocityX > 0) {
            velocityX--;
        }
        velocityY--;
    }
}
