package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.repository.KeynoteRepository;
import com.escuadronSuicida.backend.services.KeynoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("keynotes")
@AllArgsConstructor
@CrossOrigin("*")

public class KeynoteController {
    private KeynoteService keynoteService;

    @GetMapping
    public ResponseEntity<List<Keynote>> findAll(){
        // keynoteService.findAllPublishedTrue();
        List<Keynote> keynote = keynoteService.findKeynote();
        return ResponseEntity.ok(keynote);
    }

    @GetMapping("{id}")
    public ResponseEntity<Keynote> findById(@PathVariable Long id){
        Keynote keynote = keynoteService.findById(id);
        return ResponseEntity.ok(keynote);
    }



    private KeynoteRepository repo;

    // obtener keynotes filtrando por track
    @GetMapping("/filter-by-track/{id}")
    public List<Keynote> findAllByTrackId (@PathVariable Long id) {
        return this.repo.findAllByTrack_Id(id);
    }


    @PostMapping
    public ResponseEntity<Keynote> create(@RequestBody Keynote keynote) {

        try {
            return ResponseEntity.ok(repo.save(keynote));
        }catch (Exception e) {
            return ResponseEntity.status(409).build();
        }

    }


    @PutMapping("{id}")
    public Keynote update(@RequestBody Keynote keynote,@PathVariable Long id){
        System.out.println(keynote);
        return repo.save(keynote);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        // TODO

        // Desasociar keynote de comentarios
        // commentRepository.findByKeynoteId()
        // for
        // setKeynote null
        // save comments


        // borrar
        // commentRepository.findByKeynoteId()
        // for
        // delete de cada comment
        repo.deleteById(id);
    }
}