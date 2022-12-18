package AoC2022.Day16;

public class Worker {
    private int timeLeft;
    private Room currentRoom;

    public Worker(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Worker(Worker other) {
        this.timeLeft = other.timeLeft;
        this.currentRoom = other.currentRoom;
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
}
