package hotelmng.repository;


import hotelmng.repository.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;


public class RoomRepository<T> implements IRepository<T> {

    private List<T> rooms = new ArrayList<>();

    @Override
    public void add(T o) {
        rooms.add(o);
    }

    @Override
    public void delete(T o) {
        rooms.remove(o);
    }

    @Override
    public List<T> list() {
        return rooms;
    }
}
