package hotelmng.model.hotel;

import hotelmng.CheckInData;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

/**
 * This class models a hotel.
 */

@Getter
@Setter
@ToString

public class Hotel implements Serializable {

    private int numberOfRooms;
    private String name;
    private String address;
    private int capacity;
    private UUID id;
    private LinkedList<CheckInData> checkInDataList = new LinkedList<>();


    public Hotel(String name, int numberOfRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;

        this.id = UUID.randomUUID();
    }

    public Hotel(String name, String address, int numberOfRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.address = address;

        this.id = UUID.randomUUID();
    }
}
