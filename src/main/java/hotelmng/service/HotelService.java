package hotelmng.service;

import hotelmng.model.hotel.Hotel;
import hotelmng.repository.HotelRepository;
import org.apache.log4j.Logger;

/**
 * HotelService Class validates the action of addition and deletion of a hotel from the repository. Hotels that have
 * less then 10 rooms, have the name shorter then 4 characters or longer then 15 characters cannot be added to the
 * repository. A hotel that has rooms reserved can't be removed from the repository and a validation exception is thrown.
 */

public class HotelService {

    private Logger logger = Logger.getLogger("HotelService");

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public String validateAndAdd(Hotel hotel) {

        String name = hotel.getName();
        int numberOfRooms = hotel.getNumberOfRooms();

        if (numberOfRooms < 10) {
            logger.debug("Not enough rooms");
            return "NOT ENOUGH ROOMS";
        }

        if (name.length() < 4) {
            logger.debug("Name too short");
            return "NAME TOO SHORT";
        }

        if (name.length() > 15) {
            logger.debug("Name too long");
            return "NAME TOO LONG";
        }

        hotelRepository.add(hotel);
        return "HOTEL ADDED TO REPO";

    }

}
