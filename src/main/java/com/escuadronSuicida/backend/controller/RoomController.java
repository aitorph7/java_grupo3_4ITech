package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Room;
import com.escuadronSuicida.backend.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class RoomController {
    List<Room> rooms;
    private final RoomRepository roomRepository;

    @GetMapping("rooms")
    public List<Room> findAll(){
        return roomRepository.findAll();
    }
    @GetMapping("room/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent())
            return ResponseEntity.ok(roomOptional.get());
        else
            return ResponseEntity.notFound().build();
    }
}
