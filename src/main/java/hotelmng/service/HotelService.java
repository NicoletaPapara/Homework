package hotelmng.service;

import hotelmng.model.hotel.Hotel;
import hotelmng.repository.HotelRepository;

public class HotelService {

    private HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public String validateAndAdd(Hotel hotel) {

        String name = hotel.getName();
        int numberOfRooms = hotel.getNumberOfRooms();

        if (numberOfRooms < 10) {
            return "NOT ENOUGH ROOMS";
        }

        if (name.length() < 4) {
            return "NAME TOO SHORT";
        }

        if (name.length() > 15) {
            return "NAME TOO LONG";
        }

        hotelRepository.add(hotel);
        return "HOTEL ADDED TO REPO";

    }
    @SuppressWarnings({"deprecation"})
    public void validateAndRemove(Hotel hotel){
        if(hotel.checkHotelBookingStatus()!=0) {
            throw new RemoveHotelValidationException("Cannot remove the hotel as long as rooms are reserved");
        }
        hotelRepository.delete(hotel);
    }

}
