package AoC2022.Day5;

import java.util.List;

public class Direction {

    enum Angle {
        IS_0_DEGREES(0.0f, 1, 0),
        IS_45_DEGREES(45.0f, 1, 1),
        IS_90_DEGREES(90.0f, 0, 1),
        IS_135_DEGREES(135.0f, -1, 1),
        IS_180_DEGREES(180.0f, -1, 0),
        IS_225_DEGREES(225.0f, -1, -1),
        IS_270_DEGREES(270.0f, 0, -1),
        IS_315_DEGREES(315.0f, 1, -1);

        private float angle;
        private int vectorX;
        private int vectorY;

        Angle(float angle, int vectorX, int vectorY) {
            this.angle = angle;
            this.vectorX = vectorX;
            this.vectorY = vectorY;
        }

        public int getVectorX() {
            return vectorX;
        }

        public int getVectorY() {
            return vectorY;
        }

        private boolean checkAngle(float compareAngle) {
            return this.angle == compareAngle;
        }


    }

    private int x1;
    private int x2;

    private int y1;
    private int y2;

    private Angle angle = null;

    public Direction(String line) {
        String[] direction = line.trim().split(" -> ");
        String[] firstDirection = direction[0].trim().split(",");
        String[] secondDirection = direction[1].trim().split(",");
        this.x1 = Integer.parseInt(firstDirection[0]);
        this.y1 = Integer.parseInt(firstDirection[1]);
        this.x2 = Integer.parseInt(secondDirection[0]);
        this.y2 = Integer.parseInt(secondDirection[1]);

        float actualAngle = getAngle();
        for (Angle value : Angle.values()) {
            if (value.checkAngle(actualAngle)) {
                angle = value;
                return;
            }
        }
    }

    private float getAngle() {
        float angle = (float) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    public boolean isStraight() {
        return List.of(Angle.IS_0_DEGREES, Angle.IS_90_DEGREES, Angle.IS_180_DEGREES, Angle.IS_270_DEGREES).contains(angle);
    }

    public boolean is45Degree() {
        return angle != null;
    }

    public void markDirection(int[][] platform) {
        int positionX = x1;
        int positionY = y1;
        platform[positionX][positionY]++;

        while (positionX != x2 || positionY != y2) {
            positionX += angle.getVectorX();
            positionY += angle.getVectorY();
            platform[positionX][positionY]++;
        }
    }
}
