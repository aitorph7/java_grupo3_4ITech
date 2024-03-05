package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Keynote;


import java.util.List;


public interface KeynoteService {

    List<Keynote> findKeynote();

    Keynote findById(Long id);


}