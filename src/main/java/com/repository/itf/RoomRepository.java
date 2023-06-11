package com.repository.itf;

import com.bean.Room;

import java.util.List;


public interface RoomRepository {
    List<Room> display();

    void delete(int id);

    void create (Room room);

    List<Room> search(String str);
}
