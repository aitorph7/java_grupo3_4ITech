package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.repository.KeynoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {

    private final KeynoteRepository repo;


    @Override
    public List<Keynote> findKeynote() {
        return repo.findAll();
    }

    @Override
    public Keynote findById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
