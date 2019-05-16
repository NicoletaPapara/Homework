package hotelmng.model.hotel;

import java.io.Serializable;

/**
 * This class models a hotel. It has an array of rooms.
 */

public class Hotel implements Serializable {

    private final int numberOfRooms;
    private String name;

    private String address;
    private int capacity;
    private Room[] rooms;

    public Hotel(String name, int numberOfRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;

        rooms = new Room[numberOfRooms];
    }

    @Override
    public String toString() {
        return this.name +
                " (" + this.address + ");";
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Room getRoom(int roomNumber) {
        return rooms[roomNumber];
    }

}
