package hotel_mng.hotel;

/**
 * This class models a room of the hotel
 */

public class Room {
    private final int RoomNumber;
    private boolean isReserved;

    public Room(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
