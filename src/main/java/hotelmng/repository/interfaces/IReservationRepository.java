package hotelmng.repository.interfaces;

import hotelmng.model.hotel.Reservation;
import hotelmng.exception.ReservationValidationException;

public interface IReservationRepository {

    public boolean addReservation(Reservation reservation) throws ReservationValidationException;
    public boolean deleteReservation(Reservation reservation);

}
