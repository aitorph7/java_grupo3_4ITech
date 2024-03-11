package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.repository.KeynoteRepository;
import com.escuadronSuicida.backend.services.KeynoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("keynote")
@AllArgsConstructor
@CrossOrigin("*")

public class KeynoteController {
    private KeynoteService keynoteService;

    @GetMapping
    public ResponseEntity<List<Keynote>> findAll(){
        List<Keynote> keynote = keynoteService.findKeynote();
        return ResponseEntity.ok(keynote);
    }

    @GetMapping("{id}")
    public ResponseEntity<Keynote> findById(@PathVariable Long id){
        Keynote keynote = keynoteService.findById(id);
        return ResponseEntity.ok(keynote);
    }

    private KeynoteRepository repo;

    @PostMapping("/keynotes")
    public ResponseEntity<Keynote> create(@RequestBody Keynote keynote) {

        try {
            return ResponseEntity.ok(repo.save(keynote));
        }catch (Exception e) {
            return ResponseEntity.status(409).build();
        }

    }


    @PutMapping("keynote/{id}")
    public Keynote update(@RequestBody Keynote keynote,@PathVariable Long id){
        return repo.save(keynote);
    }


    @DeleteMapping("keynote/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}