package hotelmng.repository.interfaces;

import hotelmng.model.hotel.Room;

import java.util.List;

public interface IRoomRepository {

    public void addRoom(Room room);
    public void deleteRoom(Room room);

    public List<Room> listRooms();
}
