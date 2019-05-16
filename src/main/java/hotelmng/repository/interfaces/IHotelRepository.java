package hotelmng.repository.interfaces;

import hotelmng.model.hotel.Hotel;
import java.util.List;

/**
 * HotelRepository is a class that stores hotel in a list and allows the addtion, deletion and listing of the hotels in that list
 */

public interface IHotelRepository {
    public boolean add(Hotel hotel);
    public void delete(Hotel hotel);
    public List<Hotel> listHotels();
}

