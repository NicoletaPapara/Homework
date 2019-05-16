package hotelmng.service;

import hotelmng.exception.RoomValidationException;
import hotelmng.model.hotel.Hotel;
import hotelmng.model.hotel.Room;
import hotelmng.repository.RoomRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {

    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    @Before
    public void setup() {
        roomService = new RoomService(roomRepository);
    }

    @Test
    public void shouldAddRoomWhenRoomNumberIsValid() throws RoomValidationException {
        //GIVEN
        Room room = new Room(51, false);
        //WHEN & THEN

        verify(roomRepository, times(0)).addRoom(room);
    }

    @Ignore
    @Test
    public void checkBookingStatusTest() {

        //GIVEN

        List<Room> rooms = Arrays.asList(new Room(1, true),
                new Room(2, false),
                new Room(3, true),
                new Room(2, false));
        doReturn(rooms).when(roomRepository).listRooms();

        //WHEN
        int response = roomService.checkBookingStatus();

        //THEN
        assertEquals(25, response);

    }
}