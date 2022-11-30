package AoC2022.Day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BingoTable {
    private int boardNumber;
    private List<List<Integer>> rows;
    private boolean isCompleted = false;

    public BingoTable(int boardNumber, List<String> lines) {
        this.boardNumber = boardNumber;

        this.rows = new ArrayList<>();
        int size = lines.size();
        for (int i = 0; i < size; i++) {
            rows.add(new ArrayList<>());
        }

        for (String line : lines) {
            List<Integer> row = new ArrayList<>();
            String[] split = line.split(" ");
            for (int i = 0; i < split.length; i++) {
                String word = split[i];
                if (!word.isEmpty()) {
                    Integer number = Integer.parseInt(word);
                    row.add(number);
                    rows.get(row.size()-1).add(number);
                }

            }
            rows.add(row);
        }
    }

    public int getBoardNumber() {
        return boardNumber;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public boolean checkNumber(Integer number) {
        for (List<Integer> row : rows) {
            if (row.remove(number)) {
                isCompleted |= row.isEmpty();
            }
        }
        return isCompleted;
    }

    public int getRestScore() {
        return rows.stream().flatMap(Collection::stream).reduce(0, Integer::sum) / 2;
    }

}
