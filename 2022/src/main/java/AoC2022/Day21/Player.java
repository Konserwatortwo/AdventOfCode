package AoC2022.Day21;

public class Player {

    private int position;
    private int score;

    public Player(String line) {
        String[] elements = line.replace(" starting position: ", ":").split(":");
        this.position = Integer.parseInt(elements[1]);
        this.score = 0;
    }

    public Player(Player otherPlayer) {
        this.position = otherPlayer.position;
        this.score = otherPlayer.score;
    }

    public int getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public void moveToPosition(int position) {
        this.score += position;
        this.position = position;
    }
}
