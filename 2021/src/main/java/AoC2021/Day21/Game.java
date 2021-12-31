package AoC2021.Day21;

import java.util.List;

public class Game {

    private static final int BOARD_SIZE = 10;
    private static final int GAME_WINNING_SCORE = 1000;
    private static final int DIE_MAX_VALUE = 100;

    private final List<Player> players;
    private int currentRoll = 0;
    private int currentPlayer = -1;
    private int diceRolled = 0;
    private Player wonPlayer;

    public Game(List<Player> players) {
        this.players = players;
    }

    public int play() {
        Player playerTurn;
        int turnScore;
        while (null == wonPlayer) {
            playerTurn = getNextPlayer();
            System.out.println();

            turnScore = getTurnScore();
            movePawn(playerTurn, turnScore);
            if (checkIfPlayerWon(playerTurn)) {
                wonPlayer = playerTurn;
            }
        }
        return getNextPlayer().getScore() * diceRolled;
    }

    private Player getNextPlayer() {
        if (++currentPlayer == players.size()) {
            currentPlayer = 0;
        }
        return players.get(currentPlayer);
    }

    private int getTurnScore() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += getCurrentRoll();
        }
        return sum;
    }

    private int getCurrentRoll() {
        diceRolled++;
        if (++currentRoll > DIE_MAX_VALUE) {
            currentRoll = 1;
        }
        return currentRoll;
    }

    private void movePawn(Player player, int turnScore) {
        int position = turnScore + player.getPosition();
        position = position % BOARD_SIZE;
        player.moveToPosition(position == 0 ? BOARD_SIZE : position);
    }

    private boolean checkIfPlayerWon(Player player) {
        return player.getScore() >= GAME_WINNING_SCORE;
    }
}
