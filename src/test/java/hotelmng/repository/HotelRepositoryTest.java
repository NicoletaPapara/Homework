package hotelmng.repository;

import hotelmng.model.hotel.Hotel;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class HotelRepositoryTest {

    private HotelRepository hotelRepository;

    @Before
    public void setup() {
        hotelRepository = new HotelRepository();
    }

    @Test
    public void shouldAddWhenEmpty() {
        //GIVEN
        Hotel hotel1 = new Hotel("abcd", 20);
        //WHEN
        hotelRepository.add(hotel1);
        int response = hotelRepository.getSize();
        //THEN
        assertEquals(1, response);
    }
}