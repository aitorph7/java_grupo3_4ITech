package com.escuadronSuicida.backend.Controller;

import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class TrackController {

    private final TrackRepository trackRepository;

    @GetMapping("tracks")
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @GetMapping("tracks/{id}")
    public ResponseEntity<Track> findById(@PathVariable Long id){
        Optional<Track> trackOptional = trackRepository.findById(id);

        if(trackOptional.isPresent()){
            return ResponseEntity.ok(trackOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        // Metodo Funcional equivalente al if - else:
        //return trackOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("tracks")
    public ResponseEntity<Track> create(@RequestBody Track track) {
        return ResponseEntity.ok(trackRepository.save(track));
    }
    @PutMapping("tracks/{id}")
    public ResponseEntity<Track> update(@PathVariable Long id, @RequestBody Track track) {
        Optional<Track> trackOpt = trackRepository.findById(id);

        if(trackOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }  // permitir solo actualizar estos atributos y no todos
        trackOpt.get().setStartDate(track.getStartDate());
        trackOpt.get().setEndDate(track.getEndDate());
        return ResponseEntity.ok(trackRepository.save(trackOpt.get()));
    }
    @DeleteMapping("tracks")
    public ResponseEntity<Void> deleteAll() {
        // No será habitual Borrar completo Ya que si hay asociaciones puede dar problemas claves foraneas o hay que desasociar
        trackRepository.deleteAll();
        return ResponseEntity.noContent().build(); // 204 ?
    }
        @DeleteMapping("tracks/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
            // SE puede agregar un repo.existsById(id)
            trackRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204


    }
}
