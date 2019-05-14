package hotelmng.service;

import hotelmng.model.hotel.Reservation;
import hotelmng.repository.ReservationValidationException;

public interface IReservationRepository {

    public boolean addReservation(Reservation reservation) throws ReservationValidationException;
    public boolean deleteReservation(Reservation reservation);

}
