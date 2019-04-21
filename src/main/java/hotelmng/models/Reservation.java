package hotelmng.models;

import hotelmng.models.hotel.Room;
import hotelmng.models.person.Client;

import java.util.Date;

/**
 * This class models a reservation and will allow the creation and cancellation of a reservation
 */

public class Reservation {
    private Date checkInDate;
    private Date checkOutDate;
    private Client client;
    private String mealPreference;
    private Room room;

    public Reservation(Date checkInDate, Date checkOutDate, Client client, Room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.client = client;
        this.room = room;
    }

    public Reservation(Date checkInDate, Date checkOutDate, Client client, String mealPreference, Room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.client = client;
        this.mealPreference = mealPreference;
        this.room = room;
    }
}
