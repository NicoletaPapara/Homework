package hotelmng.service;

import hotelmng.exception.RoomValidationException;
import hotelmng.model.hotel.Room;
import hotelmng.repository.RoomRepository;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;


public class RoomService {

    private static Logger logger = Logger.getLogger("RoomService");

    private RoomRepository roomRepository = new RoomRepository();

    public RoomService(RoomRepository roomRepository) {

    }

    public boolean addRoom(Room room) throws RoomValidationException {

        if (room.getRoomNumber() < 1) {
            throw new RoomValidationException("Number of rooms not valid");
        }
        roomRepository.addRoom(room);
        return true;
    }


    public int checkBookingStatus(){

        int reservedRooms = 0;
        List<Room> rooms = roomRepository.listRooms();
        Iterator<Room> i = rooms.iterator();

        while(i.hasNext()){
            if(i.next().isReserved() == true) {
                reservedRooms+=1;
                }

        }
        return (reservedRooms*100)/(roomRepository.listRooms().size());
    }

}
