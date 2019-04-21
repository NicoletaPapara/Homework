package hotelmng.models.hotel;

/**
 * This class models a hotel. It has an array of rooms.
 */

public class Hotel {

    private final int numberOfRooms;
    private String name;

    private String address;
    private int capacity;
    private Room[] rooms;

    public Hotel(String name, int numberOfRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;

        rooms= new Room[numberOfRooms];

        //creates the rooms of the hotel based on number of rooms set

        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(i + 1);
        }
    }

    public double checkStatus() {
        int reservedRooms = 0;
        for (int i = 0; i < numberOfRooms; i++) {
            if (rooms[i].isReserved()) {
                reservedRooms += 1;
            }
        }
        return Math.round((reservedRooms / numberOfRooms) * 100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
