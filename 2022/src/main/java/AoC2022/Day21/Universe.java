package AoC2022.Day21;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class Universe extends RecursiveTask<Universe.Outcome> {

    private static final int BOARD_SIZE = 10;
    private static final int GAME_WINNING_SCORE = 21;

    private static final Map<Integer, Long> possibleWays = new HashMap<>();

    static {
        possibleWays.put(3, 1L);
        possibleWays.put(4, 3L);
        possibleWays.put(5, 6L);
        possibleWays.put(6, 7L);
        possibleWays.put(7, 6L);
        possibleWays.put(8, 3L);
        possibleWays.put(9, 1L);
    }

    private static final Map<String, Outcome> detectedOutcomes = new ConcurrentHashMap<>();

    private final boolean isFirstPlayerTurn;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final int turnValue;
    private final long turnWays;
    private final String key;

    public Universe(Player firstPlayer, Player secondPlayer) {
        this.isFirstPlayerTurn = false;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.turnValue = 0;
        this.turnWays = 1;
        this.key = generateKey();
    }

    public Universe(boolean isFirstPlayerTurn, Player firstPlayer, Player secondPlayer, int turnValue, long turnWays) {
        this.isFirstPlayerTurn = isFirstPlayerTurn;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.turnValue = turnValue;
        this.turnWays = turnWays;
        this.key = generateKey();
    }

    private String generateKey() {
        StringJoiner joiner = new StringJoiner("-");
        joiner.add(firstPlayer.getScore() + "").add(firstPlayer.getPosition() + "");
        joiner.add(secondPlayer.getScore() + "").add(secondPlayer.getPosition() + "");
        joiner.add(turnValue + "").add(turnWays + "");
        return joiner.toString();
    }

    @Override
    protected Outcome compute() {
        if (detectedOutcomes.containsKey(key)) {
            return detectedOutcomes.get(key);
        }

        if (turnValue != 0 && movePawn(isFirstPlayerTurn ? firstPlayer : secondPlayer, turnValue)) {
            return new Outcome(isFirstPlayerTurn, turnWays);
        }

        List<Universe> childUniverses = new ArrayList<>();
        for (int dieValue = 3; dieValue <= 9; dieValue++) {
            childUniverses.add(new Universe(!isFirstPlayerTurn, new Player(firstPlayer), new Player(secondPlayer),
                    dieValue, turnWays * possibleWays.get(dieValue)));
        }
        invokeAll(childUniverses);

        Outcome outcome = new Outcome();
        for (Universe child : childUniverses) {
            outcome.add(child.join());
        }
        detectedOutcomes.put(key, outcome);
        return outcome;
    }

    private static boolean movePawn(Player player, int turnValue) {
        int position = turnValue + player.getPosition();
        position = position % BOARD_SIZE;
        player.moveToPosition(position == 0 ? BOARD_SIZE : position);
        return player.getScore() >= GAME_WINNING_SCORE;
    }

    public static class Outcome {

        private BigInteger firstPlayerWinningTimes;
        private BigInteger secondPlayerWinningTimes;

        public Outcome() {
            this.firstPlayerWinningTimes = BigInteger.ZERO;
            this.secondPlayerWinningTimes = BigInteger.ZERO;
        }

        public Outcome(boolean isFirstPlayerWon, long turnWays) {
            this.firstPlayerWinningTimes = isFirstPlayerWon ? BigInteger.valueOf(turnWays) : BigInteger.ZERO;
            this.secondPlayerWinningTimes = isFirstPlayerWon ? BigInteger.ZERO : BigInteger.valueOf(turnWays);
        }

        public void add(Outcome otherOutcome) {
            firstPlayerWinningTimes = firstPlayerWinningTimes.add(otherOutcome.firstPlayerWinningTimes);
            secondPlayerWinningTimes = secondPlayerWinningTimes.add(otherOutcome.secondPlayerWinningTimes);
        }

        public BigInteger returnBigger() {
            return firstPlayerWinningTimes.compareTo(secondPlayerWinningTimes) > 0 ? firstPlayerWinningTimes : secondPlayerWinningTimes;
        }
    }
}
