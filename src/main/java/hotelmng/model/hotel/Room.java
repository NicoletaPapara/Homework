package hotelmng.model.hotel;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * This class models a room of the hotel
 */
@Getter
@Setter
public class Room implements Serializable {

    Logger logger = Logger.getLogger("Room");

    private final int roomNumber;
    private boolean isReserved;
    private String name;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(int roomNumber, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.isReserved = isReserved;
    }

    public Room(int roomNumber, String name) {
        this.roomNumber = roomNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + roomNumber + ") ";
    }
}
