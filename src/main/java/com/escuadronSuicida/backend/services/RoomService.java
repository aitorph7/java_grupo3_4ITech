package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoomService {
    List<Room> findAll();
    Room findById(Long id);
    Room createRoom(Room room);
    Room updateRoomById(Long id, Room room);
    void deleteRoomById(Long id);
}
