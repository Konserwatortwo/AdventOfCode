package AoC2022.Day23;

import AoC2022.AdventTask;
import AoC2022.Day23.enums.Type;

import java.util.Collections;
import java.util.List;

public class Task23B extends AdventTask {

    public Task23B() {
        super("Day23", "Task23B");
    }

    @Override
    public List<String> perform(List<String> input) {
        Hallway firstHallway = readData(input);
        Algorithm algorithm = new Algorithm(firstHallway);
        List<Integer> results = algorithm.perform();
        Collections.sort(results);
        return List.of(results.get(0) + "");
    }

    private static Hallway readData(List<String> input) {
        Room[] rooms = new Room[4];
        Amphipoda[] amphipodas = new Amphipoda[4];
        for (int i = 0, inputSize = input.size(); i < inputSize; i++) {
            String line = input.get(i);
            char[] charArray = line.toCharArray();
            for (int j = 0; j < 4; j++) {
                amphipodas[j] = new Amphipoda(switch (charArray[j]) {
                    case 'A' -> Type.AMBER;
                    case 'B' -> Type.BRONZE;
                    case 'C' -> Type.COPPER;
                    case 'D' -> Type.DESERT;
                    default -> throw new IllegalStateException();
                });
            }
            rooms[i] = new Room(Type.values()[i], amphipodas);
            amphipodas = new Amphipoda[4];
        }
        return new Hallway(rooms);
    }
}
