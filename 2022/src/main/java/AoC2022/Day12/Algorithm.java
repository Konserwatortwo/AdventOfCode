package AoC2022.Day12;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Algorithm {

    private final Tile[][] board;

    private final int sizeX;
    private final int sizeY;
    private final Queue<Step> steps;

    private Tile start;
    private Tile goal;

    public Algorithm(List<String> input) {
        steps = new LinkedList<>();
        sizeY = input.size();
        sizeX = input.get(0).length();
        board = new Tile[sizeX][sizeY];
        for (int y = 0; y < input.size(); y++) {
            char[] charArray = input.get(y).toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                char value = charArray[x];
                Tile tile;
                switch (value) {
                    case 'S' -> {
                        tile = new Tile(x, y, 'a');
                        start = tile;
                    }
                    case 'E' -> {
                        tile = new Tile(x, y, 'z');
                        goal = tile;
                    }
                    default -> tile = new Tile(x, y, value);

                }
                board[x][y] = tile;
            }
        }
    }

    public int run() {
        Step current = new Step(start);
        while (current.getTile() != goal) {
            considerNeighbors(current, Step::canMoveOnTile);
            current = steps.remove();
        }
        return current.getNumberOfVisited();
    }

    public int runBackwards() {
        Step current = new Step(goal);
        while (current.getTile().getValue() != 'a') {
            considerNeighbors(current, Step::canMoveOnTileBackwards);
            current = steps.remove();
        }
        return current.getNumberOfVisited();
    }

    private void considerNeighbors(Step current, BiPredicate<Step, Tile> canMove) {
        considerNeighbor(current, x -> x + 1, y -> y, canMove);
        considerNeighbor(current, x -> x - 1, y -> y, canMove);
        considerNeighbor(current, x -> x, y -> y + 1, canMove);
        considerNeighbor(current, x -> x, y -> y - 1, canMove);
    }

    private void considerNeighbor(Step current, Function<Integer, Integer> changeX, Function<Integer, Integer> changeY, BiPredicate<Step, Tile> canMove) {
        int newX = changeX.apply(current.getTile().getPositionX());
        int newY = changeY.apply(current.getTile().getPositionY());

        if (isOnBoard(newX, newY) && canMove.test(current, board[newX][newY])) {
            steps.add(new Step(board[newX][newY], current));
        }
    }

    private boolean isOnBoard(int x, int y) {
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }
}
