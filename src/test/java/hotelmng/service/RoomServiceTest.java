package hotelmng.service;

import hotelmng.exception.RoomValidationException;
import hotelmng.model.room.Room;
import hotelmng.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    public void setup() {
        roomService = new RoomService(roomRepository);
    }

    @Test
    public void shouldAddRoomWhenRoomNumberIsValid() throws RoomValidationException {
        //GIVEN
        Room room = Room.builder().roomNumber(51).isReserved(false).build();

        //WHEN & THEN
        roomService.addRoom(room);
//        roomRepository.add(room);
        verify(roomRepository, times(0)).add(room);
    }

}