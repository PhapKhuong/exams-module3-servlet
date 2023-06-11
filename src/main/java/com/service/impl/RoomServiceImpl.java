package com.service.impl;

import com.bean.Room;
import com.repository.impl.RoomRepositoryImpl;
import com.repository.itf.RoomRepository;
import com.service.itf.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomRepository repository = new RoomRepositoryImpl();
    @Override
    public List<Room> display() {
        return repository.display();
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void create(Room room) {
        repository.create(room);
    }

    @Override
    public List<Room> search(String str) {
        return repository.search(str);
    }
}
