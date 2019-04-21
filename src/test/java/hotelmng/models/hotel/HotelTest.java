package hotelmng.models.hotel;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    @Test
    public void checkStatus() {

        //GIVEN
        Hotel hotel = new Hotel("abcd", 10);
        hotel.getRoom(2).setReserved(true);
        hotel.getRoom(4).setReserved(true);
        hotel.getRoom(5).setReserved(true);

        //WHEN
        int response = hotel.checkStatus();

        //THEN
        assertEquals(30, response);

    }
}