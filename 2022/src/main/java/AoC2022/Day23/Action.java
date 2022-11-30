package AoC2022.Day23;

import AoC2022.Day23.enums.Type;

public class Action {

    private final Type roomType;
    private final Integer toPosition;

    public Action(Room fromRoom, Integer toPosition) {
        this.roomType = fromRoom.getTypeOfRoom();
        this.toPosition = toPosition;
    }

    public Type getRoomType() {
        return roomType;
    }

    public Integer getToPosition() {
        return toPosition;
    }
}
