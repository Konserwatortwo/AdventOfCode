package AoC2021.Day25;

import AoC2021.Day25.enums.State;

import java.util.List;
import java.util.function.Function;

public class Board {

    private final State[][] board;
    private final int sizeX;
    private final int sizeY;

    public Board(List<String> lines) {
        this.sizeX = lines.get(0).length();
        this.sizeY = lines.size();
        this.board = new State[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            char[] line = lines.get(y).toCharArray();
            for (int x = 0; x < sizeX; x++) {
                this.board[x][y] = State.retrieveState(line[x]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                builder.append(this.board[x][y].toString());
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public boolean step() {
        boolean anyMovement = performStep(State.EAST, x -> x == 0 ? sizeX - 1 : x - 1, y -> y);
        anyMovement |= performStep(State.SOUTH, x -> x, y -> y == 0 ? sizeY - 1 : y - 1);
        return anyMovement;
    }

    private boolean performStep(State direction, Function<Integer, Integer> getPreviousX, Function<Integer, Integer> getPreviousY) {
        boolean anyMovement = false;

        for (int x = sizeX - 1; x >= 0; x--) {
            for (int y = sizeY - 1; y >= 0; y--) {
                if (board[x][y] == State.EMPTY && board[getPreviousX.apply(x)][getPreviousY.apply(y)] == direction) {
                    board[x][y] = State.JUST_MOVED;
                    board[getPreviousX.apply(x)][getPreviousY.apply(y)] = State.OCCUPIED;
                    anyMovement = true;
                }
            }
        }

        if (anyMovement) {
            cleanBoard(direction);
        }
        return anyMovement;
    }

    private void cleanBoard(State clearingState) {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (board[x][y] == State.OCCUPIED) {
                    board[x][y] = State.EMPTY;
                }
                if (board[x][y] == State.JUST_MOVED) {
                    board[x][y] = clearingState;
                }
            }
        }
    }
}
