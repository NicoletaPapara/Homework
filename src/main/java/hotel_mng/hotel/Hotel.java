package hotel_mng.hotel;

/**
 * This class models a hotel. It has a collection of rooms.
 */

public class Hotel {

    final private int numberOfRooms;
    private String name;
    private String address;
    private int capacity;
    private Room[] rooms;

    public Hotel(String name, String address, int numberOfRooms) {
        this.name = name;
        this.address = address;
        this.numberOfRooms = numberOfRooms;

        //creates the rooms of the hotel based on number of rooms set

        for (int i=0; i<numberOfRooms; i++){
            rooms[i] = new Room(i+1);
        }
    }



}
