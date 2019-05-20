package hotelmng.repository;

import hotelmng.exception.ReservationValidationException;
import hotelmng.model.hotel.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationRepositoryTest {

    private ReservationRepository reservations;

    @BeforeEach
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

    @Test
    public void shouldThrowExceptionWhenDatesAreNotValid() throws ParseException, ReservationValidationException {
        //GIVEN
        Reservation reservation = new Reservation("2019-05-08", "2019-05-02");

        //WHEN & THEN
        Assertions.assertThrows(ReservationValidationException.class, () -> reservations.addReservation(reservation));
    }
}