package hotelmng.service;

import hotelmng.model.hotel.Hotel;
import hotelmng.repository.HotelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

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

    @Test
    public void shouldNotAdd_HotelWithLessThenTenRooms(){
        //GIVEN
        Hotel hotel= new Hotel("abcd", 9);
        doReturn(true).when(hotelRepository).add(any(Hotel.class));

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("NOT ENOUGH ROOMS", response);
    }

    @Test
    public void shouldNotAdd_HotelNameWithLessThenFourCharacters(){
        //GIVEN
        Hotel hotel= new Hotel("abc", 10);

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("NAME TOO SHORT", response);
    }

    @Test
    public void shouldNotAdd_HotelNameWithMoreThen15Characters(){
        //GIVEN
        Hotel hotel= new Hotel("Belvedere Hotel bla bla", 10);

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("NAME TOO LONG", response);
    }

}