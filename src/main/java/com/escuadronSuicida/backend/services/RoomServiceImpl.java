package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Room;
import com.escuadronSuicida.backend.repository.RoomRepository;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public List<Room> findRoomVisibleTrue() {
        return roomRepository.findAllByVisibleTrue();
    }
    @Override
    public List<Room> findAll() {
        return this.roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return this.roomRepository.findById(id).orElseThrow();
    }

    @Override
    public Room createRoom(Room room) {
       Logger logger = LoggerFactory.getLogger(Room.class);
        try {
            return roomRepository.save(room);
        } catch (Exception e) {
            // Registrar el error
            logger.error("Hubo un error al crear room", e);

            // Lanzar una nueva excepción
            throw new RuntimeException("Hubo un error al crear room: " + e.getMessage(), e);
        }
    }

    @Override
    public Room updateRoomById(Long id, Room room) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room roomFromDatabase = roomOptional.get();
            roomFromDatabase.setName(room.getName());
            roomFromDatabase.setCapacity(room.getCapacity());
            roomFromDatabase.setHasSockets(room.getHasSockets());
            
            return roomRepository.save(roomFromDatabase);

            // esto es actualizar solo esos atributos como sea necesario.
        } else {
            return null;
        }
       
    }

    @Override
    public void deleteRoomById(Long id) {
    }
}
