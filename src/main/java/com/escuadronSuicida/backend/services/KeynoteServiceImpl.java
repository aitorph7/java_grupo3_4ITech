package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.Track;
import com.escuadronSuicida.backend.repository.KeynoteRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {

    private final KeynoteRepository keynoteRepository;


    @Override
    public List<Keynote> findKeynote() {
        return keynoteRepository.findAll();
    }

    @Override
    public Keynote findById(Long id) {
        return keynoteRepository.findById(id).orElseThrow();
    }

    @Override
    public Keynote createKeynote(Keynote keynote) {
        Logger logger = LoggerFactory.getLogger(Keynote.class);
        try {
            return keynoteRepository.save(keynote);
        } catch (Exception e) {
            // Registrar el error
            logger.error("Hubo un error al crear el keynote", e);

            // Lanzar una nueva excepción
            throw new RuntimeException("Hubo un error al crear el keynote: " + e.getMessage(), e);
        }
    }

    @Override
    public Keynote updateKeynote(Long id, Keynote keynote) {
        Optional<Keynote> keynoteOptional = keynoteRepository.findById(id);
        if (keynoteOptional.isPresent()) {
            Keynote keynoteFromDatabase = keynoteOptional.get();
            keynoteFromDatabase.setTitle(keynote.getTitle());
            keynoteFromDatabase.setSummary(keynote.getSummary());
            keynoteFromDatabase.setDescription(keynote.getDescription());
            keynoteFromDatabase.setWebinarUrl(keynote.getWebinarUrl());
 /*           keynoteFromDatabase.setStartDate(keynote.getStartDate());
            trackFromDatabase.setEndDate(keynote.getEndDate()); */
            return keynoteRepository.save(keynoteFromDatabase);

            // esto es actualizar solo esos atributos como sea necesario, aunque en este caso son todos.
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteKeynote(Long id) {
        Optional<Keynote> keynoteOptional = keynoteRepository.findById(id);
        if (keynoteOptional.isPresent()) {
            keynoteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
