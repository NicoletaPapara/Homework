package hotelmng.repository;

import hotelmng.models.hotel.Hotel;
import java.util.List;

public interface IHotelRepository {
    public void add(Hotel hotel);
    public void delete(Hotel hotel);
    public List<Hotel> listHotels();
}

