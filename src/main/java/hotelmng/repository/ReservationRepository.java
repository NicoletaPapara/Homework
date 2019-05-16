package hotelmng.repository;

import hotelmng.exception.ReservationValidationException;
import hotelmng.model.hotel.Reservation;
import hotelmng.repository.interfaces.IReservationRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements IReservationRepository {

    private List<Reservation> reservations = new ArrayList<Reservation>();

    public boolean addReservation(Reservation reservation) throws ReservationValidationException {

        if (reservation.getCheckInDate().compareTo(reservation.getCheckOutDate()) >= 0) {
            throw new ReservationValidationException("Check in date must be set before check out date");
        }
        reservations.add(reservation);
        return true;
    }

    public boolean deleteReservation(Reservation reservation) {
        reservations.remove(reservation);
        return true;
    }
}
