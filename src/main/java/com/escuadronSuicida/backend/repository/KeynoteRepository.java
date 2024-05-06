package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.KeynoteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.awt.print.Book;
import java.util.List;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {

    List<Keynote> findAllByTrack_Id(Long id);
    List<Keynote> findAllByTitle(String title);

    @Query("SELECT new com.escuadronSuicida.backend.models.KeynoteProjection(k.id, k.title, k.photoUrl) FROM Keynote k")

    List<KeynoteProjection> findAllProjection();

    @Query("""
    select k from Keynote k where upper(k.title) like %:title%
""")
    List<Keynote> findAllTitlesFilteringByTitle(@Param("title") String title);


    List<Keynote> findByVisibleTrue();


    List<Keynote> findAllByVisibleTrue();
}