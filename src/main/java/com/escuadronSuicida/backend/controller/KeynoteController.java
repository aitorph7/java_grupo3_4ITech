package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.exception.ConflictDeleteException;
import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.KeynoteProjection;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.*;
import com.escuadronSuicida.backend.security.SecurityUtils;
import com.escuadronSuicida.backend.services.FileService;
import com.escuadronSuicida.backend.services.KeynoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("keynotes")
@AllArgsConstructor
@CrossOrigin("*")
@Slf4j
public class KeynoteController {
    private final UserRepository userRepository;
    private KeynoteService keynoteService;
    private FileService fileService;
    private KeynoteRepository repo;
    private CommentRepository commentRepository;
    private RoomRepository roomRepository;
    private TrackRepository trackRepository;


    @GetMapping
    public ResponseEntity<List<Keynote>> findAll() {
        // keynoteService.findAllPublishedTrue();
        List<Keynote> keynote = keynoteService.findKeynoteVisibleTrue();
        return ResponseEntity.ok(keynote);

//        User user = SecurityUtils.getCurrentUser().orElseThrow();
//
//        if(user.getUserRole().equals(UserRole.ADMIN))
//            return ResponseEntity.ok(this.repo.findAll());
//        else
//            return ResponseEntity.ok(this.repo.findByVisibleTrue());
    }

    @GetMapping("projections/home")

    public ResponseEntity<List<KeynoteProjection>> findAllProjection() {

        return ResponseEntity.ok(repo.findAllProjection());
    }

    @GetMapping("{id}")
    public ResponseEntity<Keynote> findById(@PathVariable Long id) {
        Keynote keynote = keynoteService.findById(id);
        return ResponseEntity.ok(keynote);
    }


    // obtener keynotes filtrando por track
    @GetMapping("/filter-by-track/{id}")
    public List<Keynote> findAllByTrackId(@PathVariable Long id) {
        return this.repo.findAllByTrack_Id(id);
    }


//    @PostMapping
//    public ResponseEntity<Keynote> create(@RequestBody Keynote keynote) {
//
//        try {
//            return ResponseEntity.ok(repo.save(keynote));
//        }catch (Exception e) {
//            return ResponseEntity.status(409).build();
//        }
//    }

    // Extra OPCIONAL: además del CRUD permitimos subir archivos
    // Guardar el archivo y obtener la ruta al archivo y guardar la ruta en photoUrl
    // Nuevo controlador para servir los archivos
    @PostMapping()
    public Keynote create(
            @RequestParam(value = "photo", required = false) MultipartFile file, Keynote keynote) {

        if (file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            keynote.setPhotoUrl(fileName);
        } else {
            keynote.setPhotoUrl("avatar.png");
        }

        return this.repo.save(keynote);
    }


    @PutMapping("{id}")
    public ResponseEntity<Keynote> update(@RequestParam(value = "photo", required = false) MultipartFile file,
                                          Keynote keynote,
                                          @PathVariable Long id) {

        if (!this.repo.existsById(id))
            return ResponseEntity.notFound().build();

        if (file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            keynote.setPhotoUrl(fileName);
        }

        return ResponseEntity.ok(this.repo.save(keynote));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
//        // TODO
//        try {
//            this.commentRepository.deleteByKeynoteId(id);
//            this.repo.deleteById(id);
//        } catch (Exception e) {
//            log.error("Error borrando Keynote", e);
//            throw new ConflictDeleteException("No es posible borrar la charla.");
//        }


        // Desasociar keynote de comentarios
        // commentRepository.findByKeynoteId()
        // for
        // setKeynote null
        // save comments
    Keynote keynote = this.repo.findById(id).orElseThrow();
        keynote.setVisible(false);
        repo.save(keynote);

        // borrar
        // commentRepository.findByKeynoteId()
        // for
        // delete de cada comment
        // repo.deleteById(id);

    }
}

