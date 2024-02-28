package com.escuadronSuicida.backend.Controller;

import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.services.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("tracks")
   public ResponseEntity<List<Track>> findAll() {
        List<Track> tracks = trackService.findTracks();
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("tracks/{id}")
    public ResponseEntity<Track> findById(@PathVariable Long id){
       Track track = trackService.findById(id);
       if (track!=null) {
           return ResponseEntity.ok(track);
       } else {
           return ResponseEntity.notFound().build();
       }
    }
   @PostMapping("tracks")
    public ResponseEntity<Track> createTrack(@RequestBody Track track) {
        Track createdTrack = trackService.createTrack(track);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrack);
        //return ResponseEntity.ok(trackRepository.save(track)); es lo mismo

   }
    @PutMapping("tracks/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track track) {
        Track updatedTrack = trackService.updateTrack(id,track);
        if (updatedTrack != null) {
            return ResponseEntity.ok(updatedTrack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("tracks/{id}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
           boolean deleted = trackService.deleteTrack(id);
           if (deleted) {
               return ResponseEntity.noContent().build();
           } else {
               return ResponseEntity.notFound().build();
           }


    }
}
