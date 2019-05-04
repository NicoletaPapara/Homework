package hotelmng.repository;

import hotelmng.model.hotel.Hotel;
import java.util.List;

public interface IHotelRepository {
    public boolean add(Hotel hotel);
    public void delete(Hotel hotel);
    public List<Hotel> listHotels();
}

