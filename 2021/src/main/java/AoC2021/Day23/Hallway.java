package AoC2021.Day23;

import AoC2021.Day23.enums.Type;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hallway {

    private final Map<Integer, Amphipoda> positionInHallway;
    private final Map<Type, Room> roomsInHallway;

    public Hallway(Room... rooms) {
        this.positionInHallway = new HashMap<>();
        createEmptyPositions();
        this.roomsInHallway = new HashMap<>();
        for (Room room : rooms) {
            roomsInHallway.put(room.getTypeOfRoom(), room);
        }
    }

    private void createEmptyPositions() {
        positionInHallway.put(1, null);
        positionInHallway.put(2, null);
        positionInHallway.put(4, null);
        positionInHallway.put(6, null);
        positionInHallway.put(8, null);
        positionInHallway.put(10, null);
        positionInHallway.put(11, null);
    }

    public Hallway(Hallway otherHallway) {
        this.positionInHallway = new HashMap<>();
        for (Map.Entry<Integer, Amphipoda> entry : otherHallway.positionInHallway.entrySet()) {
            this.positionInHallway.put(entry.getKey(), null == entry.getValue() ? null : new Amphipoda(entry.getValue()));
        }

        this.roomsInHallway = new HashMap<>();
        for (Room room : otherHallway.roomsInHallway.values()) {
            this.roomsInHallway.put(room.getTypeOfRoom(), new Room(room));
        }
    }

    public void moveFromRoomToPosition(Type operation, Integer position) {
        Room room = roomsInHallway.get(operation);
        Amphipoda amphipoda = room.getNext();
        amphipoda.move(Math.abs(position - amphipoda.getPosition()));
        amphipoda.setPosition(position);
        positionInHallway.put(position, amphipoda);
    }

    public void completeDesireRoomsTravel() {
        boolean movedToRoom = true;
        while (movedToRoom) {
            movedToRoom = false;
            List<Amphipoda> amphipodasToMove = getAmphipodasToMove();
            for (Amphipoda amphipoda : amphipodasToMove) {
                if (canMoveToDesiredRoom(amphipoda)) {
                    moveToDesiredRoom(amphipoda);
                    movedToRoom = true;
                }
            }
        }
    }

    private List<Amphipoda> getAmphipodasToMove() {
        List<Amphipoda> results = new ArrayList<>();
        results.addAll(getAmphipodasInHallway());
        results.addAll(getAmphipodasInRooms());
        return results;
    }

    private List<Amphipoda> getAmphipodasInHallway() {
        return positionInHallway.values().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<Amphipoda> getAmphipodasInRooms() {
        return roomsInHallway.values().stream()
                .filter(Room::containsIncorrectElements)
                .map(Room::checkNext)
                .collect(Collectors.toList());
    }

    private boolean canMoveToDesiredRoom(Amphipoda amphipoda) {
        Room desiredRoom = roomsInHallway.get(amphipoda.getType());
        if (!desiredRoom.canEnter(amphipoda)) {
            return false;
        }
        Integer actualPosition = amphipoda.getPosition();
        Integer desiredPosition = desiredRoom.getTypeOfRoom().getPositionInHallway();
        return canMove(actualPosition, desiredPosition);
    }

    private boolean canMove(Integer startingPosition, Integer toPosition) {
        int from = Math.min(startingPosition, toPosition) + 1;
        int to = Math.max(startingPosition, toPosition) - 1;
        return IntStream.rangeClosed(from, to)
                .noneMatch(number -> positionInHallway.containsKey(number) && null != positionInHallway.get(number));
    }

    private void moveToDesiredRoom(Amphipoda amphipoda) {
        Room desiredRoom = roomsInHallway.get(amphipoda.getType());
        Integer actualPosition = amphipoda.getPosition();
        Integer desiredPosition = desiredRoom.getTypeOfRoom().getPositionInHallway();
        amphipoda.move(Math.abs(actualPosition - desiredPosition));
        desiredRoom.enter(amphipoda);
        if (positionInHallway.containsKey(actualPosition)) {
            positionInHallway.put(actualPosition, null);
        } else {
            getRoom(actualPosition).getNext();
        }
    }

    private Room getRoom(Integer position) {
        return roomsInHallway.values().stream()
                .filter(room -> room.getTypeOfRoom().getPositionInHallway() == position)
                .findAny().orElseThrow(IllegalStateException::new);
    }

    public Collection<Room> getNotEmptyRoomsInHallway() {
        return roomsInHallway.values().stream().filter(Room::containsIncorrectElements).collect(Collectors.toList());
    }

    public List<Integer> getPossibleFreePositionsForRoom(Room room) {
        Integer roomPosition = room.getTypeOfRoom().getPositionInHallway();
        return getFreePositionsInHallway().stream()
                .filter(freePosition -> canMove(roomPosition, freePosition))
                .collect(Collectors.toList());
    }

    private List<Integer> getFreePositionsInHallway() {
        return positionInHallway.entrySet().stream()
                .filter(entry -> null == entry.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public boolean checkRoomsCorrectness() {
        return roomsInHallway.values().stream().allMatch(Room::isFulfilled);
    }

    public int sumRooms() {
        return roomsInHallway.values().stream().mapToInt(Room::sumAmphipodas).sum();
    }
}
