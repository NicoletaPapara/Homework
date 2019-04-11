package hotelmng.bookingsyst;

/**
 * This class models a reservation and will allow the creation and cancellation of a reservation
 */

public class Reservation {
    private String checkInDate;
    private String checkOutDate;
    private Client client;
    private String mealPreference;

    public Reservation(String checkInDate, String checkOutDate, Client client) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.client = client;
    }

    public Reservation(String checkInDate, String checkOutDate, Client client, String mealPreference) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.client = client;
        this.mealPreference = mealPreference;
    }
}
