package hotelmng.service;

import hotelmng.model.hotel.Hotel;
import hotelmng.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {

    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @BeforeEach
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
    public void shouldNotAdd_HotelWithLessThenTenRooms() {
        //GIVEN
        Hotel hotel = new Hotel("abcd", 9);
        //doReturn(true).when(hotelRepository).add(any(Hotel.class));

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("NOT ENOUGH ROOMS", response);
    }

    @Test
    public void shouldNotAdd_HotelNameWithLessThenFourCharacters() {
        //GIVEN
        Hotel hotel = new Hotel("abc", 10);

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("NAME TOO SHORT", response);
    }

    @Test
    public void shouldNotAdd_HotelNameWithMoreThen15Characters() {
        //GIVEN
        Hotel hotel = new Hotel("Belvedere Hotel bla bla", 10);

        //WHEN
        String response = hotelService.validateAndAdd(hotel);

        //THEN
        assertEquals("NAME TOO LONG", response);
    }

}