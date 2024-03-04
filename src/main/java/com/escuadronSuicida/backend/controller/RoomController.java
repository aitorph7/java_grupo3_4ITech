package com.escuadronSuicida.backend.Controller;

import com.escuadronSuicida.backend.models.Room;
import com.escuadronSuicida.backend.repository.RoomRepository;
import com.escuadronSuicida.backend.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    List<Room> rooms;
    private final RoomRepository roomRepository;

    public RoomController(RoomService service, RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @GetMapping("rooms")
    public ResponseEntity<List<Room>> findAll(){
        return ResponseEntity.ok(roomRepository.findAll());
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
    @PutMapping("rooms/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody Room room){
        if(!roomRepository.existsById(id)) return ResponseEntity.notFound().build();
        Optional<Room> roomOptional = roomRepository.findById(id);
        if(roomOptional.isPresent()){
            Room roomFromDB = roomOptional.get();
            roomFromDB.setCapacity(room.getCapacity()); // este método solo permite modificar el aforo de la sala.
            roomRepository.save(roomFromDB);
            return ResponseEntity.ok(roomFromDB);
        } else
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("rooms/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        roomRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
