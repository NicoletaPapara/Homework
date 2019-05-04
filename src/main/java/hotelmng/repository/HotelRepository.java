package hotelmng.repository;

import hotelmng.model.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements IHotelRepository {

    private List<Hotel> hotelList = new ArrayList<Hotel>();

    public boolean add(Hotel hotel) {
        hotelList.add(hotel);
        return true;
    }

    public void delete(Hotel hotel) {
        hotelList.remove(hotel);
    }

    public List<Hotel> listHotels() {
        return hotelList;
    }

    public int getSize() {
        return hotelList.size();
    }
}

