package hotelmng.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * This class models a room of the hotel
 */
@Getter
@Setter
@Builder
public class Room implements Serializable {

    private final int roomNumber;
    private boolean isReserved;
    private String name;

//    public Room(int roomNumber) {
//        this.roomNumber = roomNumber;
//    }
//
//    public Room(int roomNumber, boolean isReserved) {
//        this.roomNumber = roomNumber;
//        this.isReserved = isReserved;
//    }
//
//    public Room(int roomNumber, String name) {
//        this.roomNumber = roomNumber;
//        this.name = name;
//    }

    @Override
    public String toString() {
        return name + " (" + roomNumber + ") ";
    }
}
