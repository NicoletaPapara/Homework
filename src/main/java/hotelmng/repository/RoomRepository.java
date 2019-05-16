package hotelmng.repository;


import hotelmng.model.hotel.Room;
import hotelmng.repository.interfaces.IRoomRepository;

import java.util.ArrayList;
import java.util.List;


public class RoomRepository implements IRoomRepository {

    private List<Room> rooms = new ArrayList<Room>();

    public void addRoom(Room room) {

        rooms.add(room);
    }

    public void deleteRoom(Room room) {
        rooms.remove(room);
    }

    @Override
    public List<Room> listRooms() {
        return rooms;
    }

}
