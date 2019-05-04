package hotelmng.model.hotel;

import hotelmng.model.person.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class models a reservation and will allow the creation and cancellation of a reservation
 */

public class Reservation {

    private String checkInDateString;
    private String checkOutDateString;
    private Date checkInDate;
    private Date checkOutDate;
    private Client client;
    private MealPreference mealPreference;
    private Room room;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Reservation(String checkInDateString, String checkOutDateString) throws ParseException {
        this.checkInDateString = checkInDateString;
        this.checkOutDateString = checkOutDateString;

        checkInDate = format.parse(checkInDateString);
        checkOutDate = format.parse(checkOutDateString);

    }


    public Reservation(String checkInDateString, String checkOutDateString, Client client, Room room) {
        this.checkInDateString = checkInDateString;
        this.checkOutDateString = checkOutDateString;
        this.client = client;
        this.room = room;
    }

    public Reservation(String checkInDateString, String checkOutDateString, Client client, MealPreference mealPreference, Room room) {
        this.checkInDateString = checkInDateString;
        this.checkOutDateString = checkOutDateString;
        this.client = client;
        this.mealPreference = mealPreference;
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
}
