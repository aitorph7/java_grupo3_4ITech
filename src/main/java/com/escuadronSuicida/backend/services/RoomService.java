package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(Long id);
    Room createRoom(Room room);
    Room updateRoomById(Long id, Room room);
    void deleteRoomById(Long id);
    List<Room> findRoomVisibleTrue();

}
