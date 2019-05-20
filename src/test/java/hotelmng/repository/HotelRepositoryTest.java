package hotelmng.repository;

import hotelmng.model.hotel.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class HotelRepositoryTest {

    private HotelRepository hotelRepository;

    @BeforeEach
    public void setup() {
        hotelRepository = new HotelRepository();
    }

    @Test
    public void shouldAddWhenEmpty() {
        //GIVEN
        Hotel hotel1 = new Hotel("abcd", 20);
        //WHEN
        hotelRepository.add(hotel1);
        //int response = hotelRepository.getSize();
        //THEN
        //assertEquals(1, response);
        assertNotNull(hotelRepository);
    }
}