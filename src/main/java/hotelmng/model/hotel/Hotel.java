package hotelmng.model.hotel;

import hotelmng.CheckInData;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

/**
 * This class models a hotel.
 */

@Getter
@Setter
public class Hotel implements Serializable {

    private final int numberOfRooms;
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

    @Override
    public String toString() {
        return this.name +
                " (" + this.address + ");";
    }
}
