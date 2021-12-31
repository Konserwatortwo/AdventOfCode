package AoC2021.Day23;

import AoC2021.Day23.enums.Type;

import java.util.Stack;

public class Room {

    private final Type typeOfRoom;
    private final Stack<Amphipoda> content;
    private final Stack<Amphipoda> correctContent;
    private int expectedElements;

    public Room(Type typeOfRoom, Amphipoda... amphipodas) {
        this.typeOfRoom = typeOfRoom;

        this.content = new Stack<>();
        this.correctContent = new Stack<>();
        boolean isCorrectSequence = true;
        for (int i = amphipodas.length - 1; i >= 0; i--) {
            Amphipoda amphipoda = amphipodas[i];
            if (!isCorrectSequence || amphipoda.getType() != typeOfRoom) {
                this.content.push(amphipoda);
                isCorrectSequence = false;
            } else {
                this.correctContent.add(amphipoda);
            }
        }

        this.expectedElements = content.size();

        for (Amphipoda amphipoda : amphipodas) {
            amphipoda.setPosition(typeOfRoom.getPositionInHallway());
        }
    }

    public Room(Room otherRoom) {
        this.typeOfRoom = otherRoom.typeOfRoom;
        this.content = new Stack<>();
        for (Amphipoda amphipoda : otherRoom.content) {
            content.add(new Amphipoda(amphipoda));
        }
        this.correctContent = new Stack<>();
        for (Amphipoda amphipoda : otherRoom.correctContent) {
            correctContent.add(new Amphipoda(amphipoda));
        }
        this.expectedElements = otherRoom.expectedElements;
    }

    public Type getTypeOfRoom() {
        return typeOfRoom;
    }

    public Amphipoda checkNext() {
        return content.peek();
    }

    public Amphipoda getNext() {
        Amphipoda amphipoda = content.pop();
        amphipoda.move(expectedElements - content.size());
        return amphipoda;
    }

    public boolean containsIncorrectElements() {
        return !content.isEmpty();
    }

    public boolean canEnter(Amphipoda amphipoda) {
        return content.isEmpty() && amphipoda.getType() == typeOfRoom;
    }

    public void enter(Amphipoda amphipoda) {
        amphipoda.setPosition(typeOfRoom.getPositionInHallway());
        amphipoda.move(expectedElements);
        correctContent.add(amphipoda);
        this.expectedElements--;
    }

    public boolean isFulfilled() {
        return expectedElements == 0;
    }

    public int sumAmphipodas() {
        return correctContent.stream().mapToInt(Amphipoda::getCost).sum();
    }
}

