package hotelmng.service;

import hotelmng.model.hotel.Reservation;
import hotelmng.repository.ReservationRepository;
import hotelmng.repository.ReservationValidationException;
import org.apache.log4j.Logger;

public class ReservationService {

    private Logger logger = Logger.getLogger("ReservationService");

    private ReservationRepository reservationRepository = new ReservationRepository();

    public void validateAndAdd(Reservation reservation){
        try{
            reservationRepository.addReservation(reservation);
        }
        catch (ReservationValidationException e){
            logger.error(e.getMessage());
        }
    }
}
