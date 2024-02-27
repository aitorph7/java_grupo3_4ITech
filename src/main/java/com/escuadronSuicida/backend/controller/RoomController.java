package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Room;
import com.escuadronSuicida.backend.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("rooms/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent())
            return ResponseEntity.ok(roomOptional.get());
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("rooms")
    public ResponseEntity<Room> create(@RequestBody Room room){
        return ResponseEntity.ok(roomRepository.save(room));
    }
    @PutMapping("rooms/{íd}")
    public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody Room room){
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        roomOptional.get().setCapacity(room.getCapacity());
        roomOptional.get().setKeynotes(room.getKeynotes());
        return ResponseEntity.ok(roomRepository.save(roomOptional.get()));
    }
    @DeleteMapping("rooms/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        roomRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
