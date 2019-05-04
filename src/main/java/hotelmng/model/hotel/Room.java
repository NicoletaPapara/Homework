package hotelmng.model.hotel;

/**
 * This class models a room of the hotel
 */

public class Room {
    private final int roomNumber;
    private boolean isReserved;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(int roomNumber, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.isReserved = isReserved;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
