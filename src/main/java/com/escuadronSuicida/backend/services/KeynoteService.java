package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import com.escuadronSuicida.backend.models.Keynote;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KeynoteService {

    List<Keynote> findKeynote();

    Keynote findById(Long id);

    Keynote createKeynote(Keynote keynote);

    Keynote updateKeynote(Long id, Keynote keynote);

    boolean deleteKeynote(Long id);

}