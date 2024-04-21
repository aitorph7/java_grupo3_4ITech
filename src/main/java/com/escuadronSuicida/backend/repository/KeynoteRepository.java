package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {

    List<Keynote> findAllByTrack_Id(Long id);



}