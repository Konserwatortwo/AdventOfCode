package AoC2021.Day23;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private final Hallway hallway;
    private final Action action;

    public Algorithm(Hallway hallway) {
        this.hallway = new Hallway(hallway);
        this.action = null;
    }

    public Algorithm(Action action, Hallway hallway) {
        this.hallway = new Hallway(hallway);
        this.action = action;
    }

    public List<Integer> perform() {
        performAction();

        hallway.completeDesireRoomsTravel();
        if (hallway.checkRoomsCorrectness()) {
            return List.of(hallway.sumRooms());
        }

        List<Integer> results = new ArrayList<>();
        for (Action possibleAction : determineAllPossibleActions()) {
            results.addAll(new Algorithm(possibleAction, hallway).perform());
        }
        return results;
    }

    private void performAction() {
        if (null != action) {
            hallway.moveFromRoomToPosition(action.getRoomType(), action.getToPosition());
        }
    }

    private List<Action> determineAllPossibleActions() {
        List<Action> results = new ArrayList<>();
        for (Room room : hallway.getNotEmptyRoomsInHallway()) {
            for (Integer position : hallway.getPossibleFreePositionsForRoom(room)) {
                results.add(new Action(room, position));
            }
        }
        return results;
    }
}
