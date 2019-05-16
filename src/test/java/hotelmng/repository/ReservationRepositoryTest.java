package hotelmng.repository;

import hotelmng.model.hotel.Reservation;
import hotelmng.exception.ReservationValidationException;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class ReservationRepositoryTest {

    private ReservationRepository reservations;

    @Before
    public void setup() {
        reservations = new ReservationRepository();
    }


    @Test
    public void shouldAddValidReservation() throws ParseException, ReservationValidationException {
        //GIVEN
        Reservation reservation = new Reservation("2019-05-04", "2019-05-08");
        //WHEN
        boolean result = reservations.addReservation(reservation);
        //THEN
        assertTrue(result);
    }

    @Test(expected = ReservationValidationException.class)
    public void shouldThrowExceptionWhenDatesAreNotValid() throws ParseException, ReservationValidationException {
        //GIVEN
        Reservation reservation = new Reservation("2019-05-08", "2019-05-02");

        //WHEN
        reservations.addReservation(reservation);
    }
}