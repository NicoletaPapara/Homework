package hotelmng.service;

import hotelmng.models.hotel.Hotel;
import hotelmng.repository.HotelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTest {

    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @Before
    public void setup() {
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    public void shouldAddValidHotel() {
        //GIVEN
        Hotel hotel = new Hotel("Belvedere Hotel", 50);

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("HOTEL ADDED TO REPO", response);
    }
}