package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Room;

import java.util.List;

public interface RoomService {
    List<Room> findRoom();
    Room findById(Long id);
}
