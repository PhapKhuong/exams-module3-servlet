package com.service.itf;

import com.bean.Room;

import java.util.List;

public interface RoomService {
    List<Room> display();

    void delete(int id);

    void create(Room room);

    List<Room> search(String str);
}
