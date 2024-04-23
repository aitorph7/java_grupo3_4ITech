package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.KeynoteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {

    List<Keynote> findAllByTrack_Id(Long id);

    @Query("SELECT new com.escuadronSuicida.backend.models.KeynoteProjection(k.id, k.title, k.photoUrl) FROM Keynote k")

    List<KeynoteProjection> findAllProjection();


}