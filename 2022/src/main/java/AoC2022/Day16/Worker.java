package AoC2022.Day16;

public class Worker {
    private String name;
    private int timeLeft;
    private Room currentRoom;

    public Worker(int timeLeft, String name) {
        this.timeLeft = timeLeft;
        this.name = name;
    }

    public Worker(Worker other) {
        this.timeLeft = other.timeLeft;
        this.currentRoom = other.currentRoom;
        this.name = other.name;
    }

    public Worker(int timeLeft, Room currentRoom) {
        this.timeLeft = timeLeft;
        this.currentRoom = currentRoom;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public boolean haveEnoughTime(int cost) {
        return timeLeft > cost;
    }

    public void takeTime(int time) {
        this.timeLeft -= time;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveToRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " timeLeft=" + timeLeft + " currentRoom=" + currentRoom;
    }
}
