package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.exception.ConflictDeleteException;
import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.CommentRepository;
import com.escuadronSuicida.backend.repository.KeynoteRepository;
import com.escuadronSuicida.backend.repository.TrackRepository;
import com.escuadronSuicida.backend.security.SecurityUtils;
import com.escuadronSuicida.backend.services.TrackService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class TrackController {

    List<Track> tracks;


    private final TrackService trackService;
    private TrackRepository trackRepository;
    private  CommentRepository commentRepository;
    private  KeynoteRepository keynoteRepository;

 

    @GetMapping("tracks")
   public ResponseEntity<List<Track>> findAll() {
        System.out.println("invocando findAll de tracks");
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
        public void deleteById(@PathVariable Long id) {


           // Opción : borrar el track, pero antes desasociar o borrar aquellos objetos que apunten track
        Track track = this.trackRepository.findById(id).orElseThrow();
        User user = SecurityUtils.getCurrentUser().orElseThrow();

        if (user.getUserRole().equals(UserRole.ADMIN)
        )
        try {
            this.commentRepository.deleteByKeynoteId(id);
            this.keynoteRepository.deleteByTrackId(id);
            this.trackRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error borrando track", e);
            throw new ConflictDeleteException("No es posible borrar el track.");
        }
    }
                // OPCION mejor TODO: Archivar tracks y rooms da menos problemas,
               //.. (al no tener que borrar asociaciones), con las Foreing keys


    // @DeleteMapping("tracks/{id}")
    // public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
    //        boolean deleted = trackService.deleteTrack(id);
    //        if (deleted) {
    //            return ResponseEntity.noContent().build();
    //        } else {
    //            return ResponseEntity.notFound().build();
    //        }
    // }
}
// Otra forma llamando el controlador directamente al repositorio sería:
// @AllArgsConstructor
// @RestController
// public class TrackController {
//     private final TrackRepository trackRepository;

//     @GetMapping("tracks")
//     public List<Track> findAll() {
//         return trackRepository.findAll();
//     }

//     @GetMapping("tracks/{id}")
//     public ResponseEntity<Track> findById(@PathVariable Long id){
//         Optional<Track> trackOptional = trackRepository.findById(id);

//         if(trackOptional.isPresent()){
//             return ResponseEntity.ok(trackOptional.get());
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//         // Metodo Funcional equivalente al if - else:
//         //return trackOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//     }
//     @PostMapping("tracks")
//     public ResponseEntity<Track> create(@RequestBody Track track) {
//         return ResponseEntity.ok(trackRepository.save(track));
//     }
//     @PutMapping("tracks/{id}")
//     public ResponseEntity<Track> update(@PathVariable Long id, @RequestBody Track track) {
//         Optional<Track> trackOpt = trackRepository.findById(id);

//         if(trackOpt.isEmpty()){
//             return ResponseEntity.notFound().build();
//         }  // permitir solo actualizar estos atributos y no todos

//         trackOpt.get().setName(track.getName());
//         trackOpt.get().setStartDate(track.getStartDate());
//         trackOpt.get().setEndDate(track.getEndDate());
//         return ResponseEntity.ok(trackRepository.save(trackOpt.get()));
//     }
//     @DeleteMapping("tracks")
//     public ResponseEntity<Void> deleteAll() {
//         // No será habitual Borrar completo Ya que si hay asociaciones puede dar problemas claves foraneas o hay que desasociar
//         trackRepository.deleteAll();
//         return ResponseEntity.noContent().build(); // 204 ?
//     }
//         @DeleteMapping("tracks/{id}")
//     public ResponseEntity<Void> deleteById(@PathVariable Long id) {
//             // SE puede agregar un repo.existsById(id)
//             trackRepository.deleteById(id);
//             return ResponseEntity.noContent().build(); // 204


//     }
// }

